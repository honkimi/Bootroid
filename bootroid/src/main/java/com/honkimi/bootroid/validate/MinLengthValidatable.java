package com.honkimi.bootroid.validate;

import android.widget.EditText;

import com.honkimi.bootroid.R;


/**
 * Created by honkimi on 2014/05/07.
 */
public class MinLengthValidatable implements Validatable {
    // default length
    private int minText;

    public MinLengthValidatable(int minText) {
        this.minText = minText;
    }

    @Override
    public ValidateDto isValid(EditText editText) {
        boolean isValid = true;
        if (editText.getText().length() < minText) {
            isValid = false;
        }

        ValidateDto ret = new ValidateDto(isValid, R.string.err_length_min);
        return ret;
    }

    @Override
    public String getTailMessage() {
        return String.valueOf(minText);
    }

}
