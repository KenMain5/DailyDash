package com.DailyDash.AccountManagement.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ValidationCodeDTO {

    @Nonnull
    @Pattern(regexp = "\\d+", message = "Validation code must contain only numbers")
    private Long validationCode;
}
