package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwn  reason: invalid package */
public final class zzwn extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzwn zzb;
    private String zzd = "";
    private zzajf zze = zzajf.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzwn zzwn = new zzwn();
        zzb = zzwn;
        zzakk.zzH(zzwn.class, zzwn);
    }

    private zzwn() {
    }

    public static zzwm zza() {
        return (zzwm) zzb.zzt();
    }

    public static zzwn zzc() {
        return zzb;
    }

    public static zzwn zzd(byte[] bArr, zzajx zzajx) throws zzaks {
        return (zzwn) zzakk.zzz(zzb, bArr, zzajx);
    }

    static /* synthetic */ void zzh(zzwn zzwn, String str) {
        str.getClass();
        zzwn.zzd = str;
    }

    static /* synthetic */ void zzi(zzwn zzwn, zzajf zzajf) {
        zzajf.getClass();
        zzwn.zze = zzajf;
    }

    public final zzxo zze() {
        zzxo zzb2 = zzxo.zzb(this.zzf);
        return zzb2 == null ? zzxo.UNRECOGNIZED : zzb2;
    }

    public final zzajf zzf() {
        return this.zze;
    }

    public final String zzg() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzwn();
        } else {
            if (i11 == 4) {
                return new zzwm((zzwl) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
