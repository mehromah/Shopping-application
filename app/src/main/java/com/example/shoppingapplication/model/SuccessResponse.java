package com.example.shoppingapplication.model;

import com.google.gson.annotations.SerializedName;

public class SuccessResponse {
    @SerializedName("message")
    private String mMessage;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
}
