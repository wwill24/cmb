package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

public final class c {
    c(Context context) {
    }

    public static final boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
