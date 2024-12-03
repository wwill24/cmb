package com.google.android.gms.internal.measurement;

public final class zzgg extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgg zza;
    private int zzd;
    private int zze = 1;
    private zzli zzf = zzlb.zzbH();

    static {
        zzgg zzgg = new zzgg();
        zza = zzgg;
        zzlb.zzbO(zzgg.class, zzgg);
    }

    private zzgg() {
    }

    public static zzge zza() {
        return (zzge) zza.zzbA();
    }

    static /* synthetic */ void zzc(zzgg zzgg, zzfv zzfv) {
        zzfv.getClass();
        zzli zzli = zzgg.zzf;
        if (!zzli.zzc()) {
            zzgg.zzf = zzlb.zzbI(zzli);
        }
        zzgg.zzf.add(zzfv);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzd", "zze", zzgf.zza, "zzf", zzfv.class});
        } else if (i11 == 3) {
            return new zzgg();
        } else {
            if (i11 == 4) {
                return new zzge((zzfk) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
