package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsc  reason: invalid package */
public final class zzsc extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzsc zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzsf zzf;

    static {
        zzsc zzsc = new zzsc();
        zzb = zzsc;
        zzakk.zzH(zzsc.class, zzsc);
    }

    private zzsc() {
    }

    public static zzsb zzb() {
        return (zzsb) zzb.zzt();
    }

    public static zzsc zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzsc) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzg(zzsc zzsc, zzsf zzsf) {
        zzsf.getClass();
        zzsc.zzf = zzsf;
        zzsc.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzsf zze() {
        zzsf zzsf = this.zzf;
        return zzsf == null ? zzsf.zzd() : zzsf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzsc();
        } else {
            if (i11 == 4) {
                return new zzsb((zzsa) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
