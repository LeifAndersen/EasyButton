package comleifandersen.aashish.easybutton;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class EasyButtonSmall extends AppWidgetProvider {
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfint) {
    int j = paramArrayOfint.length;
    int i;
    for (i = 0;; i++) {
      if (i >= j)
        return; 
      int k = paramArrayOfint[i];
      PendingIntent pendingIntent = PendingIntent.getService(paramContext, 0, new Intent(paramContext, EasyButtonService.class), 0);
      RemoteViews remoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.easy_button_layout_small);
      remoteViews.setOnClickPendingIntent(R.id.easy_button_layout_small, pendingIntent);
      paramAppWidgetManager.updateAppWidget(k, remoteViews);
    } 
  }
}


/* Location:              C:\Users\aashi\Downloads\jd-gui-windows-1.6.6\jd-gui-windows-1.6.6\the_apk-dex2jar.jar!\net\leifandersen\mobile\android\easybutton\EasyButtonSmall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
