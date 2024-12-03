package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.common.api.a;

public final class zzmt {
    /* access modifiers changed from: private */
    public String zza;
    /* access modifiers changed from: private */
    public String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public String zzd;
    /* access modifiers changed from: private */
    public zzbn zze;
    /* access modifiers changed from: private */
    public String zzf;
    /* access modifiers changed from: private */
    public Boolean zzg;
    /* access modifiers changed from: private */
    public Boolean zzh;
    /* access modifiers changed from: private */
    public Boolean zzi;
    /* access modifiers changed from: private */
    public Integer zzj;
    /* access modifiers changed from: private */
    public Integer zzk;

    public final zzmt zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzmt zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzmt zzd(Integer num) {
        this.zzj = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzmt zze(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zzmt zzf(Boolean bool) {
        this.zzi = bool;
        return this;
    }

    public final zzmt zzg(Boolean bool) {
        this.zzh = bool;
        return this;
    }

    public final zzmt zzh(zzbn zzbn) {
        this.zze = zzbn;
        return this;
    }

    public final zzmt zzi(String str) {
        this.zzf = str;
        return this;
    }

    public final zzmt zzj(String str) {
        this.zzc = str;
        return this;
    }

    public final zzmt zzk(Integer num) {
        this.zzk = num;
        return this;
    }

    public final zzmt zzl(String str) {
        this.zzd = str;
        return this;
    }

    public final zzmv zzm() {
        return new zzmv(this, (zzmu) null);
    }
}
