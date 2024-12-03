package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;
import pe.a;

public final class v0 extends zza implements x0 {
    v0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final zzq V(zzo zzo) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzo);
        Parcel zzB = zzB(6, zza);
        zzq zzq = (zzq) zzc.zza(zzB, zzq.CREATOR);
        zzB.recycle();
        return zzq;
    }

    public final zzq d0(zzo zzo) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzo);
        Parcel zzB = zzB(8, zza);
        zzq zzq = (zzq) zzc.zza(zzB, zzq.CREATOR);
        zzB.recycle();
        return zzq;
    }

    public final boolean k(zzs zzs, a aVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzs);
        zzc.zzf(zza, aVar);
        Parcel zzB = zzB(5, zza);
        boolean zzg = zzc.zzg(zzB);
        zzB.recycle();
        return zzg;
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzB = zzB(7, zza());
        boolean zzg = zzc.zzg(zzB);
        zzB.recycle();
        return zzg;
    }
}
