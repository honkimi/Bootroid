package com.honkimi.sample.activity;

import android.os.Bundle;

import com.honkimi.bootroid.gcm.GcmUtil;
import com.honkimi.sample.R;

/**
 * Created by honkimi on 14/11/28.
 */
public class GcmActivity extends DetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcm);

        setGcm();
    }

    /**
     * set up gcm.
     * make sure that you set Conf.GCM_SENDERID in MyApplication#onCreate()
     *
     * You need to prepare your GCM server.
     * The server saves this regId. When the server pushes notification, it will send gcm server with the regId.
     * You can easily implement by using AmazonSNS.
     *
     * In MyApplication, please set the SENDER_ID in your google cloud console.
     *
     * If the push notification success, MyGcmIntentService will be called!
     */
    private void setGcm() {
        if (GcmUtil.checkGooglePlayServiceAvailable(this)) {
            GcmUtil.setupGCM(this, new GcmUtil.GCMSender() {
                @Override
                public void onSuccessRegId(String regId) {
                    // please save this regId to your server. This regId is device's identifier.
                    // after sent to the server, please save this regId into the local.
                    storeRegistrationId(regId);
                }
            });
        }
    }
}
