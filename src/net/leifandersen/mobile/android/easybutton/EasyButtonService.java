package net.leifandersen.mobile.android.easybutton;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.IBinder;

public class EasyButtonService extends Service {

	@Override
	public void onStart(Intent intent, int startId) {
		MediaPlayer mp = MediaPlayer.create(this.getApplicationContext(), R.raw.easy);
		mp.start();
		mp.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
			}
			
		});
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
