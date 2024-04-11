package com.DailyDash.AccountManagement.services;
import com.DailyDash.AccountManagement.entity.City;
import com.DailyDash.AccountManagement.exceptions.CityNotFoundException;
import com.DailyDash.AccountManagement.repository.CityRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
public class CityServices {

    private final CityRepository cityRepository;
    private Logger logger = LoggerFactory.getLogger(CityServices.class);

    @Autowired
    public CityServices(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    //Function only adds the City to the database if there isn't already an existing version
    public Optional<City> addCity(String cityName){
        logger.info("about to begin adding the city");
        Optional<City> optionalCity = this.findCityInfo(cityName);

        //City is not in the database yet, and there is a city, it will be added
        if (!this.doesCityExistsInDB(cityName) && optionalCity.isPresent()) {
            optionalCity =  Optional.of(cityRepository.save(optionalCity.get()));
        } return optionalCity;
    }



    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public Optional<City> findCityInfo(String cityToFind) {
        Resource resource = new ClassPathResource("data/citiesData.csv");

        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            List<City> cities = new CsvToBeanBuilder<City>(reader)
                    .withType(City.class)
                    .build()
                    .parse();

            return cities.stream()
                    .filter(cityInfo -> cityInfo.getCityName() != null && cityInfo.getCityName().equalsIgnoreCase(cityToFind))
                    .findFirst();

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.ofNullable(null);
        }
    }

    public Boolean doesCityExistsInDB(String cityName){
        return cityRepository.existsByCityName(cityName);
    }


}
