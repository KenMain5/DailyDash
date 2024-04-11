package com.DailyDash.AccountManagement.controller;

import com.DailyDash.AccountManagement.dto.ValidationCodeDTO;
import com.DailyDash.AccountManagement.services.implementation.AccountValidationServicesImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validation")
public class AccountValidationController {

    private AccountValidationServicesImpl accountValidationServices;

    @Autowired
    public AccountValidationController(AccountValidationServicesImpl accountValidationServices) {
        this.accountValidationServices = accountValidationServices;
    }



    /*This are the steps..
    We create the randomGeneratedCode, id, generatedCode, expirationTime
    Store in the database
    Once stored, we use the API to text
    */

    //search for userID, if there is, delete,
    // if none, then place it
    // delete last code and send email again


    @GetMapping("/get")
    public ResponseEntity<String> getValidationCode(int dashUserID){
        accountValidationServices.generateValidationCode(0);

        //return code
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> VerifyValidationCode(@Valid @RequestBody ValidationCodeDTO validationCodeDTO){
        //call Account Validation . generate Code
        //return code
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
