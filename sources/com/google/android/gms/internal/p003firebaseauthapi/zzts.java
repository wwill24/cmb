package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzts  reason: invalid package */
public final class zzts extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzts zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzajf zze = zzajf.zzb;

    static {
        zzts zzts = new zzts();
        zzb = zzts;
        zzakk.zzH(zzts.class, zzts);
    }

    private zzts() {
    }

    public static zztr zzb() {
        return (zztr) zzb.zzt();
    }

    public static zzts zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzts) zzakk.zzx(zzb, zzajf, zzajx);
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
            return new zzts();
        } else {
            if (i11 == 4) {
                return new zztr((zztq) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
