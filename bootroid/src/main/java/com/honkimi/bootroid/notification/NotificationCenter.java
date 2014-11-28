package com.honkimi.bootroid.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by honkimi on 14/11/28.
 */
public class NotificationCenter {
    public static final int NOTIFICATION_ID = 1;
    private NotificationManager mNotificationManager;
    private Context context;

    public NotificationCenter(Context context) {
        this.context = context;
    }

    public PendingIntent getPendingIntentClass(Intent intent) {
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public NotificationCompat.Builder getNotificationBuilder(int icon, String message, String contentTitle, PendingIntent pendingIntent) {
        return new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentTitle(contentTitle)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                .setContentText(message)
                .setContentIntent(pendingIntent);
    }

    public void notify(NotificationCompat.Builder mBuilder) {
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancelAll();
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
