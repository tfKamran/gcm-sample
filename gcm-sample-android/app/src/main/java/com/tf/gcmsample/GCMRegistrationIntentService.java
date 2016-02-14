package com.tf.gcmsample;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

public class GCMRegistrationIntentService extends IntentService {

    public static final String PREF_INSTANCE_ID = "instance_id";

    public GCMRegistrationIntentService() {
        super("GCMRegistrationIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        InstanceID instanceID = InstanceID.getInstance(this);
        try {
            String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
            sharedPreferences.edit()
                    .putString(PREF_INSTANCE_ID, token)
                    .commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
