package com.honkimi.mylibrary.gcm;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.honkimi.mylibrary.Conf;
import com.honkimi.mylibrary.application.ApplicationController;
import com.honkimi.mylibrary.utils.LogUtil;
import com.honkimi.mylibrary.pref.LibPref;

import java.io.IOException;

/**
 * Created by honkimi on 14/11/28.
 */
public class GcmUtil {
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    public static abstract class GCMSender {
        // need to call storeRegistrationId!!!
        public abstract void onSuccessRegId(String regId);

        boolean sendOk() {
            return true;
        }

        public void storeRegistrationId(String regId) {
            Context context = ApplicationController.getInstance().getApplicationContext();
            LibPref libPref = new LibPref();
            int appVersion = libPref.getAppVersion(context);
            libPref.put(LibPref.PROPERTY_REG_ID, regId);
            libPref.putInt(LibPref.APP_VERSION, appVersion);
        }
    }


    public static boolean checkGooglePlayServiceAvailable(Activity activity) {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, activity, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void setupGCM(final Context context, final GCMSender gcmSender) {
        LibPref libPref = new LibPref();
        String regid = libPref.getRegistrationId();
        LogUtil.v("regid: " + regid);

        if (regid.isEmpty() && gcmSender.sendOk()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    GcmUtil.registerInBackground(context, gcmSender);
                }
            }).start();
        }
    }

    public static void registerInBackground(final Context context, GCMSender gcmSender) {
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);

        try {
            if (Conf.GCM_SENDERID.equals("dummy")) {
                throw new RuntimeException("Please set Conf.GCM_SENDERID!");
            }
            final String regid = gcm.register(Conf.GCM_SENDERID);
            gcmSender.onSuccessRegId(regid);
        } catch (IOException ex) {
            LogUtil.e("uuid registration error:" + ex.getMessage());
        }
    }

}
