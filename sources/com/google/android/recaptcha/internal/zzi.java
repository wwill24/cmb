package com.google.android.recaptcha.internal;

public final class zzi implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        String m02 = StringsKt__StringsKt.m0(String.valueOf(this.zzb / ((long) this.zza)), 10, 0, 2, (Object) null);
        String m03 = StringsKt__StringsKt.m0(String.valueOf(this.zzc), 10, 0, 2, (Object) null);
        String m04 = StringsKt__StringsKt.m0(String.valueOf(this.zzb), 10, 0, 2, (Object) null);
        String m05 = StringsKt__StringsKt.m0(String.valueOf(this.zza), 5, 0, 2, (Object) null);
        return "avgExecutionTime: " + m02 + " us| maxExecutionTime: " + m03 + " us| totalTime: " + m04 + " us| #Usages: " + m05;
    }

    /* renamed from: zza */
    public final int compareTo(zzi zzi) {
        return b.a(Long.valueOf(this.zzb), Long.valueOf(zzi.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j10) {
        this.zzc = j10;
    }

    public final void zzf(long j10) {
        this.zzb = j10;
    }

    public final void zzg(int i10) {
        this.zza = i10;
    }
}
