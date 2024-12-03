package com.leanplum.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {
    public static final String DEFAULT_STRING_VALUE = "";

    public static void commitChanges(SharedPreferences.Editor editor) {
        try {
            editor.apply();
        } catch (NoSuchMethodError unused) {
            editor.commit();
        }
    }

    private static SharedPreferences getPreferences(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public static String getString(Context context, String str, String str2) {
        return getPreferences(context, str).getString(str2, "");
    }

    public static void setString(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = getPreferences(context, str).edit();
        edit.putString(str2, str3);
        commitChanges(edit);
    }
}
