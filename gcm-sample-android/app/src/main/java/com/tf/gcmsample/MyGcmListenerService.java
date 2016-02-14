package com.tf.gcmsample;

import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by kamran on 2/14/16.
 */
public class MyGcmListenerService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from, Bundle data) {
        NotificationManagerCompat.from(this)
                .notify(0, new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Congrats!")
                        .setContentText(data.getString("message"))
                        .build());
    }
}
