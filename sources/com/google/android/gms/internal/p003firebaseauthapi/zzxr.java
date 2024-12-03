package com.google.android.gms.internal.p003firebaseauthapi;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxr  reason: invalid package */
public final class zzxr extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzxr zzb;
    private String zzd = "";
    private zzakp zze = zzakk.zzA();

    static {
        zzxr zzxr = new zzxr();
        zzb = zzxr;
        zzakk.zzH(zzxr.class, zzxr);
    }

    private zzxr() {
    }

    public static zzxr zzb() {
        return zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzwq.class});
        } else if (i11 == 3) {
            return new zzxr();
        } else {
            if (i11 == 4) {
                return new zzxq((zzxp) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
