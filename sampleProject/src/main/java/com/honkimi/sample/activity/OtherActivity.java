package com.honkimi.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.honkimi.bootroid.notification.NotificationCenter;
import com.honkimi.bootroid.utils.IntentUtil;
import com.honkimi.bootroid.utils.KeyBoardUtil;
import com.honkimi.bootroid.utils.NetworkUtil;
import com.honkimi.sample.R;

/**
 * Created by honkimi on 14/11/28.
 */
public class OtherActivity extends DetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        checkOnline();

        hideKeyBoard();

        setLaunch();

        setNotification();

    }

    private void checkOnline() {
        TextView online = (TextView) findViewById(R.id.online);
        if (NetworkUtil.isOnline(this)) {
            online.setText("online");
        } else {
            online.setText("offline");
        }
    }

    private void hideKeyBoard() {
        final EditText editText = (EditText) findViewById(R.id.edittext);
        findViewById(R.id.hide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyBoardUtil.hide(OtherActivity.this, editText);
            }
        });
    }

    private void setLaunch() {
        findViewById(R.id.launch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/honkimi/Bootroid";
                startActivity(IntentUtil.getWebIntent(url));
            }
        });
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = "share content";
                startActivity(IntentUtil.getShareIntent(content));
            }
        });
    }

    private void setNotification() {
        findViewById(R.id.notify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCenter notificationCenter = new NotificationCenter(OtherActivity.this);
                Intent launcher = new Intent(OtherActivity.this, MainActivity.class);
                NotificationCompat.Builder builder = notificationCenter.getNotificationBuilder(
                        R.drawable.ic_launcher,
                        "message",
                        "title",
                        notificationCenter.getPendingIntentClass(launcher));
                notificationCenter.notify(builder);
            }
        });
    }
}

