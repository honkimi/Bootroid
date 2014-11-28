package com.honkimi.sample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.honkimi.bootroid.validate.ErrorMessagesText;
import com.honkimi.bootroid.validate.MaxNumValidatable;
import com.honkimi.bootroid.validate.MinNumValidatable;
import com.honkimi.bootroid.validate.NumberValidatable;
import com.honkimi.bootroid.validate.ValidateManager;
import com.honkimi.bootroid.validate.Validators;
import com.honkimi.sample.R;

import java.util.List;

/**
 * Created by honkimi on 14/11/28.
 */
public class ValidateActivity extends DetailActivity {

    private ErrorMessagesText errorMessagesText;
    private EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);

        errorMessagesText = (ErrorMessagesText) findViewById(R.id.error);
        number = (EditText) findViewById(R.id.number);

        setListener();
    }

    private void setListener() {
        findViewById(R.id.validate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!errorMessagesText.isSetErrors(validate())) {
                    Toast.makeText(ValidateActivity.this, "Success!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private List<String> validate() {
        ValidateManager mng = new ValidateManager(this);
        Validators validators = new Validators();
        validators.add(new NumberValidatable());
        validators.add(new MaxNumValidatable(100));
        validators.add(new MinNumValidatable(1));

        mng.add(number, validators);

        return mng.validate();
    }
}
