package com.tf.gcmsample;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by kamran on 2/14/16.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        startService(new Intent(this, GCMRegistrationIntentService.class));
    }
}
