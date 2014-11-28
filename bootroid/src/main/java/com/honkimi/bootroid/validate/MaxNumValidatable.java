package com.honkimi.bootroid.validate;

import android.widget.EditText;

import com.honkimi.bootroid.R;


/**
 * Created by honkimi on 2014/05/07.
 */
public class MaxNumValidatable implements Validatable {
    // default length
    private int maxNum;

    public MaxNumValidatable(int maxNum) {
        this.maxNum = maxNum;
    }

    @Override
    public ValidateDto isValid(EditText editText) {
        try {
            boolean isValid = true;
            if (Integer.valueOf(editText.getText().toString()) > maxNum) {
                isValid = false;
            }

            return new ValidateDto(isValid, R.string.err_num_max);
        } catch (NumberFormatException e) {
            return new ValidateDto(false, R.string.err_num_max);
        }
    }

    @Override
    public String getTailMessage() {
        return String.valueOf(maxNum);
    }


}
