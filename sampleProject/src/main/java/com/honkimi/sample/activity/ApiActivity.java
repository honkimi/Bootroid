package com.honkimi.sample.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.honkimi.mylibrary.api.ApiCallbackBase;
import com.honkimi.mylibrary.api.ApiException;
import com.honkimi.mylibrary.api.ApiRequest;
import com.honkimi.mylibrary.api.ApiResponseHandler;
import com.honkimi.mylibrary.api.RestApi;
import com.honkimi.mylibrary.utils.LogUtil;
import com.honkimi.sample.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by honkimi on 14/11/28.
 */
public class ApiActivity extends DetailActivity {

    private static final String URL = "https://api.github.com/repos/honkimi/Bootroid";

    private TextView simpleText;
    private TextView restText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        simpleText = (TextView) findViewById(R.id.simple_request_result);
        restText = (TextView) findViewById(R.id.rest_request_result);

        fetchSimpleRequest();
        fetchRestRequest();
    }

    private void fetchSimpleRequest() {
        ApiRequest.get(URL, new ApiResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    String description = jsonObject.getString("description");
                    simpleText.setText(description);
                } catch (JSONException e) {
                    LogUtil.e(e.getMessage());
                }
            }

            @Override
            public void onFailure(ApiException e) {
                LogUtil.e("Failed to fetch api.");
            }
        });
    }

    private void fetchRestRequest() {
        RestApi.baseKey = "owner";
        RestApi.show(URL, Owner.class, new ApiCallbackBase.ApiCallback<Owner>() {
            @Override
            public void onSuccess(Owner response) {
                String txt = "login: " + response.login + ", id: " + response.id;
                restText.setText(txt);
            }

            @Override
            public void onFailure(String message, int code) {
                LogUtil.e(message);
            }
        });
    }

    private static class Owner {
        public String login;
        public int id;
    }

}
