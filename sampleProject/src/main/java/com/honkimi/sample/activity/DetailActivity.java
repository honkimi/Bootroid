package com.honkimi.sample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by honkimi on 14/11/28.
 */
public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // set analytics
        // BugSence.init();
        // GA.screen(getClass().getSimpleName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
