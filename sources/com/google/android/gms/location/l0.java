package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class l0 extends zzb implements m0 {
    public l0() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static m0 zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        if (queryLocalInterface instanceof m0) {
            return (m0) queryLocalInterface;
        }
        return new k0(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            zzc.zzb(parcel);
            zze((LocationResult) zzc.zza(parcel, LocationResult.CREATOR));
        } else if (i10 == 2) {
            zzc.zzb(parcel);
            zzd((LocationAvailability) zzc.zza(parcel, LocationAvailability.CREATOR));
        } else if (i10 != 3) {
            return false;
        } else {
            zzf();
        }
        return true;
    }
}
