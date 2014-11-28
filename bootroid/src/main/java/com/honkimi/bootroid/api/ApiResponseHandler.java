package com.honkimi.bootroid.api;

import org.json.JSONObject;

/**
 * Created by honkimi on 2014/05/07.
 */
public interface ApiResponseHandler {
    void onSuccess(JSONObject jsonObject);

    void onFailure(ApiException e);
}
