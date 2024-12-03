package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzws  reason: invalid package */
public final class zzws extends zzakg implements zzalq {
    private zzws() {
        super(zzwv.zzb);
    }

    public final int zza() {
        return ((zzwv) this.zza).zza();
    }

    public final zzws zzb(zzwu zzwu) {
        zzm();
        zzwv.zzk((zzwv) this.zza, zzwu);
        return this;
    }

    public final zzws zzc(int i10) {
        zzm();
        ((zzwv) this.zza).zzd = i10;
        return this;
    }

    public final zzwu zzd(int i10) {
        return ((zzwv) this.zza).zzd(i10);
    }

    public final List zze() {
        return Collections.unmodifiableList(((zzwv) this.zza).zzh());
    }

    /* synthetic */ zzws(zzwr zzwr) {
        super(zzwv.zzb);
    }
}
