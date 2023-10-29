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
