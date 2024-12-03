package com.google.android.gms.internal.gtm;

final class zzfp extends zzbr implements zzcr<zzfr> {
    private final zzfr zza = new zzfr();

    public zzfp(zzbv zzbv) {
        super(zzbv);
    }

    public final /* bridge */ /* synthetic */ zzcq zza() {
        return this.zza;
    }

    public final void zzb(String str, String str2) {
        this.zza.zzg.put(str, str2);
    }

    public final void zzc(String str, boolean z10) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.zza.zzd = z10;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.zza.zze = z10;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.zza.zzf = z10 ? 1 : 0;
        } else {
            zzS("bool configuration name not recognized", str);
        }
    }

    public final void zzd(String str, int i10) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zza.zzc = i10;
        } else {
            zzS("int configuration name not recognized", str);
        }
    }

    public final void zze(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zza.zza = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.zza.zzb = Double.parseDouble(str2);
            } catch (NumberFormatException e10) {
                zzT("Error parsing ga_sampleFrequency value", str2, e10);
            }
        } else {
            zzS("string configuration name not recognized", str);
        }
    }
}
