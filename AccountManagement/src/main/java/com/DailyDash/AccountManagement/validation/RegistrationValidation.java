package com.DailyDash.AccountManagement.validation;

import com.DailyDash.AccountManagement.dto.RegisterDTO;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterDTO.class.equals(clazz);
    }



    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "username","username.empty","the username is empty");
        ValidationUtils.rejectIfEmpty(errors, "password","password.empty","the password is empty");
        ValidationUtils.rejectIfEmpty(errors, "cityName","cityName.empty","the cityName is empty");
        ValidationUtils.rejectIfEmpty(errors, "email","email.empty","the email is empty");




    }
}
