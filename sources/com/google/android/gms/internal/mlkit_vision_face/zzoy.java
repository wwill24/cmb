package com.google.android.gms.internal.mlkit_vision_face;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import pe.a;

public final class zzoy extends zza {
    zzoy(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.face.aidls.IFaceDetector");
    }

    public final List zzd(a aVar, zzoq zzoq) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, aVar);
        zzc.zza(zza, zzoq);
        Parcel zzb = zzb(3, zza);
        ArrayList<zzow> createTypedArrayList = zzb.createTypedArrayList(zzow.CREATOR);
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
