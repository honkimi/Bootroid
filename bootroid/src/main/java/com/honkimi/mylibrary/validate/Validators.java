package com.honkimi.mylibrary.validate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by honkimi on 2014/05/07.
 */
public class Validators {
    private List<Validatable> validateLists;

    public Validators() {
        validateLists = new ArrayList<Validatable>();
    }

    public void add(Validatable validatable) {
        validateLists.add(validatable);
    }

    public List<Validatable> as_list() {
        return validateLists;
    }
}
