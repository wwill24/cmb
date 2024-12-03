package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvu  reason: invalid package */
public final class zzvu extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzvu zzb;
    private int zzd;
    private zzvx zze;

    static {
        zzvu zzvu = new zzvu();
        zzb = zzvu;
        zzakk.zzH(zzvu.class, zzvu);
    }

    private zzvu() {
    }

    public static zzvt zza() {
        return (zzvt) zzb.zzt();
    }

    public static zzvu zzc(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzvu) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zze(zzvu zzvu, zzvx zzvx) {
        zzvx.getClass();
        zzvu.zze = zzvx;
        zzvu.zzd |= 1;
    }

    public final zzvx zzd() {
        zzvx zzvx = this.zze;
        return zzvx == null ? zzvx.zzf() : zzvx;
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
            return new zzvu();
        } else {
            if (i11 == 4) {
                return new zzvt((zzvs) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
