package com.carbit3333333.loftcoin;

import android.app.Application;
import android.os.StrictMode;

public class CoinApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            StrictMode.enableDefaults();
        }
    }
}
