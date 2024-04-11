package com.DailyDash.AccountManagement.dto;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDTO {

    @Nonnull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "First name must contain only letters and numbers")
    private String firstName;

    @Nonnull
    @Size(min = 7, max = 20)
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "First name must contain only letters and numbers")
    private String password;

    @Nonnull
    private String cityName;

    @Nonnull
    @Email
    @Size(min = 6, max = 30)
    @Pattern(regexp = "^[A-Za-z0-9!@#$%^&*()]+$", message = "Password must contain only allowed characters")
    private String email;
}



