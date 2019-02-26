package com.example.shoppingapplication.auth1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shoppingapplication.R;
import com.example.shoppingapplication.main.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

         new Timer().schedule(new TimerTask(){
public void run() {
        SplashActivity.this.runOnUiThread(new Runnable() {
public void run() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
        });
        }
        }, 5000);

    }
}
