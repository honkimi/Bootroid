package com.honkimi.sample.gcm;

import com.honkimi.bootroid.gcm.GcmIntentService;
import com.honkimi.bootroid.utils.LogUtil;

/**
 * Created by honkimi on 14/11/28.
 */
public class MyGcmIntentService extends GcmIntentService {
    @Override
    public void onGCMReceived(String content) {
        LogUtil.v(content);

        // You can write codes when GCM push was received here!
    }
}
