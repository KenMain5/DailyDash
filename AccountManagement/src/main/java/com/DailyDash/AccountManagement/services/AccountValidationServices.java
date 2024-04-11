package com.DailyDash.AccountManagement.services;

import com.DailyDash.AccountManagement.entity.AccountValidation;

public interface AccountValidationServices {
    void generateValidationCode(int userid);
    boolean validateCode(int userid, int stringCode);

//    void sendUserEmail(AccountValidation accountValidation);
}
