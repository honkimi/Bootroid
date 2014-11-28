package com.honkimi.mylibrary.pref;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.honkimi.mylibrary.application.ApplicationController;

/**
 * Created by honkimi on 14/11/28.
 */
public class LibPref extends BasePref {
    private static final String PREF_NAME = "lib_pref";

    public static final String PROPERTY_REG_ID = "reg_id";
    public static final String APP_VERSION = "app_version";

    // Showcase Related

    public LibPref() {
        super(PREF_NAME);
    }

    public String getRegistrationId() {
        Context context = ApplicationController.getInstance().getApplicationContext();
        String registrationId = get(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = getInt(APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            return "";
        }
        return registrationId;
    }

    public int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }
}
