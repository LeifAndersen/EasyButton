package net.leifanderson.mobile.android.easybutton;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class EasyButtonService extends Service{
    @Override
    public IBinder onBind(Intent paramIntent){
        return null;
    }

    @Override
    public void onStart(Intent paramIntent, int paramInt){
        MediaPlayer mediaPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.easy);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer param1MediaPlayer){
                param1MediaPlayer.release();
            }
        });
    }
}
