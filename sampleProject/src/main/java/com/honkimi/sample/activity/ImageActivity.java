package com.honkimi.sample.activity;

import android.os.Bundle;

import com.android.volley.toolbox.NetworkImageView;
import com.honkimi.mylibrary.application.ApplicationController;
import com.honkimi.mylibrary.utils.IconUtil;
import com.honkimi.sample.R;

/**
 * Created by honkimi on 14/11/28.
 */
public class ImageActivity extends DetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        setNetworkView();

        setIconView();
    }

    /**
     * set image from http
     */
    private void setNetworkView() {
        NetworkImageView network = (NetworkImageView) findViewById(R.id.network);
        String imageUrl = "https://assets-cdn.github.com/images/modules/open_graph/github-mark.png";
        network.setImageUrl(imageUrl, ApplicationController.getInstance().getImageLoader());
    }

    /**
     * set image from fontawesome.
     * please set android:text from http://fortawesome.github.io/Font-Awesome/cheatsheet/
     */
    private void setIconView() {
        IconUtil.setIcons(this, R.id.github_icon);
    }
}
