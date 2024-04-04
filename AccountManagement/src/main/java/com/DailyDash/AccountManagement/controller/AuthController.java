package com.DailyDash.AccountManagement.controller;

import com.DailyDash.AccountManagement.dto.LoginDTO;
import com.DailyDash.AccountManagement.dto.RegisterDTO;
import com.DailyDash.AccountManagement.entity.City;
import com.DailyDash.AccountManagement.entity.DashUser;
import com.DailyDash.AccountManagement.entity.Role;
import com.DailyDash.AccountManagement.repository.DashUserRepository;
import com.DailyDash.AccountManagement.services.CityServices;
import com.DailyDash.AccountManagement.services.DashUserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private final DashUserRepository dashUserRepository;
    private final CityServices cityServices;
    private final DashUserServices dashUserServices;
    private PasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, DashUserRepository dashUserRepository, CityServices cityServices, DashUserServices dashUserServices, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.dashUserRepository = dashUserRepository;
        this.cityServices = cityServices;
        this.dashUserServices = dashUserServices;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "https://dash-hub-client-okmlwz6kr-kenmain5s-projects.vercel.app")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        Boolean isVerified = dashUserServices.verifyUser(loginDTO);
        if (isVerified) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);
            return new ResponseEntity<>("User has successfully logged in", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("The user has provided the wrong credentials", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "https://dash-hub-client-okmlwz6kr-kenmain5s-projects.vercel.app")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO){

        //Checks if already exists in the database
        boolean doesEmailAlreadyExist = dashUserRepository.existsDashUserByEmail(registerDTO.getEmail());
        if (doesEmailAlreadyExist) {
            return new ResponseEntity<>("This email is already associated with an account", HttpStatus.BAD_REQUEST);
        }

        //Create a user to be added into the database
        DashUser tempDashUser = new DashUser();
        tempDashUser.setFirstName(registerDTO.getFirstName());
        tempDashUser.setEmail(registerDTO.getEmail());
        tempDashUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        City savedCity = cityServices.addCity(registerDTO.getCityName());
        tempDashUser.setCity(savedCity);
        tempDashUser.setRole(Role.USER);

        dashUserRepository.save(tempDashUser);
        boolean isUserAdded = dashUserRepository.existsDashUserByEmail(tempDashUser.getEmail());

        if (isUserAdded) {
            return ResponseEntity.ok().body("User account creation is successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: User is not in the database");
        }
    }
}
