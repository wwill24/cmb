package com.google.android.gms.internal.fido;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions;

public final class zzs extends zza {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.fido.fido2.internal.regular.IFido2AppService");
    }

    public final void zzc(zzr zzr, PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzr);
        zzc.zzd(zza, publicKeyCredentialCreationOptions);
        zzb(1, zza);
    }

    public final void zzd(zzr zzr, PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzr);
        zzc.zzd(zza, publicKeyCredentialRequestOptions);
        zzb(2, zza);
    }

    public final void zze(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zze);
        zzb(3, zza);
    }
}
