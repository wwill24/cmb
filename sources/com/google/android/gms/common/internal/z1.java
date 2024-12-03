package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;
import pe.a;

public abstract class z1 extends zzb implements a2 {
    public z1() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static a2 c(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof a2) {
            return (a2) queryLocalInterface;
        }
        return new y1(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            a zzd = zzd();
            parcel2.writeNoException();
            zzc.zzf(parcel2, zzd);
        } else if (i10 != 2) {
            return false;
        } else {
            int zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(zzc);
        }
        return true;
    }
}
