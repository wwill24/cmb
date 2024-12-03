package com.google.android.play.integrity.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class i extends a implements k {
    i(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.integrity.protocol.IIntegrityService");
    }

    public final void p0(Bundle bundle, m mVar) throws RemoteException {
        Parcel c10 = c();
        f.c(c10, bundle);
        f.d(c10, mVar);
        f(2, c10);
    }
}
