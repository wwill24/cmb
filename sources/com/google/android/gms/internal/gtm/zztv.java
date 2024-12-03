package com.google.android.gms.internal.gtm;

public final class zztv extends zzuz<zztv, zztu> implements zzwl {
    /* access modifiers changed from: private */
    public static final zztv zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zztv zztv = new zztv();
        zza = zztv;
        zzuz.zzak(zztv.class, zztv);
    }

    private zztv() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new zzwv(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zztv();
        } else {
            if (i11 == 4) {
                return new zztu((zztq) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
