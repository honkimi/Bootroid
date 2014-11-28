package com.honkimi.bootroid.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by honkimi on 14/11/28.
 */
public class KeyBoardUtil {
    public static void hide(Context context, EditText... editTextList) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        for (EditText ed : editTextList) {
            inputMethodManager.hideSoftInputFromWindow(ed.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
