package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwi  reason: invalid package */
public final class zzwi extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzwi zzb;
    private String zzd = "";
    private zzajf zze = zzajf.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzwi zzwi = new zzwi();
        zzb = zzwi;
        zzakk.zzH(zzwi.class, zzwi);
    }

    private zzwi() {
    }

    public static zzwf zza() {
        return (zzwf) zzb.zzt();
    }

    public static zzwi zzd() {
        return zzb;
    }

    static /* synthetic */ void zzg(zzwi zzwi, String str) {
        str.getClass();
        zzwi.zzd = str;
    }

    static /* synthetic */ void zzh(zzwi zzwi, zzajf zzajf) {
        zzajf.getClass();
        zzwi.zze = zzajf;
    }

    public final zzwh zzb() {
        int i10 = this.zzf;
        zzwh zzwh = zzwh.UNKNOWN_KEYMATERIAL;
        zzwh zzwh2 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? null : zzwh.REMOTE : zzwh.ASYMMETRIC_PUBLIC : zzwh.ASYMMETRIC_PRIVATE : zzwh.SYMMETRIC : zzwh.UNKNOWN_KEYMATERIAL;
        return zzwh2 == null ? zzwh.UNRECOGNIZED : zzwh2;
    }

    public final zzajf zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzwi();
        } else {
            if (i11 == 4) {
                return new zzwf((zzwe) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
