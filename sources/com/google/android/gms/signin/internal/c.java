package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class c extends zaa {
    c(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void c(int i10) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i10);
        zac(7, zaa);
    }

    public final void f(i iVar, int i10, boolean z10) throws RemoteException {
        Parcel zaa = zaa();
        zac.zae(zaa, iVar);
        zaa.writeInt(i10);
        zac.zac(zaa, z10);
        zac(9, zaa);
    }

    public final void g(zai zai, ze.c cVar) throws RemoteException {
        Parcel zaa = zaa();
        zac.zad(zaa, zai);
        zac.zae(zaa, cVar);
        zac(12, zaa);
    }
}
