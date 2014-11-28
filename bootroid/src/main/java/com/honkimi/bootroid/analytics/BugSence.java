package com.honkimi.bootroid.analytics;

import com.bugsense.trace.BugSenseHandler;
import com.honkimi.bootroid.Conf;
import com.honkimi.bootroid.application.ApplicationController;

/**
 * Created by honkimi on 14/11/28.
 */
public class BugSence {
    public static void init() {
        if (!Conf.DEV_MODE && !Conf.BUG_SENSE_API_KEY.equals("dummy")) {
            BugSenseHandler.initAndStartSession(ApplicationController.getInstance().getApplicationContext(), Conf.BUG_SENSE_API_KEY);
        }
    }
}
