package com.google.android.gms.internal.play_billing;

public final class zzff extends zzcb implements zzdg {
    /* access modifiers changed from: private */
    public static final zzff zzb;
    private int zzd;
    private int zze;

    static {
        zzff zzff = new zzff();
        zzb = zzff;
        zzcb.zzo(zzff.class, zzff);
    }

    private zzff() {
    }

    public static zzfe zzu() {
        return (zzfe) zzb.zze();
    }

    static /* synthetic */ void zzw(zzff zzff, int i10) {
        zzff.zze = i10 - 1;
        zzff.zzd |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object zzt(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcb.zzl(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzd", "zze", zzfc.zza});
        } else if (i11 == 3) {
            return new zzff();
        } else {
            if (i11 == 4) {
                return new zzfe((zzfd) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
