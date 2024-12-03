package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztd  reason: invalid package */
public final class zztd extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zztd zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zztd zztd = new zztd();
        zzb = zztd;
        zzakk.zzH(zztd.class, zztd);
    }

    private zztd() {
    }

    public static zztc zzb() {
        return (zztc) zzb.zzt();
    }

    public static zztd zzd() {
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
            return new zztd();
        } else {
            if (i11 == 4) {
                return new zztc((zztb) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
