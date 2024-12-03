package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzub  reason: invalid package */
public final class zzub extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzub zzb;

    static {
        zzub zzub = new zzub();
        zzb = zzub;
        zzakk.zzH(zzub.class, zzub);
    }

    private zzub() {
    }

    public static zzub zzb() {
        return zzb;
    }

    public static zzub zzc(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzub) zzakk.zzx(zzb, zzajf, zzajx);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0000", (Object[]) null);
        }
        if (i11 == 3) {
            return new zzub();
        }
        if (i11 == 4) {
            return new zzua((zztz) null);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
