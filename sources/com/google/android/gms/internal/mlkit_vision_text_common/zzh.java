package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import pe.a;

public final class zzh extends zza {
    zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    public final void zzd() throws RemoteException {
        zzc(2, zza());
    }

    public final zzl[] zze(a aVar, zzd zzd) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, aVar);
        zzc.zzb(zza, zzd);
        Parcel zzb = zzb(1, zza);
        zzl[] zzlArr = (zzl[]) zzb.createTypedArray(zzl.CREATOR);
        zzb.recycle();
        return zzlArr;
    }
}
