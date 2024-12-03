package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsu  reason: invalid package */
public final class zzsu extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzsu zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzsu zzsu = new zzsu();
        zzb = zzsu;
        zzakk.zzH(zzsu.class, zzsu);
    }

    private zzsu() {
    }

    public static zzst zzb() {
        return (zzst) zzb.zzt();
    }

    public static zzsu zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        } else if (i11 == 3) {
            return new zzsu();
        } else {
            if (i11 == 4) {
                return new zzst((zzss) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
