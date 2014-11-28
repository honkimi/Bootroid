package com.honkimi.mylibrary.validate;

/**
 * Created by honkimi on 2014/05/08.
 */
public class ValidateFactory {

    public static Validators getEmailValidators() {
        Validators validators = new Validators();
        validators.add(new PresenseValidatable());
        validators.add(new MinLengthValidatable(4));
        validators.add(new MaxLengthValidatable(320));
        return validators;
    }

    public static Validators getPasswordValidators() {
        Validators validators = new Validators();
        validators.add(new PresenseValidatable());
        validators.add(new MinLengthValidatable(8));
        validators.add(new MaxLengthValidatable(255));
        return validators;
    }

    public static Validators getSmallNameValidators() {
        Validators validators = new Validators();
        validators.add(new PresenseValidatable());
        validators.add(new MinLengthValidatable(1));
        validators.add(new MaxLengthValidatable(20));
        return validators;
    }

    public static Validators getNumberValidators() {
        Validators validators = new Validators();
        validators.add(new PresenseValidatable());
        validators.add(new NumberValidatable());
        validators.add(new MinNumValidatable(1));
        validators.add(new MaxNumValidatable(999));
        return validators;
    }

    public static Validators getPriceValidators() {
        Validators validators = new Validators();
        validators.add(new PresenseValidatable());
        validators.add(new NumberValidatable());
        validators.add(new MinNumValidatable(300));
        validators.add(new MaxNumValidatable(100000));
        return validators;
    }

    public static Validators getLargeTextValidators() {
        Validators validators = new Validators();
        validators.add(new PresenseValidatable());
        validators.add(new MinLengthValidatable(1));
        validators.add(new MaxLengthValidatable(1000));
        return validators;
    }
}
