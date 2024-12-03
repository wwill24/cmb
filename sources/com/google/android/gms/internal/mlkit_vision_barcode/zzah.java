package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzah extends zzb implements zzai {
    public static zzai zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
        if (queryLocalInterface instanceof zzai) {
            return (zzai) queryLocalInterface;
        }
        return new zzag(iBinder);
    }
}
