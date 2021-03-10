package com.codeliver128.shaadiinvitation;

import android.app.Application;
import android.content.Intent;
import com.codeliver128.shaadiinvitation.services.SoundService;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
//start service and play music
            startService(new Intent(this, SoundService.class));

        } catch (Exception ex) {
        }
    }

    @Override
    public void onTerminate() {
        stopService(new Intent(this, SoundService.class));
        super.onTerminate();
    }
}


