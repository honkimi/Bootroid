package com.honkimi.mylibrary.analytics;

import com.bugsense.trace.BugSenseHandler;
import com.honkimi.mylibrary.Conf;
import com.honkimi.mylibrary.application.ApplicationController;

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
