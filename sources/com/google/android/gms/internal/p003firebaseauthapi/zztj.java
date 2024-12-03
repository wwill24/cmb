package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztj  reason: invalid package */
public final class zztj extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zztj zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zztj zztj = new zztj();
        zzb = zztj;
        zzakk.zzH(zztj.class, zztj);
    }

    private zztj() {
    }

    public static zzti zzc() {
        return (zzti) zzb.zzt();
    }

    public static zztj zze(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zztj) zzakk.zzx(zzb, zzajf, zzajx);
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zztj();
        } else {
            if (i11 == 4) {
                return new zzti((zzth) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
