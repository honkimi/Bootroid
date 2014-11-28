package com.honkimi.bootroid.validate;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.EditText;

import com.honkimi.bootroid.R;
import com.honkimi.bootroid.utils.LogUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by honkimi on 2014/05/07.
 */
public class ValidateManager {
    private Map<EditText, Validators> validateMap;
    private List<Drawable> editTextDrawableList;
    private Context context;

    public ValidateManager(Context context) {
        this.context = context;
        validateMap = new LinkedHashMap<EditText, Validators>();
        editTextDrawableList = new ArrayList<Drawable>();
    }

    public void add(EditText editText, Validators validators) {
        validateMap.put(editText, validators);
        editTextDrawableList.add(editText.getBackground());
    }

    public List<String> validate() {
        List<String> errorMessages = new ArrayList<String>();

        int idx = 0;
        for (Map.Entry<EditText, Validators> keyValue : validateMap.entrySet()) {
            Validators validators = keyValue.getValue();
            EditText editText = keyValue.getKey();
            setOriginalEditTextStyle(editText, editTextDrawableList.get(idx));

            for (Validatable validatable : validators.as_list()) {
                ValidateDto validateResult = validatable.isValid(editText);
                if (validateResult.isValid()) {
                    continue;
                }
                // validate error
                StringBuffer errStr = new StringBuffer();
                if (editText.getContentDescription() != null) {
                    errStr.append(editText.getContentDescription().toString())
                            .append(context.getString(validateResult.getMessage()));
                    editText.setBackgroundResource(R.drawable.error_edit_text);
                } else {
                    throw new RuntimeException("No EditText Content description!");
                }
                if (validatable.getTailMessage() != null) {
                    errStr.append(validatable.getTailMessage());
                }
                LogUtil.v(errStr.toString());
                errorMessages.add(errStr.toString());
            }

            idx++;
        }

        return errorMessages;
    }

    // set edittext original style.
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setOriginalEditTextStyle(EditText editText, Drawable drawable) {
        int sdk = android.os.Build.VERSION.SDK_INT;
        int jellyBean = android.os.Build.VERSION_CODES.JELLY_BEAN;
        if (sdk < jellyBean) {
            editText.setBackgroundDrawable(drawable);
        } else {
            editText.setBackground(drawable);
        }

    }
}
