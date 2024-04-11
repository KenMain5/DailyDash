package com.DailyDash.AccountManagement.controller;

import com.DailyDash.AccountManagement.dto.LoginDTO;
import com.DailyDash.AccountManagement.dto.RegisterDTO;
import com.DailyDash.AccountManagement.entity.City;
import com.DailyDash.AccountManagement.entity.DashUser;
import com.DailyDash.AccountManagement.entity.Role;
import com.DailyDash.AccountManagement.exceptions.CityNotFoundException;
import com.DailyDash.AccountManagement.repository.DashUserRepository;
import com.DailyDash.AccountManagement.response.LoginResponse;
import com.DailyDash.AccountManagement.response.RegistrationResponse;
import com.DailyDash.AccountManagement.security.JWTGenerator;
import com.DailyDash.AccountManagement.services.AuthenticationServices;
import com.DailyDash.AccountManagement.services.CityServices;
import com.DailyDash.AccountManagement.services.implementation.AuthenticationServicesImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private AuthenticationManager authenticationManager;
    private final DashUserRepository dashUserRepository;
    private final CityServices cityServices;
    private final JWTGenerator jwtGenerator;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationServicesImpl authenticationServices;
    private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    public AuthenticationController(DashUserRepository dashUserRepository, CityServices cityServices, JWTGenerator jwtGenerator, PasswordEncoder passwordEncoder, AuthenticationServicesImpl authenticationServices) {
        this.dashUserRepository = dashUserRepository;
        this.cityServices = cityServices;
        this.jwtGenerator = jwtGenerator;
        this.passwordEncoder = passwordEncoder;
        this.authenticationServices = authenticationServices;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "https://dash-hub-client-okmlwz6kr-kenmain5s-projects.vercel.app")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = authenticationServices.login(loginDTO);
        if (loginResponse.getSuccess()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + loginResponse.getToken())
                    .body(loginResponse.getMessage());
        } else {
            return ResponseEntity.badRequest().body("the user is not found in the system");
        }
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "https://dash-hub-client-okmlwz6kr-kenmain5s-projects.vercel.app")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterDTO registerDTO){
        RegistrationResponse registrationResponse = authenticationServices.registerUser(registerDTO);
        if (registrationResponse.getSuccess()) {
            return ResponseEntity.ok()
                    .body(registrationResponse.getMessage());
        } else {
            return ResponseEntity.badRequest().body(registrationResponse.getMessage());
        }

    }
}
