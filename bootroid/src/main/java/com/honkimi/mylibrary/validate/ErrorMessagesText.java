package com.honkimi.mylibrary.validate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by honkimi on 2014/05/08.
 */
public class ErrorMessagesText extends TextView {
    public ErrorMessagesText(Context context) {
        super(context);
    }

    public ErrorMessagesText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ErrorMessagesText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean isSetErrors(List<String> errorMessages) {
        if (errorMessages.isEmpty()) {
            setVisibility(View.GONE);
            return false;
        }
        setErrMsg(errorMessages);
        setVisibility(View.VISIBLE);
        requestFocus();
        return true;
    }

    private void setErrMsg(List<String> errorMessages) {
        StringBuffer errorStr = new StringBuffer();
        for (String errorMessage : errorMessages) {
            errorStr.append(errorMessage).append("\n");
        }
        setText(errorStr.toString());
    }

    public void setMessage(String text) {
        setVisibility(View.VISIBLE);
        setText(text);
    }
}
