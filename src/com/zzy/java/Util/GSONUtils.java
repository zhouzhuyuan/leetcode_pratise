package com.zzy.java.Util;

import com.google.gson.Gson;

public class GSONUtils {

    private static final Gson defaultGSON = new Gson();

    public String toJson(Object object) {
        return defaultGSON.toJson(object);
    }

    public <T> T fromJson(String src, Class<T> clazz) {
        return defaultGSON.fromJson(src, clazz);
    }

}
