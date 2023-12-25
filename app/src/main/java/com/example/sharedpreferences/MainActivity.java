package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("login", MODE_PRIVATE);
                boolean isLogin = preferences.getBoolean("flag", false);

                Intent nextScreen;
                if (isLogin) {
                    nextScreen = new Intent(MainActivity.this, HomeActivity.class);
                } else {
                    nextScreen = new Intent(MainActivity.this, LoginActivity.class);
                }

                startActivity(nextScreen);
            }
        }, 2000);
    }
}