package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsl  reason: invalid package */
public final class zzsl extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzsl zzb;
    private int zzd;
    private zzsr zze;
    private zzvi zzf;

    static {
        zzsl zzsl = new zzsl();
        zzb = zzsl;
        zzakk.zzH(zzsl.class, zzsl);
    }

    private zzsl() {
    }

    public static zzsk zza() {
        return (zzsk) zzb.zzt();
    }

    public static zzsl zzc(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzsl) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzf(zzsl zzsl, zzsr zzsr) {
        zzsr.getClass();
        zzsl.zze = zzsr;
        zzsl.zzd |= 1;
    }

    static /* synthetic */ void zzg(zzsl zzsl, zzvi zzvi) {
        zzvi.getClass();
        zzsl.zzf = zzvi;
        zzsl.zzd |= 2;
    }

    public final zzsr zzd() {
        zzsr zzsr = this.zze;
        return zzsr == null ? zzsr.zzd() : zzsr;
    }

    public final zzvi zze() {
        zzvi zzvi = this.zzf;
        return zzvi == null ? zzvi.zze() : zzvi;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzsl();
        } else {
            if (i11 == 4) {
                return new zzsk((zzsj) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
