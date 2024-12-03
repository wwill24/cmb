package com.google.android.gms.internal.play_billing;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzf extends zzi implements zzg {
    public zzf() {
        super("com.android.vending.billing.IInAppBillingServiceCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzj.zza(parcel, Bundle.CREATOR);
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
            zza(bundle);
            parcel2.writeNoException();
            return true;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + dataAvail);
    }
}
