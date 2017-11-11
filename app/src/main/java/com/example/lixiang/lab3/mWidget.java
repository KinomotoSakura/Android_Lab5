package com.example.lixiang.lab3;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

public class mWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.m_widget);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
        RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.m_widget);//实例化RemoteViews
        views.setOnClickPendingIntent(R.id.mwidget, pendingIntent);//设置点击事件
        appWidgetManager.updateAppWidget(appWidgetIds, views);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent){
        super.onReceive(context, intent);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.m_widget);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        Bundle bundle = intent.getExtras();
        if(intent.getAction().equals("randomRecommendation")){
            views.setTextViewText(R.id.widtext, bundle.getString("Name") + "仅售 " + bundle.getString("Price") + "!");
            views.setImageViewResource(R.id.widimage, bundle.getInt("Image"));
            Intent detail_intent = new Intent(context, GoodsDetail.class);
            detail_intent.putExtras(bundle);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,1,detail_intent,PendingIntent.FLAG_UPDATE_CURRENT);
            views.setOnClickPendingIntent(R.id.mwidget, pendingIntent);
            appWidgetManager.updateAppWidget(new ComponentName(context, mWidget.class), views);
        }
    }
}

