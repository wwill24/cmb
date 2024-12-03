package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzsy extends zzb implements zzsz {
    public static zzsz zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
        if (queryLocalInterface instanceof zzsz) {
            return (zzsz) queryLocalInterface;
        }
        return new zzsx(iBinder);
    }
}
