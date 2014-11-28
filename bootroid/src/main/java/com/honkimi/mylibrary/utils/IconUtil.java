package com.honkimi.mylibrary.utils;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

/**
 * Created by honkimi on 14/11/28.
 */
public class IconUtil {
    public static void setIcons(Activity activity, int... iconResIds) {
        Typeface font = Typeface.createFromAsset(activity.getAssets(), "fontawesome-webfont.ttf");
        for (int resId : iconResIds) {
            ((TextView) activity.findViewById(resId)).setTypeface(font);
        }
    }

    public static void setIcons(View view, Activity activity, int... iconResIds) {
        Typeface font = Typeface.createFromAsset(activity.getAssets(), "fontawesome-webfont.ttf");
        for (int resId : iconResIds) {
            ((TextView) view.findViewById(resId)).setTypeface(font);
        }
    }
}
