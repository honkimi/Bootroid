package com.honkimi.mylibrary.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.honkimi.mylibrary.R;
import com.honkimi.mylibrary.application.ApplicationController;
import com.honkimi.mylibrary.utils.LogUtil;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by honkimi on 2014/05/14.
 */
public class RestApi {
    public static String baseKey = "item";

    public static <T> void index(String url, final Class<T[]> clazz, final ApiCallbackBase.ApiCallback<T[]> callback) {
        ApiRequest.get(url, getListHandler(clazz, callback));
    }

    public static <T> void create(String url, JSONObject param, final Class<T> clazz, final ApiCallbackBase.ApiCallback<T> callback) {
        ApiRequest.post(url, param, getItemHandler(clazz, callback));
    }

    public static <T> void update(String url, JSONObject param, final Class<T> clazz, final ApiCallbackBase.ApiCallback<T> callback) {
        ApiRequest.patch(url, param, getItemHandler(clazz, callback));
    }

    public static <T> void delete(String url, final Class<T> clazz, ApiCallbackBase.ApiCallback<T> callback) {
        ApiRequest.delete(url, getItemHandler(clazz, callback));
    }

    // create and fetch lists
    public static <T> void createAndList(String url, JSONObject param, final Class<T[]> clazz, final ApiCallbackBase.ApiCallback<T[]> callback) {
        ApiRequest.post(url, param, getListHandler(clazz, callback));
    }

    // update and fetch lists
    public static <T> void updateAndList(String url, JSONObject param, final Class<T[]> clazz, final ApiCallbackBase.ApiCallback<T[]> callback) {
        ApiRequest.patch(url, param, getListHandler(clazz, callback));
    }

    private static <T> ApiResponseHandler getListHandler(final Class<T[]> clazz, final ApiCallbackBase.ApiCallback<T[]> callback) {
        final Context context = ApplicationController.getInstance().getApplicationContext();
        return new ApiResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    Gson gson = new GsonBuilder()
                            .setDateFormat(context.getString(R.string.date_parse_in)).create();
                    LogUtil.d(jsonObject.getJSONArray(baseKey).toString());
                    T[] dtoList = gson.fromJson(jsonObject.getJSONArray(baseKey).toString(), clazz);
                    if (callback != null) {
                        callback.onSuccess(dtoList);
                    }
                } catch (JSONException e) {
                    onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
                }
            }

            @Override
            public void onFailure(ApiException e) {
                LogUtil.e("Index Failed..");
                LogUtil.e("msg:" + e.getMessage() + ", status: " + e.getStatusCode());
                if (callback != null) {
                    callback.onFailure(e.getMessage(), e.getStatusCode());
                }
            }
        };
    }

    private static <T> ApiResponseHandler getItemHandler(final Class<T> clazz, final ApiCallbackBase.ApiCallback<T> callback) {
        final Context context = ApplicationController.getInstance().getApplicationContext();
        return new ApiResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    Gson gson = new GsonBuilder()
                            .setDateFormat(context.getString(R.string.date_parse_in)).create();
                    T dto = gson.fromJson(jsonObject.getJSONObject(baseKey).toString(), clazz);
                    if (callback != null) {
                        callback.onSuccess(dto);
                    }
                } catch (JSONException e) {
                    onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
                }
            }

            @Override
            public void onFailure(ApiException e) {
                LogUtil.e("Item Failed..");
                LogUtil.e("msg:" + e.getMessage() + ", status: " + e.getStatusCode());
                if (callback != null) {
                    callback.onFailure(e.getMessage(), e.getStatusCode());
                }
            }
        };
    }

    public static <T> void show(String url, final Class<T> clazz, final ApiCallbackBase.ApiCallback<T> callback) {
        final Context context = ApplicationController.getInstance().getApplicationContext();
        ApiRequest.get(url, new ApiResponseHandler() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    Gson gson = new GsonBuilder()
                            .setDateFormat(context.getString(R.string.date_parse_in)).create();
                    T dto = gson.fromJson(jsonObject.getJSONObject(baseKey).toString(), clazz);
                    if (callback != null) {
                        callback.onSuccess(dto);
                    }
                } catch (JSONException e) {
                    onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
                }
            }

            @Override
            public void onFailure(ApiException e) {
                LogUtil.e("Show Failed..");
                LogUtil.e("msg:" + e.getMessage() + ", status: " + e.getStatusCode());
                if (callback != null) {
                    callback.onFailure(e.getMessage(), e.getStatusCode());
                }
            }
        });
    }

}
