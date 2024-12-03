package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwd  reason: invalid package */
public final class zzwd extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzwd zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzvx zzf;
    /* access modifiers changed from: private */
    public zzajf zzg = zzajf.zzb;

    static {
        zzwd zzwd = new zzwd();
        zzb = zzwd;
        zzakk.zzH(zzwd.class, zzwd);
    }

    private zzwd() {
    }

    public static zzwc zzc() {
        return (zzwc) zzb.zzt();
    }

    public static zzwd zze() {
        return zzb;
    }

    public static zzwd zzf(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzwd) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzi(zzwd zzwd, zzvx zzvx) {
        zzvx.getClass();
        zzwd.zzf = zzvx;
        zzwd.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzvx zzb() {
        zzvx zzvx = this.zzf;
        return zzvx == null ? zzvx.zzf() : zzvx;
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
            return new zzwd();
        } else {
            if (i11 == 4) {
                return new zzwc((zzwb) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zzl() {
        return (this.zzd & 1) != 0;
    }
}
