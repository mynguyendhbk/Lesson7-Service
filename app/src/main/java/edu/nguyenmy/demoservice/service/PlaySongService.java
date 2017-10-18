package edu.nguyenmy.demoservice.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import edu.nguyenmy.demoservice.R;

/**
 * Created by DELL on 10/18/2017.
 */

public class PlaySongService extends Service{

    private MediaPlayer mMediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
         mMediaPlayer = MediaPlayer.create(this, R.raw.buoisangbinhthuong);
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        mMediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mMediaPlayer.release();
    }
}
