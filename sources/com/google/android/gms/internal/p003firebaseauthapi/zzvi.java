package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvi  reason: invalid package */
public final class zzvi extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzvi zzb;
    private int zzd;
    private zzvl zze;
    /* access modifiers changed from: private */
    public int zzf;
    private int zzg;

    static {
        zzvi zzvi = new zzvi();
        zzb = zzvi;
        zzakk.zzH(zzvi.class, zzvi);
    }

    private zzvi() {
    }

    public static zzvh zzc() {
        return (zzvh) zzb.zzt();
    }

    public static zzvi zze() {
        return zzb;
    }

    public static zzvi zzf(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzvi) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzh(zzvi zzvi, zzvl zzvl) {
        zzvl.getClass();
        zzvi.zze = zzvl;
        zzvi.zzd |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final zzvl zzg() {
        zzvl zzvl = this.zze;
        return zzvl == null ? zzvl.zze() : zzvl;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzvi();
        } else {
            if (i11 == 4) {
                return new zzvh((zzvg) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
