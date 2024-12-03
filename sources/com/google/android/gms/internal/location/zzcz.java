package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.o0;

final class zzcz extends o0 {
    /* access modifiers changed from: private */
    public final zzcs zza;

    zzcz(zzcs zzcs) {
        this.zza = zzcs;
    }

    public final void zzd(Location location) {
        this.zza.zza().c(new zzcx(this, location));
    }

    public final void zze() {
        this.zza.zza().c(new zzcy(this));
    }

    /* access modifiers changed from: package-private */
    public final zzcz zzf(k kVar) {
        this.zza.zzc(kVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        this.zza.zza().a();
    }
}
