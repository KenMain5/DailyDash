package com.DailyDash.AccountManagement.response;

public class RegistrationResponse extends ResponseBaseClass{

    public RegistrationResponse(boolean success,String message) {
        this.success = success;
        this.message = message;
    }

}
