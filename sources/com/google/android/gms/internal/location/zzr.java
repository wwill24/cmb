package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzr extends zzb implements zzs {
    public zzr() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        zzc.zzb(parcel);
        zzb((LocationSettingsResult) zzc.zza(parcel, LocationSettingsResult.CREATOR));
        return true;
    }
}
