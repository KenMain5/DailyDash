package com.DailyDash.AccountManagement.repository;

import com.DailyDash.AccountManagement.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findCityByCityName(String cityName);
    Boolean existsByCityName(String cityName);
}
