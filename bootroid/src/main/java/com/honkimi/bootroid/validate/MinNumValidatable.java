package com.honkimi.bootroid.validate;

import android.widget.EditText;

import com.honkimi.bootroid.R;


/**
 * Created by honkimi on 2014/05/07.
 */
public class MinNumValidatable implements Validatable {
    // default length
    private int minNum;

    public MinNumValidatable(int minNum) {
        this.minNum = minNum;
    }

    @Override
    public ValidateDto isValid(EditText editText) {
        boolean isValid = true;
        try {
            if (Integer.valueOf(editText.getText().toString()) < minNum) {
                isValid = false;
            }
            return new ValidateDto(isValid, R.string.err_num_min);

        } catch (NumberFormatException e) {
            return new ValidateDto(false, R.string.err_num_min);
        }
    }

    @Override
    public String getTailMessage() {
        return String.valueOf(minNum);
    }


}
