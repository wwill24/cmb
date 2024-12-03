package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvf  reason: invalid package */
public final class zzvf extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzvf zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzvl zzf;
    /* access modifiers changed from: private */
    public zzajf zzg = zzajf.zzb;

    static {
        zzvf zzvf = new zzvf();
        zzb = zzvf;
        zzakk.zzH(zzvf.class, zzvf);
    }

    private zzvf() {
    }

    public static zzve zzb() {
        return (zzve) zzb.zzt();
    }

    public static zzvf zzd() {
        return zzb;
    }

    public static zzvf zze(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzvf) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzi(zzvf zzvf, zzvl zzvl) {
        zzvl.getClass();
        zzvf.zzf = zzvl;
        zzvf.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzvl zzf() {
        zzvl zzvl = this.zzf;
        return zzvl == null ? zzvl.zze() : zzvl;
    }

    public final zzajf zzg() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzvf();
        } else {
            if (i11 == 4) {
                return new zzve((zzvd) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
