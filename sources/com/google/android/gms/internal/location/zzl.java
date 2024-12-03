package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzl extends zzb implements zzm {
    public zzl() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            int readInt = parcel.readInt();
            String[] createStringArray = parcel.createStringArray();
            zzc.zzb(parcel);
            zzb(readInt, createStringArray);
        } else if (i10 == 2) {
            int readInt2 = parcel.readInt();
            String[] createStringArray2 = parcel.createStringArray();
            zzc.zzb(parcel);
            zzd(readInt2, createStringArray2);
        } else if (i10 != 3) {
            return false;
        } else {
            zzc.zzb(parcel);
            zzc(parcel.readInt(), (PendingIntent) zzc.zza(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
