package com.google.android.gms.cloudmessaging;

import android.util.Log;

public final class g extends ClassLoader {
    /* access modifiers changed from: protected */
    public final Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
            return super.loadClass(str, z10);
        }
        Log.isLoggable("CloudMessengerCompat", 3);
        return zzd.class;
    }
}
