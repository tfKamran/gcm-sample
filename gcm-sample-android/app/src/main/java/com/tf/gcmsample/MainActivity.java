package com.tf.gcmsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView lblInstanceId = (TextView) findViewById(R.id.lblInstanceId);

        String instanceId = getSharedPreferences(getPackageName(), MODE_PRIVATE)
                .getString(GCMRegistrationIntentService.PREF_INSTANCE_ID, "Not registered yet");
        lblInstanceId.setText(instanceId);

        Log.d("InstanceID", instanceId);

        startService(new Intent(this, GCMRegistrationIntentService.class));
    }
}
