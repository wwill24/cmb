package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuj  reason: invalid package */
public final class zzuj extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzuj zzb;
    private int zzd;
    private zzum zze;

    static {
        zzuj zzuj = new zzuj();
        zzb = zzuj;
        zzakk.zzH(zzuj.class, zzuj);
    }

    private zzuj() {
    }

    public static zzui zza() {
        return (zzui) zzb.zzt();
    }

    public static zzuj zzc(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzuj) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zze(zzuj zzuj, zzum zzum) {
        zzum.getClass();
        zzuj.zze = zzum;
        zzuj.zzd |= 1;
    }

    public final zzum zzd() {
        zzum zzum = this.zze;
        return zzum == null ? zzum.zze() : zzum;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zzuj();
        } else {
            if (i11 == 4) {
                return new zzui((zzuh) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
