package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class o0 extends zzb implements p0 {
    public o0() {
        super("com.google.android.gms.location.ILocationListener");
    }

    public static p0 zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        if (queryLocalInterface instanceof p0) {
            return (p0) queryLocalInterface;
        }
        return new n0(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zzc.zzb(parcel);
            zzd((Location) zzc.zza(parcel, Location.CREATOR));
        } else if (i10 != 2) {
            return false;
        } else {
            zze();
        }
        return true;
    }
}
