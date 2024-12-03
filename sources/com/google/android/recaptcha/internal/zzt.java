package com.google.android.recaptcha.internal;

public final class zzt extends Exception {
    private final Throwable zza;
    private final zzmi zzb;
    private final int zzc;
    private final int zzd;

    public zzt(int i10, int i11, Throwable th2) {
        this.zzc = i10;
        this.zzd = i11;
        this.zza = th2;
        zzmi zzf = zzmj.zzf();
        zzf.zze(i11);
        zzf.zzp(i10);
        this.zzb = zzf;
    }

    public final Throwable getCause() {
        return this.zza;
    }

    public final zzmi zza() {
        return this.zzb;
    }
}
