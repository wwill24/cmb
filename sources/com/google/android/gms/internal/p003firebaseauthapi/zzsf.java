package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsf  reason: invalid package */
public final class zzsf extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzsf zzb;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzsf zzsf = new zzsf();
        zzb = zzsf;
        zzakk.zzH(zzsf.class, zzsf);
    }

    private zzsf() {
    }

    public static zzse zzb() {
        return (zzse) zzb.zzt();
    }

    public static zzsf zzd() {
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
            return new zzsf();
        } else {
            if (i11 == 4) {
                return new zzse((zzsd) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
