package com.DailyDash.AccountManagement.services.implementation;

import com.DailyDash.AccountManagement.dto.LoginDTO;
import com.DailyDash.AccountManagement.dto.RegisterDTO;
import com.DailyDash.AccountManagement.entity.City;
import com.DailyDash.AccountManagement.entity.DashUser;
import com.DailyDash.AccountManagement.entity.Role;
import com.DailyDash.AccountManagement.repository.CityRepository;
import com.DailyDash.AccountManagement.repository.DashUserRepository;
import com.DailyDash.AccountManagement.response.LoginResponse;
import com.DailyDash.AccountManagement.response.RegistrationResponse;
import com.DailyDash.AccountManagement.security.JWTGenerator;
import com.DailyDash.AccountManagement.services.AuthenticationServices;
import com.DailyDash.AccountManagement.services.CityServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServicesImpl implements AuthenticationServices {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServicesImpl.class);
    private final CityRepository cityRepository;
    private final CityServices cityServices;
    private final PasswordEncoder passwordEncoder;
    private final DashUserRepository dashUserRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    @Autowired
    public AuthenticationServicesImpl(CityRepository cityRepository, CityServices cityServices, PasswordEncoder passwordEncoder, DashUserRepository dashUserRepository, AuthenticationManager authenticationManager, JWTGenerator jwtGenerator) {
        this.cityRepository = cityRepository;
        this.cityServices = cityServices;
        this.passwordEncoder = passwordEncoder;
        this.dashUserRepository = dashUserRepository;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    public LoginResponse login(LoginDTO loginDTO) {
        if (this.verifyUser(loginDTO)) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Generate JWT token
            String token = jwtGenerator.generateToken(authentication);

            //Return to controller
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken(token);
            loginResponse.setSuccess(true);
            loginResponse.setMessage("User has successfully logged in");

            return loginResponse;
        } else {
            return new LoginResponse(false, "the user is not in the system");
        }
    }

    @Override
    public RegistrationResponse registerUser(RegisterDTO registerDTO) {
        if (dashUserRepository.existsDashUserByEmail(registerDTO.getEmail())) {
            return new RegistrationResponse(false, "The user already exists in the system");
        }

        Optional<City> optionalUserCity = cityServices.addCity(registerDTO.getCityName());
        if (optionalUserCity.isEmpty()) {
            return new RegistrationResponse(false, "the city does not exist in the system");
        }

        DashUser currentDashUser = this.convertToDasher(registerDTO, optionalUserCity.get());
        boolean isUserAdded = dashUserRepository.existsDashUserByEmail(currentDashUser.getEmail());

        if (isUserAdded) {
            return new RegistrationResponse(true, "User account creation is successful");
        } else {
            return new RegistrationResponse(true, "User account creation failed, please try again");
        }
    }

    public DashUser convertToDasher(RegisterDTO registerDTO, City city){
        DashUser currentDashUser = new DashUser();
        currentDashUser.setFirstName(registerDTO.getFirstName());
        currentDashUser.setEmail(registerDTO.getEmail());
        currentDashUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        currentDashUser.setIsAccountVerified(false);
        currentDashUser.setCity(city);
        currentDashUser.setRole(Role.USER);
        dashUserRepository.save(currentDashUser);
        return currentDashUser;
    }


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



    //Method for deleting the user, needs to be improved/looked at
    public void deleteUser(Long id){
        Optional<DashUser> optionalDashUser = dashUserRepository.findById(id);
        if (optionalDashUser.isPresent()) {
            dashUserRepository.delete(optionalDashUser.get());
        } else {
            logger.info("the {} is not tied to a real user", id);
        }
    }
}
