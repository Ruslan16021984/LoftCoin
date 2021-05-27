package com.carbit3333333.loftcoin.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.carbit3333333.loftcoin.R;
import com.carbit3333333.loftcoin.ui.main.MainActivity;
import com.carbit3333333.loftcoin.ui.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private final Handler handler = new Handler();
    private Runnable goNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean(WelcomeActivity.KEY_SHOW_WELCOME, true)) {
            goNext = () ->
                startActivity(new Intent(this, WelcomeActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
        handler.postDelayed(goNext, 1500);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(goNext);
    }
}
