package com.DailyDash.AccountManagement.services.implementation;

import com.DailyDash.AccountManagement.controller.AccountValidationController;
import com.DailyDash.AccountManagement.entity.AccountValidation;
import com.DailyDash.AccountManagement.repository.AccountValidationRepository;
import com.DailyDash.AccountManagement.services.AccountValidationServices;
import com.netflix.discovery.converters.Auto;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AccountValidationServicesImpl implements AccountValidationServices {

    private AccountValidationRepository accountValidationRepository;

    public AccountValidationServicesImpl(AccountValidationRepository accountValidationRepository) {
        this.accountValidationRepository = accountValidationRepository;
    }

    @Override
    public void generateValidationCode(int userid) {
        //Delete old code if there is one
        Optional<AccountValidation> optionalAccountValidation =  accountValidationRepository.findAccountValidationByDashUserId(userid);

        if (optionalAccountValidation.isPresent()) {
            accountValidationRepository.deleteById(userid);
        }

        SecureRandom codeGenerator = new SecureRandom();
        int codeGenerated = codeGenerator.nextInt(900000) + 100000;
        LocalDateTime localTime = LocalDateTime.now();

        AccountValidation accountValidation = new AccountValidation();
        accountValidation.setCodeGenerated(codeGenerated);
        accountValidation.setDashUserId(userid);
        accountValidation.setCreationTime(localTime);
        accountValidation.setExpirationTime(localTime.plusMinutes(15));

        accountValidationRepository.save(accountValidation);
//        this.sendUserEmail(accountValidation);
        //try catch block probably to show error if anything?
    }

    @Override
    public boolean validateCode(int userid, int stringCode) {
        Optional<AccountValidation> optionalAccountValidation =  accountValidationRepository
                .findAccountValidationByDashUserIdAndCodeGenerated(userid, stringCode);

        if (optionalAccountValidation.isPresent()) {
            accountValidationRepository.deleteById(userid);
            return true;
        } return false;
    }

//    @Override
//    public void sendUserEmail(AccountValidation accountValidation) {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        MimeMessage mailMessage = mailSender.createMimeMessage();
//        mailMessage.write
//
////                Message objects are obtained either from a Folder or by constructing a new Message object of the appropriate subclass.
//        // Transport.send method.
//                ..To send a message, an appropriate subclass of Message (e.g., MimeMessage) is instantiated, the attributes and content are filled in,
//    }
}
