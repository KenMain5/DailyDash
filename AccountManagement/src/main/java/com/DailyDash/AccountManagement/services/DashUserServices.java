package com.DailyDash.AccountManagement.services;

import com.DailyDash.AccountManagement.dto.LoginDTO;
import com.DailyDash.AccountManagement.dto.RegisterDTO;
import com.DailyDash.AccountManagement.entity.City;
import com.DailyDash.AccountManagement.entity.DashUser;
import com.DailyDash.AccountManagement.repository.CityRepository;
import com.DailyDash.AccountManagement.repository.DashUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashUserServices {

    private static final Logger logger = LoggerFactory.getLogger(DashUserServices.class);
    private final DashUserRepository dashUserRepository;
    private final CityRepository cityRepository;
    private final CityServices cityServices;

    @Autowired
    public DashUserServices(DashUserRepository dashUserRepository, CityServices cityServices, CityRepository cityRepository){
        this.dashUserRepository = dashUserRepository;
        this.cityServices = cityServices;
        this.cityRepository = cityRepository;
    }

    public DashUser convertToDasher(RegisterDTO registerDTO, City city){
        DashUser tempDashUser = new DashUser();
        tempDashUser.setFirstName(registerDTO.getFirstName());
        tempDashUser.setEmail(registerDTO.getEmail());
        tempDashUser.setPassword(registerDTO.getPassword());
        tempDashUser.setCity(city);
        logger.info(tempDashUser.toString());
        return tempDashUser;
    }

    public boolean verifyUser(LoginDTO loginDTO){
        Optional<DashUser> optionalDashUser= dashUserRepository.findDashUserByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        if (optionalDashUser.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteUser(Long id){
        Optional<DashUser> optionalDashUser = dashUserRepository.findById(id);
        if (optionalDashUser.isPresent()) {
            dashUserRepository.delete(optionalDashUser.get());
        } else {
            logger.info("the {} is not tied to a real user", id);
        }
    }
}