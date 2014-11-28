package com.honkimi.sample;

import com.honkimi.bootroid.Conf;
import com.honkimi.bootroid.application.ApplicationController;

/**
 * Created by honkimi on 14/11/28.
 */
public class MyApplication extends ApplicationController {

    @Override
    public void onCreate() {
        super.onCreate();

        Conf.DEV_MODE = true;
        Conf.BUG_SENSE_API_KEY = "your bugsense api key";
        Conf.TRACKER_ID = "your google analytics trackerid";
        Conf.GCM_SENDERID = "your gcm sender id";

    }
}
