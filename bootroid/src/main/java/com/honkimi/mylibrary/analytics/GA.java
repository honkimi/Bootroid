package com.honkimi.mylibrary.analytics;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.honkimi.mylibrary.application.ApplicationController;
import com.honkimi.mylibrary.utils.LogUtil;

/**
 * Created by honkimi on 14/11/28.
 */
public class GA {
    public static void screen(String screenName) {
        Tracker t = ApplicationController.getInstance().getTracker();
        LogUtil.v("Analytics Screen: " + screenName);

        // Set screen name.
        // Where path is a String representing the screen name.
        t.setScreenName(screenName);
        t.send(new HitBuilders.AppViewBuilder().build());
        t.setScreenName(null);
    }

    public static void event(String category, String action, String label, long value) {
        Tracker t = ApplicationController.getInstance().getTracker();
        // Build and send an Event.
        t.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .setValue(value)
                .build());
    }

    public static void event(String category, String action, String label) {
        Tracker t = ApplicationController.getInstance().getTracker();
        LogUtil.v("Analytics Event: category: " + category + ", action: " + action + ", label: " + label);
        t.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .build());
    }

    public static void event(String category, String action) {
        LogUtil.v("Analytics Event: category: " + category + ", action: " + action);
        Tracker t = ApplicationController.getInstance().getTracker();
        t.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .build());
    }

}
