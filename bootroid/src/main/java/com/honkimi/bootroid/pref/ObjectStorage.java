package com.honkimi.bootroid.pref;

import com.google.gson.Gson;

/**
 * Created by honkimi on 14/11/28.
 */
public class ObjectStorage {
    public static void save(Object src, String key) {
        save(new Gson(), src, key);
    }

    public static void save(Gson gson, Object src, String key) {
        String json = gson.toJson(src);
        new CachePref().put(key, json);
    }

    public static <T> T get(String key, Class<T> klazz) {
        return get(new Gson(), key, klazz);
    }

    public static <T> T get(Gson gson, String key, Class<T> klazz) {
        String jsonStr = new CachePref().get(key, "");
        if (jsonStr.equals("")) {
            return null;
        }
        return gson.fromJson(jsonStr, klazz);
    }

    public static void remove(String key) {
        new CachePref().remove(key);
    }
}
