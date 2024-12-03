package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzum  reason: invalid package */
public final class zzum extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzum zzb;
    private int zzd;
    private zzuv zze;
    private zzug zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzum zzum = new zzum();
        zzb = zzum;
        zzakk.zzH(zzum.class, zzum);
    }

    private zzum() {
    }

    public static zzul zzc() {
        return (zzul) zzb.zzt();
    }

    public static zzum zze() {
        return zzb;
    }

    static /* synthetic */ void zzg(zzum zzum, zzuv zzuv) {
        zzuv.getClass();
        zzum.zze = zzuv;
        zzum.zzd |= 1;
    }

    static /* synthetic */ void zzh(zzum zzum, zzug zzug) {
        zzug.getClass();
        zzum.zzf = zzug;
        zzum.zzd |= 2;
    }

    public final zzud zza() {
        int i10 = this.zzg;
        zzud zzud = zzud.UNKNOWN_FORMAT;
        zzud zzud2 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? null : zzud.DO_NOT_USE_CRUNCHY_UNCOMPRESSED : zzud.COMPRESSED : zzud.UNCOMPRESSED : zzud.UNKNOWN_FORMAT;
        return zzud2 == null ? zzud.UNRECOGNIZED : zzud2;
    }

    public final zzug zzb() {
        zzug zzug = this.zzf;
        return zzug == null ? zzug.zzc() : zzug;
    }

    public final zzuv zzf() {
        zzuv zzuv = this.zze;
        return zzuv == null ? zzuv.zzc() : zzuv;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzum();
        } else {
            if (i11 == 4) {
                return new zzul((zzuk) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
