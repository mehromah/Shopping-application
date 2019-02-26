package com.example.shoppingapplication.auth1;

import android.content.Context;
import android.content.SharedPreferences;

import io.reactivex.annotations.Nullable;

public class UserInfoManager1 {
    private SharedPreferences sharedPreferences;

    public UserInfoManager1(Context context) {
        sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
    }


    public void saveEmail(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email", email);
        editor.apply();
    }

    public String getEmail() {
        return sharedPreferences.getString("email", "");
    }


    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}



