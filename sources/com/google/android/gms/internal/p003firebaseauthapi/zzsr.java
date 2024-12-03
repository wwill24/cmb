package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsr  reason: invalid package */
public final class zzsr extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzsr zzb;
    private int zzd;
    private zzsu zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzsr zzsr = new zzsr();
        zzb = zzsr;
        zzakk.zzH(zzsr.class, zzsr);
    }

    private zzsr() {
    }

    public static zzsq zzb() {
        return (zzsq) zzb.zzt();
    }

    public static zzsr zzd() {
        return zzb;
    }

    public static zzsr zze(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzsr) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzg(zzsr zzsr, zzsu zzsu) {
        zzsu.getClass();
        zzsr.zze = zzsu;
        zzsr.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzsu zzf() {
        zzsu zzsu = this.zze;
        return zzsu == null ? zzsu.zzd() : zzsu;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzsr();
        } else {
            if (i11 == 4) {
                return new zzsq((zzsp) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
