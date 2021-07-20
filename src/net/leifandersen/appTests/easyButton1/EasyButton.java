package net.leifandersen.appTests.easyButton1;

import net.leifandersen.appTests.easyButton1.R;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EasyButton extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b = (Button)findViewById(R.id.easy);
        b.setOnClickListener(this);
    }
    
    public void onClick(View v) {
    	MediaPlayer mp = MediaPlayer.create(this, R.raw.easy);
    	mp.start();
    	if(!mp.isPlaying()) 
    		setContentView(R.layout.after);
    }
}