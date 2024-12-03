package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztp  reason: invalid package */
public final class zztp extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zztp zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private int zze;

    static {
        zztp zztp = new zztp();
        zzb = zztp;
        zzakk.zzH(zztp.class, zztp);
    }

    private zztp() {
    }

    public static zzto zzc() {
        return (zzto) zzb.zzt();
    }

    public static zztp zze(zzajf zzajf, zzajx zzajx) throws zzaks {
        return (zztp) zzakk.zzx(zzb, zzajf, zzajx);
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        } else if (i11 == 3) {
            return new zztp();
        } else {
            if (i11 == 4) {
                return new zzto((zztn) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
