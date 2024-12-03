package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxu  reason: invalid package */
public final class zzxu extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzxu zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzajf zze = zzajf.zzb;

    static {
        zzxu zzxu = new zzxu();
        zzb = zzxu;
        zzakk.zzH(zzxu.class, zzxu);
    }

    private zzxu() {
    }

    public static zzxt zzb() {
        return (zzxt) zzb.zzt();
    }

    public static zzxu zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzxu) zzakk.zzx(zzb, zzajf, zzajx);
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
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zzxu();
        } else {
            if (i11 == 4) {
                return new zzxt((zzxs) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
