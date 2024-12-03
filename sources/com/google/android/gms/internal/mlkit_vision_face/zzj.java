package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import pe.a;

public final class zzj extends zza {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    public final void zzd() throws RemoteException {
        zzc(3, zza());
    }

    public final zzf[] zze(a aVar, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, aVar);
        zzc.zza(zza, zzp);
        Parcel zzb = zzb(1, zza);
        zzf[] zzfArr = (zzf[]) zzb.createTypedArray(zzf.CREATOR);
        zzb.recycle();
        return zzfArr;
    }

    public final zzf[] zzf(a aVar, a aVar2, a aVar3, int i10, int i11, int i12, int i13, int i14, int i15, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, aVar);
        zzc.zzb(zza, aVar2);
        zzc.zzb(zza, aVar3);
        zza.writeInt(i10);
        zza.writeInt(i11);
        zza.writeInt(i12);
        zza.writeInt(i13);
        zza.writeInt(i14);
        zza.writeInt(i15);
        zzc.zza(zza, zzp);
        Parcel zzb = zzb(4, zza);
        zzf[] zzfArr = (zzf[]) zzb.createTypedArray(zzf.CREATOR);
        zzb.recycle();
        return zzfArr;
    }
}
