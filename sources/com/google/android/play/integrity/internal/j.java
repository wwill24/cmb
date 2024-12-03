package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class j extends e implements k {
    public static k c(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IIntegrityService");
        if (queryLocalInterface instanceof k) {
            return (k) queryLocalInterface;
        }
        return new i(iBinder);
    }
}
