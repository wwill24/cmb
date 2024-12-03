package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxa  reason: invalid package */
public final class zzxa extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzxa zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzakp zze = zzakk.zzA();

    static {
        zzxa zzxa = new zzxa();
        zzb = zzxa;
        zzakk.zzH(zzxa.class, zzxa);
    }

    private zzxa() {
    }

    public static zzwx zza() {
        return (zzwx) zzb.zzt();
    }

    static /* synthetic */ void zze(zzxa zzxa, zzwz zzwz) {
        zzwz.getClass();
        zzakp zzakp = zzxa.zze;
        if (!zzakp.zzc()) {
            zzxa.zze = zzakk.zzB(zzakp);
        }
        zzxa.zze.add(zzwz);
    }

    public final zzwz zzb(int i10) {
        return (zzwz) this.zze.get(0);
    }

    /* access modifiers changed from: protected */
    public final Object zzj(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzakk.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzwz.class});
        } else if (i11 == 3) {
            return new zzxa();
        } else {
            if (i11 == 4) {
                return new zzwx((zzww) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
