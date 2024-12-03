package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzsi  reason: invalid package */
public final class zzsi extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzsi zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public int zze;
    private zzso zzf;
    private zzvf zzg;

    static {
        zzsi zzsi = new zzsi();
        zzb = zzsi;
        zzakk.zzH(zzsi.class, zzsi);
    }

    private zzsi() {
    }

    public static zzsh zzb() {
        return (zzsh) zzb.zzt();
    }

    public static zzsi zzd(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzsi) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzh(zzsi zzsi, zzso zzso) {
        zzso.getClass();
        zzsi.zzf = zzso;
        zzsi.zzd |= 1;
    }

    static /* synthetic */ void zzi(zzsi zzsi, zzvf zzvf) {
        zzvf.getClass();
        zzsi.zzg = zzvf;
        zzsi.zzd |= 2;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzso zze() {
        zzso zzso = this.zzf;
        return zzso == null ? zzso.zzd() : zzso;
    }

    public final zzvf zzf() {
        zzvf zzvf = this.zzg;
        return zzvf == null ? zzvf.zzd() : zzvf;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzsi();
        } else {
            if (i11 == 4) {
                return new zzsh((zzsg) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
