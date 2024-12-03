package me;

import android.os.Looper;

public final class v {
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
