package com.DailyDash.AccountManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class AccountValidation {

    //Manually Given
    @Id
    private int DashUserId;

    private int CodeGenerated;

    private LocalDateTime creationTime;

    private LocalDateTime expirationTime;


    //current time

    //expiration time



//    How will this be done?
//    private Object TimeCodeGenerated;
}
