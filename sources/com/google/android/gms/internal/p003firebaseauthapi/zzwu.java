package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwu  reason: invalid package */
public final class zzwu extends zzakk implements zzalq {
    /* access modifiers changed from: private */
    public static final zzwu zzb;
    private int zzd;
    private zzwi zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;
    /* access modifiers changed from: private */
    public int zzh;

    static {
        zzwu zzwu = new zzwu();
        zzb = zzwu;
        zzakk.zzH(zzwu.class, zzwu);
    }

    private zzwu() {
    }

    public static zzwt zzc() {
        return (zzwt) zzb.zzt();
    }

    static /* synthetic */ void zzf(zzwu zzwu, zzwi zzwi) {
        zzwi.getClass();
        zzwu.zze = zzwi;
        zzwu.zzd |= 1;
    }

    public final int zza() {
        return this.zzg;
    }

    public final zzwi zzb() {
        zzwi zzwi = this.zze;
        return zzwi == null ? zzwi.zzd() : zzwi;
    }

    public final zzxo zze() {
        zzxo zzb2 = zzxo.zzb(this.zzh);
        return zzb2 == null ? zzxo.UNRECOGNIZED : zzb2;
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
            return zzakk.zzE(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zzwu();
        } else {
            if (i11 == 4) {
                return new zzwt((zzwr) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final int zzk() {
        int i10 = this.zzf;
        int i11 = 3;
        if (i10 == 0) {
            i11 = 2;
        } else if (i10 != 1) {
            i11 = i10 != 2 ? i10 != 3 ? 0 : 5 : 4;
        }
        if (i11 == 0) {
            return 1;
        }
        return i11;
    }
}
