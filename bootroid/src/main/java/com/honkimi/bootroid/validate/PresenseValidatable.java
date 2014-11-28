package com.honkimi.bootroid.validate;

import android.widget.EditText;

import com.honkimi.bootroid.R;


/**
 * Created by honkimi on 2014/05/07.
 */
public class PresenseValidatable implements Validatable {
    @Override
    public ValidateDto isValid(EditText editText) {
        boolean isValid = !editText.getText().toString().isEmpty();

        ValidateDto ret = new ValidateDto(isValid, R.string.err_presense);

        return ret;
    }

    @Override
    public String getTailMessage() {
        return null;
    }
}
