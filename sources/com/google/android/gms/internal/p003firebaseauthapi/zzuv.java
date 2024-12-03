package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuv  reason: invalid package */
public final class zzuv extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzuv zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public zzajf zzf = zzajf.zzb;

    static {
        zzuv zzuv = new zzuv();
        zzb = zzuv;
        zzakk.zzH(zzuv.class, zzuv);
    }

    private zzuv() {
    }

    public static zzuu zza() {
        return (zzuu) zzb.zzt();
    }

    public static zzuv zzc() {
        return zzb;
    }

    public final zzux zzd() {
        int i10 = this.zzd;
        zzux zzux = zzux.UNKNOWN_CURVE;
        zzux zzux2 = i10 != 0 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? null : zzux.CURVE25519 : zzux.NIST_P521 : zzux.NIST_P384 : zzux.NIST_P256 : zzux.UNKNOWN_CURVE;
        return zzux2 == null ? zzux.UNRECOGNIZED : zzux2;
    }

    public final zzvc zze() {
        zzvc zzb2 = zzvc.zzb(this.zze);
        return zzb2 == null ? zzvc.UNRECOGNIZED : zzb2;
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
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzuv();
        } else {
            if (i11 == 4) {
                return new zzuu((zzut) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
