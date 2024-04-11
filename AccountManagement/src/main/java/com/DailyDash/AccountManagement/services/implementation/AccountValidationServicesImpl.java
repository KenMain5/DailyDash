/*
 * Feature discontinued for now
 */

//package com.DailyDash.AccountManagement.services.implementation;
//
//import com.DailyDash.AccountManagement.controller.AccountValidationController;
//import com.DailyDash.AccountManagement.dto.ValidationCodeDTO;
//import com.DailyDash.AccountManagement.entity.AccountValidation;
//import com.DailyDash.AccountManagement.repository.AccountValidationRepository;
//import com.DailyDash.AccountManagement.repository.CityRepository;
//import com.DailyDash.AccountManagement.repository.DashUserRepository;
//import com.DailyDash.AccountManagement.services.AccountValidationServices;
//import com.DailyDash.AccountManagement.services.CityServices;
//import com.netflix.discovery.converters.Auto;
//import jakarta.annotation.Nonnull;
//import jakarta.mail.internet.MimeMessage;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Pattern;
//import lombok.Data;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMailMessage;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.SecureRandom;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.Optional;
//
//@Service
//public class AccountValidationServicesImpl implements AccountValidationServices {
//
//    private final AccountValidationRepository accountValidationRepository;
//
//    @Autowired
//    public AccountValidationServicesImpl(AccountValidationRepository accountValidationRepository) {
//        this.accountValidationRepository = accountValidationRepository;
//    }
//
//    @Override
//    public void generateValidationCode(int userid) {
//        //Delete old code if there is one
//        Optional<AccountValidation> optionalAccountValidation =  accountValidationRepository.findAccountValidationByDashUserId(userid);
//
//        if (optionalAccountValidation.isPresent()) {
//            accountValidationRepository.deleteById(userid);
//        }
//
//        SecureRandom codeGenerator = new SecureRandom();
//        int codeGenerated = codeGenerator.nextInt(900000) + 100000;
//        LocalDateTime localTime = LocalDateTime.now();
//
//        AccountValidation accountValidation = new AccountValidation();
//        accountValidation.setCodeGenerated(codeGenerated);
//        accountValidation.setDashUserId(userid);
//        accountValidation.setCreationTime(localTime);
//        accountValidation.setExpirationTime(localTime.plusMinutes(15));
//
//        accountValidationRepository.save(accountValidation);
////        this.sendUserEmail(accountValidation);
//        //try catch block probably to show error if anything?
//    }
//
//    @Override
//    public boolean validateCode(int userid, int stringCode) {
//        Optional<AccountValidation> optionalAccountValidation =  accountValidationRepository
//                .findAccountValidationByDashUserIdAndCodeGenerated(userid, stringCode);
//
//        if (optionalAccountValidation.isPresent()) {
//            accountValidationRepository.deleteById(userid);
//            return true;
//        } return false;
//    }
//
//}
//
//package com.DailyDash.AccountManagement.controller;
//
//import com.DailyDash.AccountManagement.dto.ValidationCodeDTO;
//import com.DailyDash.AccountManagement.services.implementation.AccountValidationServicesImpl;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/validation")
//public class AccountValidationController {
//
//    private AccountValidationServicesImpl accountValidationServices;
//
//    @Autowired
//    public AccountValidationController(AccountValidationServicesImpl accountValidationServices) {
//        this.accountValidationServices = accountValidationServices;
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity<String> getValidationCode(int dashUserID){
//        accountValidationServices.generateValidationCode(0);
//
//        //return code
//        return new ResponseEntity<>(null, HttpStatus.CREATED);
//    }
//
//    @PostMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> VerifyValidationCode(@Valid @RequestBody ValidationCodeDTO validationCodeDTO){
//        //call Account Validation . generate Code
//        //return code
//        return new ResponseEntity<>(null, HttpStatus.CREATED);
//    }
//}
//
//package com.DailyDash.AccountManagement.dto;
//
//import jakarta.annotation.Nonnull;
//import jakarta.validation.constraints.Pattern;
//import lombok.Data;
//
//@Data
//public class ValidationCodeDTO {
//
//    @Nonnull
//    @Pattern(regexp = "\\d+", message = "Validation code must contain only numbers")
//    private Long validationCode;
//}
//
//
//package com.DailyDash.AccountManagement.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Builder;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//public class AccountValidation {
//
//    //Manually Given
//    @Id
//    private int DashUserId;
//
//    private int CodeGenerated;
//
//    private LocalDateTime creationTime;
//
//    private LocalDateTime expirationTime;
//
//
//    //current time
//
//    //expiration time
//
//
//
////    How will this be done?
////    private Object TimeCodeGenerated;
//}
//
//
//package com.DailyDash.AccountManagement.repository;
//
//import com.DailyDash.AccountManagement.entity.AccountValidation;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface AccountValidationRepository extends JpaRepository<AccountValidation, Integer> {
//    Optional<AccountValidation> findAccountValidationByDashUserIdAndCodeGenerated(int userId, int codeGenerated);
//    Optional<AccountValidation> findAccountValidationByDashUserId(int userId);
//}
//
//
//package com.DailyDash.AccountManagement.services;
//
//import com.DailyDash.AccountManagement.entity.AccountValidation;
//
//public interface AccountValidationServices {
//    void generateValidationCode(int userid);
//    boolean validateCode(int userid, int stringCode);
//
////    void sendUserEmail(AccountValidation accountValidation);
//}

/*
* Feature discontinued for now
*/