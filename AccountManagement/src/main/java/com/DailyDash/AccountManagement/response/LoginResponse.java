package com.DailyDash.AccountManagement.response;


public class LoginResponse extends ResponseBaseClass{
    protected String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse(boolean success, String message, String token) {
        setSuccess(success);
        setMessage(message);
        this.token = token;
    }

    public LoginResponse() {
    }

    public LoginResponse(boolean success, String message) {
        setSuccess(success);
        setMessage(message);
        this.token = token;
    }




}
