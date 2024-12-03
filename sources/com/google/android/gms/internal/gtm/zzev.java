package com.google.android.gms.internal.gtm;

final class zzev implements zzcr<zzew> {
    private final zzbv zza;
    private final zzew zzb = new zzew();

    public zzev(zzbv zzbv) {
        this.zza = zzbv;
    }

    public final /* bridge */ /* synthetic */ zzcq zza() {
        return this.zzb;
    }

    public final void zzb(String str, String str2) {
    }

    public final void zzc(String str, boolean z10) {
        if ("ga_dryRun".equals(str)) {
            this.zzb.zze = z10 ? 1 : 0;
            return;
        }
        this.zza.zzm().zzS("Bool xml configuration name not recognized", str);
    }

    public final void zzd(String str, int i10) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.zzb.zzd = i10;
        } else {
            this.zza.zzm().zzS("Int xml configuration name not recognized", str);
        }
    }

    public final void zze(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.zzb.zza = str2;
        } else if ("ga_appVersion".equals(str)) {
            this.zzb.zzb = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.zzb.zzc = str2;
        } else {
            this.zza.zzm().zzS("String xml configuration name not recognized", str);
        }
    }
}
