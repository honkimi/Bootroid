package com.honkimi.sample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import com.honkimi.sample.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAnalytics();

        setListeners();
    }

    /**
     * Initialize Bugsence and Google Analytics.
     * This method should be called in each activity class. or you can write (BaseActivity extends Activity)#onCretate().
     * You also need to set each keys in MyApplication#onCreate().
     */
    private void setAnalytics() {
        //BugSence.init();
        //GA.screen(getClass().getSimpleName());
    }


    private void setListeners() {
        final SparseArray<Class> activityMap = new SparseArray<>();
        activityMap.put(R.id.image_activity, ImageActivity.class);
        activityMap.put(R.id.api_activity, ApiActivity.class);
        activityMap.put(R.id.cache_activity, CacheActivity.class);
        activityMap.put(R.id.validate_activity, ValidateActivity.class);
        activityMap.put(R.id.gcm_activity, GcmActivity.class);
        activityMap.put(R.id.other_activity, OtherActivity.class);

        for (int i = 0; i < activityMap.size(); i++) {
            final int key = activityMap.keyAt(i);
            // get the object by the key.
            findViewById(key).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, activityMap.get(key)));
                }
            });
        }
    }

}

