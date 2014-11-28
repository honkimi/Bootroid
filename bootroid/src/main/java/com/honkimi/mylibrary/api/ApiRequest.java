package com.honkimi.mylibrary.api;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.honkimi.mylibrary.application.ApplicationController;
import com.honkimi.mylibrary.utils.LogUtil;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by honkimi on 2014/05/07.
 */
public class ApiRequest {

    public static interface Paramable {
        JSONObject toJSON() throws JSONException;
    }

    public static void get(String url, final ApiResponseHandler handler) {
        try {
            request(Request.Method.GET, url, null, handler);
        } catch (JSONException e) {
            handler.onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
        }
    }

    public static void post(String url, Paramable params, final ApiResponseHandler handler) {
        try {
            post(url, params.toJSON(), handler);
        } catch (JSONException e) {
            handler.onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
        }
    }

    public static void post(String url, JSONObject jsonObject, final ApiResponseHandler handler) {
        try {
            request(Request.Method.POST, url, jsonObject, handler);
        } catch (JSONException e) {
            handler.onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
        }
    }

    public static void patch(String url, Paramable params, final ApiResponseHandler handler) {
        try {
            patch(url, params.toJSON(), handler);
        } catch (JSONException e) {
            handler.onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
        }
    }

    public static void patch(String url, JSONObject jsonObject, final ApiResponseHandler handler) {
        try {
            request(Request.Method.PATCH, url, jsonObject, handler);
        } catch (JSONException e) {
            handler.onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
        }
    }

    public static void delete(String url, final ApiResponseHandler handler) {
        try {
            request(Request.Method.DELETE, url, null, handler);
        } catch (JSONException e) {
            handler.onFailure(new ApiException(e.getMessage(), ApiException.JSON_PARSE_ERROR));
        }
    }

    private static void request(final int method, final String url, final JSONObject params, final ApiResponseHandler handler) throws JSONException {
        LogUtil.d(url);
        JsonObjectRequest req = new JsonObjectRequest(method, url, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        handler.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                LogUtil.e("Error: " + e.getMessage());
                e.printStackTrace();

                int status = ApiException.UNKNOWN_ERROR;
                if (e.networkResponse != null) {
                    status = e.networkResponse.statusCode;
                }

                LogUtil.e("Error status: " + status);
                try {
                    String responseBody = new String(e.networkResponse.data, "utf-8");
                    JSONObject jsonObject = new JSONObject(responseBody);
                    LogUtil.e(jsonObject);
                } catch (Exception e2) {
                }

                handler.onFailure(new ApiException(e.getMessage(), status));
            }
        }
        );
        ApplicationController.getInstance().addToRequestQueue(req);
    }
}
