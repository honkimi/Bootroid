package com.honkimi.bootroid.validate;

/**
 * Created by honkimi on 2014/05/07.
 */
public class ValidateDto {
    private boolean ret;
    private int message;

    public ValidateDto(boolean ret, int message) {
        this.ret = ret;
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

    public boolean isValid() {
        return ret;
    }
}
