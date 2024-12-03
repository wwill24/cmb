package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzta  reason: invalid package */
public final class zzta extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzta zzb;
    private int zzd;
    private zztd zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzta zzta = new zzta();
        zzb = zzta;
        zzakk.zzH(zzta.class, zzta);
    }

    private zzta() {
    }

    public static zzsz zzb() {
        return (zzsz) zzb.zzt();
    }

    public static zzta zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzta) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzf(zzta zzta, zztd zztd) {
        zztd.getClass();
        zzta.zze = zztd;
        zzta.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zztd zze() {
        zztd zztd = this.zze;
        return zztd == null ? zztd.zzd() : zztd;
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
            return new zzta();
        } else {
            if (i11 == 4) {
                return new zzsz((zzsy) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
