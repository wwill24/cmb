package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxj  reason: invalid package */
public final class zzxj extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzxj zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzxm zzf;

    static {
        zzxj zzxj = new zzxj();
        zzb = zzxj;
        zzakk.zzH(zzxj.class, zzxj);
    }

    private zzxj() {
    }

    public static zzxi zzb() {
        return (zzxi) zzb.zzt();
    }

    public static zzxj zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzxj) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzg(zzxj zzxj, zzxm zzxm) {
        zzxm.getClass();
        zzxj.zzf = zzxm;
        zzxj.zzd |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzxm zze() {
        zzxm zzxm = this.zzf;
        return zzxm == null ? zzxm.zzd() : zzxm;
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
            return new zzxj();
        } else {
            if (i11 == 4) {
                return new zzxi((zzxh) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
