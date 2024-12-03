package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import pe.a;

public final class y1 extends zza implements a2 {
    y1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final int zzc() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final a zzd() throws RemoteException {
        Parcel zzB = zzB(1, zza());
        a c10 = a.C0503a.c(zzB.readStrongBinder());
        zzB.recycle();
        return c10;
    }
}
