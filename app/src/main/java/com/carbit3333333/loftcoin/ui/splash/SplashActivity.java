package com.carbit3333333.loftcoin.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.carbit3333333.loftcoin.R;
import com.carbit3333333.loftcoin.databinding.ActivitySplashBinding;
import com.carbit3333333.loftcoin.databinding.ActivityWelcomeBinding;
import com.carbit3333333.loftcoin.ui.main.MainActivity;
import com.carbit3333333.loftcoin.ui.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {
    private SharedPreferences prefs;
    private final Handler handler = new Handler();
    private Runnable goNext;
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ClipDrawable clipDrawable = (ClipDrawable) binding.clipArtboard2.getDrawable();
        clipDrawable.setLevel(5000);

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
