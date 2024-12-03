package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import pe.a;

public final class zzsw extends zza {
    zzsw(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
    }

    public final List zzd(a aVar, zztf zztf) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, aVar);
        zzc.zza(zza, zztf);
        Parcel zzb = zzb(3, zza);
        ArrayList<zzsm> createTypedArrayList = zzb.createTypedArrayList(zzsm.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void zze() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzc(2, zza());
    }
}
