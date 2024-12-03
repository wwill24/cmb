package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.android.gms.common.api.a;

public final class zzmw {
    /* access modifiers changed from: private */
    public String zza;
    /* access modifiers changed from: private */
    public String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public String zzd;
    /* access modifiers changed from: private */
    public zzbm zze;
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

    public final zzmw zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzmw zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzmw zzd(Integer num) {
        this.zzj = Integer.valueOf(num.intValue() & a.e.API_PRIORITY_OTHER);
        return this;
    }

    public final zzmw zze(Boolean bool) {
        this.zzg = bool;
        return this;
    }

    public final zzmw zzf(Boolean bool) {
        this.zzi = bool;
        return this;
    }

    public final zzmw zzg(Boolean bool) {
        this.zzh = bool;
        return this;
    }

    public final zzmw zzh(zzbm zzbm) {
        this.zze = zzbm;
        return this;
    }

    public final zzmw zzi(String str) {
        this.zzf = str;
        return this;
    }

    public final zzmw zzj(String str) {
        this.zzc = str;
        return this;
    }

    public final zzmw zzk(Integer num) {
        this.zzk = num;
        return this;
    }

    public final zzmw zzl(String str) {
        this.zzd = str;
        return this;
    }

    public final zzmy zzm() {
        return new zzmy(this, (zzmx) null);
    }
}
