package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zza;
import com.google.android.gms.internal.auth.zzc;

public final class e extends zza implements g {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    public final void C(boolean z10) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, z10);
        zzc(1, zza);
    }

    public final void l0(d dVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, dVar);
        zza.writeString(str);
        zzc(2, zza);
    }

    public final void m0(d dVar, Account account) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, dVar);
        zzc.zzd(zza, account);
        zzc(3, zza);
    }
}
