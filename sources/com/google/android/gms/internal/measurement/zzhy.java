package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class zzhy {
    final Uri zza;
    final String zzb;
    final String zzc;
    final boolean zzd;
    final boolean zze;

    public zzhy(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzig) null);
    }

    private zzhy(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, zzig zzig) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z10;
        this.zze = z12;
    }

    public final zzhy zza() {
        return new zzhy((String) null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, (zzig) null);
    }

    public final zzhy zzb() {
        if (this.zzb.isEmpty()) {
            return new zzhy((String) null, this.zza, this.zzb, this.zzc, true, false, this.zze, false, (zzig) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzib zzc(String str, double d10) {
        return new zzhw(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzib zzd(String str, long j10) {
        return new zzhu(this, str, Long.valueOf(j10), true);
    }

    public final zzib zze(String str, String str2) {
        return new zzhx(this, str, str2, true);
    }

    public final zzib zzf(String str, boolean z10) {
        return new zzhv(this, str, Boolean.valueOf(z10), true);
    }
}
