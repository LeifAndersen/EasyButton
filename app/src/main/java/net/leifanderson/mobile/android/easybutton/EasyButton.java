package net.leifanderson.mobile.android.easybutton;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class EasyButton extends AppWidgetProvider {
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfint) {
    int j = paramArrayOfint.length;
    int i;
    for (i = 0;; i++) {
      if(i >= j){
        return;
      }
      int k = paramArrayOfint[i];
      PendingIntent pendingIntent = PendingIntent.getService(paramContext, 0, new Intent(paramContext, EasyButtonService.class), PendingIntent.FLAG_IMMUTABLE);
      RemoteViews remoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.easy_button_layout);
      remoteViews.setOnClickPendingIntent(R.id.easy_button_layout, pendingIntent);
      paramAppWidgetManager.updateAppWidget(k, remoteViews);
    } 
  }
}


/* Location:              C:\Users\aashi\Downloads\jd-gui-windows-1.6.6\jd-gui-windows-1.6.6\the_apk-dex2jar.jar!\net\net.leifanderson.mobile.android.net.leifanderson.mobile.android.net.leifanderson\mobile\android\net.leifanderson.mobile.android.net.leifanderson\EasyButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
