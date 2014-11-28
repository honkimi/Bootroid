package com.honkimi.bootroid.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.honkimi.bootroid.application.ApplicationController;

/**
 * Created by honkimi on 14/11/28.
 */
public class BasePref {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public BasePref(String prefName) {
        Context context = ApplicationController.getInstance().getApplicationContext();
        pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public boolean getBool(String key, boolean defaultValue) {
        return pref.getBoolean(key, defaultValue);
    }

    public void putBool(String key, boolean value) {
        editor.putBoolean(key, value).commit();
    }

    public String get(String key, String defaultValue) {
        return pref.getString(key, defaultValue);
    }

    public void put(String key, String value) {
        editor.putString(key, value).commit();
    }

    public int getInt(String key, int defaultValue) {
        return pref.getInt(key, defaultValue);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value).commit();
    }

    public long getLong(String key, long defaultValue) {
        return pref.getLong(key, defaultValue);
    }

    public void putLong(String key, long value) {
        editor.putLong(key, value).commit();
    }

    public SharedPreferences getPref() {
        return pref;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public void clear() {
        editor.clear().commit();
    }

    public void remove(String key) {
        editor.remove(key).commit();
    }
}
