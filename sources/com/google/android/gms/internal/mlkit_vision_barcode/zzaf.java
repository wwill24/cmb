package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import pe.a;

public final class zzaf extends zza {
    zzaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
    }

    public final void zzd() throws RemoteException {
        zzc(3, zza());
    }

    public final zzq[] zze(a aVar, zzaj zzaj) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, aVar);
        zzc.zza(zza, zzaj);
        Parcel zzb = zzb(1, zza);
        zzq[] zzqArr = (zzq[]) zzb.createTypedArray(zzq.CREATOR);
        zzb.recycle();
        return zzqArr;
    }

    public final zzq[] zzf(a aVar, zzaj zzaj) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, aVar);
        zzc.zza(zza, zzaj);
        Parcel zzb = zzb(2, zza);
        zzq[] zzqArr = (zzq[]) zzb.createTypedArray(zzq.CREATOR);
        zzb.recycle();
        return zzqArr;
    }
}
