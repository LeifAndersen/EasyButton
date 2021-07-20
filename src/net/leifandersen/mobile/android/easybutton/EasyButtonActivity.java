package net.leifandersen.mobile.android.easybutton;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class EasyButtonActivity extends Activity {

	MediaPlayer mp;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mp = MediaPlayer.create(getApplicationContext(), R.raw.easy);
		setContentView(R.layout.easy_button_layout);
		((ImageButton)findViewById(R.id.easy_button_layout)).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						mp.release();
						mp = MediaPlayer.create(getApplicationContext(), R.raw.easy);
						mp.start();
					}
					
				});
	}
}
