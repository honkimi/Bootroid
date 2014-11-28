package com.honkimi.bootroid.api;

/**
 * Created by honkimi on 2014/05/07.
 */
public interface ApiCallbackBase {
    void onFailure(String message, int code);

    public static interface ApiCallback<P> extends ApiCallbackBase {
        void onSuccess(P response);
    }
}
