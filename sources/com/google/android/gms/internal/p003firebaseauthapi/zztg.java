package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztg  reason: invalid package */
public final class zztg extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zztg zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public zzajf zze = zzajf.zzb;

    static {
        zztg zztg = new zztg();
        zzb = zztg;
        zzakk.zzH(zztg.class, zztg);
    }

    private zztg() {
    }

    public static zztf zzb() {
        return (zztf) zzb.zzt();
    }

    public static zztg zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zztg) zzakk.zzx(zzb, zzajf, zzajx);
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
            return new zztg();
        } else {
            if (i11 == 4) {
                return new zztf((zzte) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
