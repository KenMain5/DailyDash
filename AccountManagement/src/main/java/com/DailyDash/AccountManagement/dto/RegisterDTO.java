package com.DailyDash.AccountManagement.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDTO {
    private String firstName;
    private String password;
    private String cityName;
    private String email;
}



