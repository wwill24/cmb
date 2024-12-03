package com.coffeemeetsbagel.models.util;

import android.text.TextUtils;

public class ModelUtils {
    public static String getIdentifier(String str, long j10) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (j10 == 0) {
            return null;
        }
        return String.valueOf(j10);
    }
}
