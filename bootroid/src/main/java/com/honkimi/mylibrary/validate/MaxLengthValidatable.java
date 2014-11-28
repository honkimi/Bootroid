package com.honkimi.mylibrary.validate;

import android.widget.EditText;

import com.honkimi.mylibrary.R;


/**
 * Created by honkimi on 2014/05/07.
 */
public class MaxLengthValidatable implements Validatable {
    // default length
    private int maxText;

    public MaxLengthValidatable(int maxText) {
        this.maxText = maxText;
    }

    @Override
    public ValidateDto isValid(EditText editText) {
        boolean isValid = true;
        if (editText.getText().length() > maxText) {
            isValid = false;
        }

        ValidateDto ret = new ValidateDto(isValid, R.string.err_length_max);
        return ret;
    }

    @Override
    public String getTailMessage() {
        return String.valueOf(maxText);
    }


}
