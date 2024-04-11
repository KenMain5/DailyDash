package com.DailyDash.AccountManagement.response;

public abstract class ResponseBaseClass {
    protected boolean success;
    protected String message;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //Unsure why this is here tbh
    public boolean isSuccess() {
        return success;
    }


}
