package com.google.android.gms.internal.gtm;

import java.io.IOException;

public abstract class zztj {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zztk zzc;

    /* synthetic */ zztj(zzti zzti) {
    }

    public static int zzs(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long zzt(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public abstract int zza();

    public abstract int zzb(int i10) throws zzvk;

    public abstract int zzc() throws IOException;

    public abstract zztd zzd() throws IOException;

    public abstract String zze() throws IOException;

    public abstract String zzf() throws IOException;

    public abstract void zzg(int i10) throws zzvk;

    public abstract void zzh(int i10);

    public abstract boolean zzi() throws IOException;

    public abstract boolean zzj() throws IOException;

    public abstract boolean zzk(int i10) throws IOException;
}
