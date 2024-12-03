package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzty  reason: invalid package */
public final class zzty extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzty zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzajf zze = zzajf.zzb;

    static {
        zzty zzty = new zzty();
        zzb = zzty;
        zzakk.zzH(zzty.class, zzty);
    }

    private zzty() {
    }

    public static zztx zzb() {
        return (zztx) zzb.zzt();
    }

    public static zzty zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzty) zzakk.zzx(zzb, zzajf, zzajx);
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzajf zze() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zzty();
        } else {
            if (i11 == 4) {
                return new zztx((zztw) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
