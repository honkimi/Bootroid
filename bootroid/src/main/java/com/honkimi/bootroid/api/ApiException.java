package com.honkimi.bootroid.api;

/**
 * Created by honkimi on 2014/05/07.
 */
public class ApiException extends Exception {
    public static final int UNKNOWN_ERROR = 999;
    public static final int JSON_PARSE_ERROR = 1;
    public static final int NO_REFRESH_TOKEN_ERROR = 2;

    private int statusCode;

    public ApiException(String str) {
        super(str);
    }

    public ApiException(String str, int code) {
        this(str);
        this.statusCode = code;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
