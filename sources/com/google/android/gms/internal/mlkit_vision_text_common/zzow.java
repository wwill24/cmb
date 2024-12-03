package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import pe.a;

public final class zzow extends zza {
    zzow(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizer");
    }

    public final zzpg zzd(a aVar, zzou zzou) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, aVar);
        zzc.zzb(zza, zzou);
        Parcel zzb = zzb(3, zza);
        zzpg zzpg = (zzpg) zzc.zza(zzb, zzpg.CREATOR);
        zzb.recycle();
        return zzpg;
    }

    public final void zze() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzc(2, zza());
    }
}
