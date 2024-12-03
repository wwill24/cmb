package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzus  reason: invalid package */
public final class zzus extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzus zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzum zzf;
    /* access modifiers changed from: private */
    public zzajf zzg;
    /* access modifiers changed from: private */
    public zzajf zzh;

    static {
        zzus zzus = new zzus();
        zzb = zzus;
        zzakk.zzH(zzus.class, zzus);
    }

    private zzus() {
        zzajf zzajf = zzajf.zzb;
        this.zzg = zzajf;
        this.zzh = zzajf;
    }

    public static zzur zzc() {
        return (zzur) zzb.zzt();
    }

    public static zzus zze() {
        return zzb;
    }

    public static zzus zzf(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzus) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzk(zzus zzus, zzum zzum) {
        zzum.getClass();
        zzus.zzf = zzum;
        zzus.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzum zzb() {
        zzum zzum = this.zzf;
        return zzum == null ? zzum.zze() : zzum;
    }

    public final zzajf zzg() {
        return this.zzg;
    }

    public final zzajf zzh() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zzus();
        } else {
            if (i11 == 4) {
                return new zzur((zzuq) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
