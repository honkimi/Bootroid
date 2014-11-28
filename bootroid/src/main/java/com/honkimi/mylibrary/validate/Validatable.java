package com.honkimi.mylibrary.validate;

import android.widget.EditText;

/**
 * Created by honkimi on 2014/05/07.
 */
public interface Validatable {
    ValidateDto isValid(EditText editText);

    String getTailMessage();
}
