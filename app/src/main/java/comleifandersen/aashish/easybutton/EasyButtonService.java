package comleifandersen.aashish.easybutton;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class EasyButtonService extends Service {
  public IBinder onBind(Intent paramIntent) {
    return null;
  }
  
  public void onStart(Intent paramIntent, int paramInt) {
    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.easy);
    mediaPlayer.start();
    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
          public void onCompletion(MediaPlayer param1MediaPlayer) {
            param1MediaPlayer.release();
          }
        });
  }
}


/* Location:              C:\Users\aashi\Downloads\jd-gui-windows-1.6.6\jd-gui-windows-1.6.6\the_apk-dex2jar.jar!\net\leifandersen\mobile\android\easybutton\EasyButtonService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
