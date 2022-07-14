package com.example.alarmmanagerdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class StandUp extends BroadcastReceiver {
    private static final int NOTIFICATION_ID = 0;


    public StandUp() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Inside Receiver", Toast.LENGTH_SHORT).show();


        //Create the content intent for the notification, which launches this activity
        Intent contentIntent = new Intent(context, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity
                (context, NOTIFICATION_ID, contentIntent, PendingIntent.FLAG_IMMUTABLE);

        //Build the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, MainActivity.PRIMARY_CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_btn_speak_now)
                .setContentTitle("Stand Up!!!")
                .setContentText("You need to stand up")
                .setContentIntent(contentPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        //Deliver the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}