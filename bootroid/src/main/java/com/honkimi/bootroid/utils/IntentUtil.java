package com.honkimi.bootroid.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by honkimi on 14/11/28.
 */
public class IntentUtil {
    public static Intent getShareIntent(String content) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, content);
        return intent;
    }

    public static Intent getMarketIntent(Activity activity) {
        Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        return new Intent(Intent.ACTION_VIEW, uri);
    }

    public static Intent getWebIntent(String url) {
        Uri uri = Uri.parse(url);
        return new Intent(Intent.ACTION_VIEW, uri);
    }
}
