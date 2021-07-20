package net.leifandersen.mobile.android.easybutton;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class EasyButton extends AppWidgetProvider {
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		        final int N = appWidgetIds.length;

		        // Perform this loop procedure for each App Widget that belongs to this provider
		        for (int i=0; i<N; i++) {
		            int appWidgetId = appWidgetIds[i];

		            // Create an Intent to launch UpdateService
		            Intent intent = new Intent(context, EasyButtonService.class);
		            PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
		            
		            // Get the layout for the App Widget and attach an on-click listener to the button
		            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.easy_button_layout);
		            views.setOnClickPendingIntent(R.id.easy_button_layout, pendingIntent);
		            // Tell the AppWidgetManager to perform an update on the current App Widget
		            appWidgetManager.updateAppWidget(appWidgetId, views);
			    }
	}
}