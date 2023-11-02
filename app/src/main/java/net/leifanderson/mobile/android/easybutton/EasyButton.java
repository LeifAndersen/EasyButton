package net.leifanderson.mobile.android.easybutton;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class EasyButton extends AppWidgetProvider{
    @Override
    public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfint){
        for(int i : paramArrayOfint){
            PendingIntent pendingIntent = PendingIntent.getService(paramContext, 0, new Intent(paramContext, EasyButtonService.class), PendingIntent.FLAG_IMMUTABLE);
            RemoteViews remoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.easy_button_layout);
            remoteViews.setOnClickPendingIntent(R.id.easy_button_layout, pendingIntent);
            paramAppWidgetManager.updateAppWidget(i, remoteViews);
        }
    }
}
