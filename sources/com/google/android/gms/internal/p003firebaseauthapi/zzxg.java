package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxg  reason: invalid package */
public final class zzxg extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzxg zzb;
    private String zzd = "";

    static {
        zzxg zzxg = new zzxg();
        zzb = zzxg;
        zzakk.zzH(zzxg.class, zzxg);
    }

    private zzxg() {
    }

    public static zzxf zza() {
        return (zzxf) zzb.zzt();
    }

    public static zzxg zzc() {
        return zzb;
    }

    public static zzxg zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzxg) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzf(zzxg zzxg, String str) {
        str.getClass();
        zzxg.zzd = str;
    }

    public final String zze() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        } else if (i11 == 3) {
            return new zzxg();
        } else {
            if (i11 == 4) {
                return new zzxf((zzxe) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
