package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamt  reason: invalid package */
public final class zzamt extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzamt zzb;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzamt zzamt = new zzamt();
        zzb = zzamt;
        zzakk.zzH(zzamt.class, zzamt);
    }

    private zzamt() {
    }

    public static zzams zzc() {
        return (zzams) zzb.zzt();
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new zzalz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        } else if (i11 == 3) {
            return new zzamt();
        } else {
            if (i11 == 4) {
                return new zzams((zzamr) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
