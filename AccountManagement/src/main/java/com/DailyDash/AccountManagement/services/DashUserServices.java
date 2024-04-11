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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashUserServices {

    private static final Logger logger = LoggerFactory.getLogger(DashUserServices.class);
    private final DashUserRepository dashUserRepository;
    private final CityRepository cityRepository;
    private final CityServices cityServices;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DashUserServices(DashUserRepository dashUserRepository, CityServices cityServices, CityRepository cityRepository, PasswordEncoder passwordEncoder){
        this.dashUserRepository = dashUserRepository;
        this.cityServices = cityServices;
        this.cityRepository = cityRepository;
        this.passwordEncoder = passwordEncoder;
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

    //Method for when the user logs in
    public boolean verifyUser(LoginDTO loginDTO) {
        Optional<DashUser> optionalDashUser = dashUserRepository.findDashUserByEmail(loginDTO.getEmail());
        if (optionalDashUser.isPresent()) {
            DashUser user = optionalDashUser.get();
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
                logger.info("User verified: {}", loginDTO.getEmail());
                return true;
            } else {
                logger.info("Incorrect password for user: {}", loginDTO.getEmail());
                return false;
            }
        } else {
            logger.info("User not found: {}", loginDTO.getEmail());
            return false;
        }
    }

    //Method for deleting the user
    public void deleteUser(Long id){
        Optional<DashUser> optionalDashUser = dashUserRepository.findById(id);
        if (optionalDashUser.isPresent()) {
            dashUserRepository.delete(optionalDashUser.get());
        } else {
            logger.info("the {} is not tied to a real user", id);
        }
    }
}