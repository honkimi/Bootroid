package com.honkimi.sample.gcm;

import com.honkimi.mylibrary.gcm.GcmBroadcastReceiver;

/**
 * Created by honkimi on 14/11/28.
 */
public class MyGcmBroadcastReceiver extends GcmBroadcastReceiver {
    @Override
    public String getGcmServiceClassName() {
        return MyGcmIntentService.class.getName();
    }
}
