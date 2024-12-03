package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.internal.h;

public final class zzp extends zza {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.data.IGoogleAuthService");
    }

    public final void zzd(h hVar, zzbw zzbw) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, hVar);
        zzc.zzd(zza, zzbw);
        zzc(2, zza);
    }

    public final void zze(zzm zzm, AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzm);
        zzc.zzd(zza, accountChangeEventsRequest);
        zzc(4, zza);
    }

    public final void zzf(zzo zzo, Account account, String str, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzo);
        zzc.zzd(zza, account);
        zza.writeString(str);
        zzc.zzd(zza, bundle);
        zzc(1, zza);
    }

    public final void zzg(zzk zzk, Account account) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzk);
        zzc.zzd(zza, account);
        zzc(6, zza);
    }

    public final void zzh(zzk zzk, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzk);
        zza.writeString(str);
        zzc(3, zza);
    }
}
