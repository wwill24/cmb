package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.l0;

final class zzcw extends l0 {
    /* access modifiers changed from: private */
    public final zzcs zza;

    zzcw(zzcs zzcs) {
        this.zza = zzcs;
    }

    public final void zzd(LocationAvailability locationAvailability) throws RemoteException {
        this.zza.zza().c(new zzcu(this, locationAvailability));
    }

    public final void zze(LocationResult locationResult) throws RemoteException {
        this.zza.zza().c(new zzct(this, locationResult));
    }

    public final void zzf() {
        this.zza.zza().c(new zzcv(this));
    }

    /* access modifiers changed from: package-private */
    public final zzcw zzg(k kVar) {
        this.zza.zzc(kVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzh() {
        this.zza.zza().a();
    }
}
