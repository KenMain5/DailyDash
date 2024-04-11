package com.DailyDash.AccountManagement.services;

import com.DailyDash.AccountManagement.dto.LoginDTO;
import com.DailyDash.AccountManagement.dto.RegisterDTO;
import com.DailyDash.AccountManagement.response.LoginResponse;
import com.DailyDash.AccountManagement.response.RegistrationResponse;


public interface AuthenticationServices {
    LoginResponse login(LoginDTO loginDTO);
    boolean verifyUser(LoginDTO loginDTO);
    RegistrationResponse registerUser(RegisterDTO registerDTO);
}
