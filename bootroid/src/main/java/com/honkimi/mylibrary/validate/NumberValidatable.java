package com.honkimi.mylibrary.validate;

import android.widget.EditText;

import com.honkimi.mylibrary.R;

import java.util.regex.Pattern;


/**
 * Created by honkimi on 2014/05/07.
 */
public class NumberValidatable implements Validatable {
    @Override
    public ValidateDto isValid(EditText editText) {
        String input = editText.getText().toString();

        Pattern pattern = Pattern.compile(".*[^0-9].*");
        boolean isValid = !pattern.matcher(input).matches();

        ValidateDto ret = new ValidateDto(isValid, R.string.err_number);

        return ret;
    }

    @Override
    public String getTailMessage() {
        return null;
    }
}
