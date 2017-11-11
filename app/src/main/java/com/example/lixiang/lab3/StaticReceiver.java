package com.example.lixiang.lab3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class StaticReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle mBundle = intent.getExtras();
        Intent detailItent = new Intent(context, GoodsDetail.class);
        detailItent.putExtras(mBundle);
        int imageId = (int) mBundle.get("Image"); //小图标
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), mBundle.getInt("Image"));//大图标
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("新商品热卖")
                .setContentText(mBundle.get("Name") + "仅售 " + mBundle.get("Price") + "!")
                .setSmallIcon(imageId)
                .setLargeIcon(bitmap)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis());
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, detailItent, PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
        Notification notification1 = builder.build();
        notificationManager.notify(0, notification1);
    }
}
