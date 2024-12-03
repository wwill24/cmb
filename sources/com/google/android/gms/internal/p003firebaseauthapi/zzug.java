package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzug  reason: invalid package */
public final class zzug extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzug zzb;
    private int zzd;
    private zzwn zze;

    static {
        zzug zzug = new zzug();
        zzb = zzug;
        zzakk.zzH(zzug.class, zzug);
    }

    private zzug() {
    }

    public static zzuf zza() {
        return (zzuf) zzb.zzt();
    }

    public static zzug zzc() {
        return zzb;
    }

    static /* synthetic */ void zze(zzug zzug, zzwn zzwn) {
        zzwn.getClass();
        zzug.zze = zzwn;
        zzug.zzd |= 1;
    }

    public final zzwn zzd() {
        zzwn zzwn = this.zze;
        return zzwn == null ? zzwn.zzc() : zzwn;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zzug();
        } else {
            if (i11 == 4) {
                return new zzuf((zzue) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
