package com.example.shoppingapplication.exception;

import com.google.gson.annotations.SerializedName;

public class ShoppingExceptionModel {

    @SerializedName("error")
    private String mError;
    @SerializedName("message")
    private String mMessage;

    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
