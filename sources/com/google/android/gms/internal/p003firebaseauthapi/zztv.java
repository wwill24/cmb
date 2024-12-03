package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztv  reason: invalid package */
public final class zztv extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zztv zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zztv zztv = new zztv();
        zzb = zztv;
        zzakk.zzH(zztv.class, zztv);
    }

    private zztv() {
    }

    public static zztu zzc() {
        return (zztu) zzb.zzt();
    }

    public static zztv zze(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zztv) zzakk.zzx(zzb, zzajf, zzajx);
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
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zztv();
        } else {
            if (i11 == 4) {
                return new zztu((zztt) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
