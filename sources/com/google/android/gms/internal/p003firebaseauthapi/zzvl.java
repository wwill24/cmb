package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvl  reason: invalid package */
public final class zzvl extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzvl zzb;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzvl zzvl = new zzvl();
        zzb = zzvl;
        zzakk.zzH(zzvl.class, zzvl);
    }

    private zzvl() {
    }

    public static zzvk zzc() {
        return (zzvk) zzb.zzt();
    }

    public static zzvl zze() {
        return zzb;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzvc zzb() {
        zzvc zzb2 = zzvc.zzb(this.zzd);
        return zzb2 == null ? zzvc.UNRECOGNIZED : zzb2;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zzvl();
        } else {
            if (i11 == 4) {
                return new zzvk((zzvj) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
