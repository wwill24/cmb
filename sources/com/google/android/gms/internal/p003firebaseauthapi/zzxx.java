package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxx  reason: invalid package */
public final class zzxx extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzxx zzb;
    private int zzd;

    static {
        zzxx zzxx = new zzxx();
        zzb = zzxx;
        zzakk.zzH(zzxx.class, zzxx);
    }

    private zzxx() {
    }

    public static zzxx zzc() {
        return zzb;
    }

    public static zzxx zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzxx) zzakk.zzx(zzb, zzajf, zzajx);
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
            return new zzxx();
        } else {
            if (i11 == 4) {
                return new zzxw((zzxv) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
