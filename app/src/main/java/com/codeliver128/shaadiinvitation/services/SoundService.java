package com.codeliver128.shaadiinvitation.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.codeliver128.shaadiinvitation.R;

public class SoundService extends Service {
    MediaPlayer player;
    private Looper mServiceLooper;


    @Override
    public void onCreate() {
        // Start up the thread running the service. Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block. We also make it
        // background priority so CPU-intensive work doesn't disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {

            AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 5, 1);
            player = MediaPlayer.create(SoundService.this, R.raw.gaana); //select music file
            player.setLooping(true); //set looping
            player.start();
        } catch (Exception e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
        // If we get killed, after returning from here, restart
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        stopSelf();
        super.onDestroy();
    }
}