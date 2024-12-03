package com.google.android.gms.internal.mlkit_vision_text_common;

import java.util.Map;

final class zzba extends zzap {
    final /* synthetic */ zzbc zza;
    private final Object zzb;
    private int zzc;

    zzba(zzbc zzbc, int i10) {
        this.zza = zzbc;
        this.zzb = zzbc.zzg(zzbc, i10);
        this.zzc = i10;
    }

    private final void zza() {
        int i10 = this.zzc;
        if (i10 == -1 || i10 >= this.zza.size() || !zzw.zza(this.zzb, zzbc.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzv(this.zzb);
        }
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i10 = this.zzc;
        if (i10 == -1) {
            return null;
        }
        return zzbc.zzj(this.zza, i10);
    }

    public final Object setValue(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i10 = this.zzc;
        if (i10 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        Object zzj = zzbc.zzj(this.zza, i10);
        zzbc.zzm(this.zza, this.zzc, obj);
        return zzj;
    }
}
