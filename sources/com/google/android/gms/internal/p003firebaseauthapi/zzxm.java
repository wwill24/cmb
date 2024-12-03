package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxm  reason: invalid package */
public final class zzxm extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzxm zzb;
    private int zzd;
    private String zze = "";
    private zzwn zzf;

    static {
        zzxm zzxm = new zzxm();
        zzb = zzxm;
        zzakk.zzH(zzxm.class, zzxm);
    }

    private zzxm() {
    }

    public static zzxl zzb() {
        return (zzxl) zzb.zzt();
    }

    public static zzxm zzd() {
        return zzb;
    }

    public static zzxm zze(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zzxm) zzakk.zzx(zzb, zzajf, zzajx);
    }

    static /* synthetic */ void zzg(zzxm zzxm, String str) {
        str.getClass();
        zzxm.zze = str;
    }

    static /* synthetic */ void zzh(zzxm zzxm, zzwn zzwn) {
        zzwn.getClass();
        zzxm.zzf = zzwn;
        zzxm.zzd |= 1;
    }

    public final zzwn zza() {
        zzwn zzwn = this.zzf;
        return zzwn == null ? zzwn.zzc() : zzwn;
    }

    public final String zzf() {
        return this.zze;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzxm();
        } else {
            if (i11 == 4) {
                return new zzxl((zzxk) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
