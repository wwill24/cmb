package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztm  reason: invalid package */
public final class zztm extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zztm zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzajf zze = zzajf.zzb;

    static {
        zztm zztm = new zztm();
        zzb = zztm;
        zzakk.zzH(zztm.class, zztm);
    }

    private zztm() {
    }

    public static zztl zzb() {
        return (zztl) zzb.zzt();
    }

    public static zztm zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zztm) zzakk.zzx(zzb, zzajf, zzajx);
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
            return new zztm();
        } else {
            if (i11 == 4) {
                return new zztl((zztk) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
