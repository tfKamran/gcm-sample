package com.tf.gcmsample;

import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by kamran on 18/03/17.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    public static final String PREF_INSTANCE_ID = "instance_id";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String instanceId = FirebaseInstanceId.getInstance().getToken();

        if (instanceId != null) {
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);

            sharedPreferences.edit()
                    .putString(PREF_INSTANCE_ID, instanceId)
                    .apply();
        }
    }
}
