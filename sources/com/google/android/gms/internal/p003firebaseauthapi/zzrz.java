package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrz  reason: invalid package */
public final class zzrz extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzrz zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzajf zzf = zzajf.zzb;
    private zzsf zzg;

    static {
        zzrz zzrz = new zzrz();
        zzb = zzrz;
        zzakk.zzH(zzrz.class, zzrz);
    }

    private zzrz() {
    }

    public static zzry zzb() {
        return (zzry) zzb.zzt();
    }

    public static zzrz zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzrz) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzi(zzrz zzrz, zzsf zzsf) {
        zzsf.getClass();
        zzrz.zzg = zzsf;
        zzrz.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzsf zze() {
        zzsf zzsf = this.zzg;
        return zzsf == null ? zzsf.zzd() : zzsf;
    }

    public final zzajf zzf() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzrz();
        } else {
            if (i11 == 4) {
                return new zzry((zzrx) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
