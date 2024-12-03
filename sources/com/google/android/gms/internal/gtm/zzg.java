package com.google.android.gms.internal.gtm;

public final class zzg extends zzuz<zzg, zzf> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzg zza;
    private int zze;
    private zzvh<zzi> zzf = zzuz.zzag();
    private zzak zzg;
    private String zzh = "";
    private byte zzi = 2;

    static {
        zzg zzg2 = new zzg();
        zza = zzg2;
        zzuz.zzak(zzg.class, zzg2);
    }

    private zzg() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzuz.zzaj(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000\u0003ဈ\u0001", new Object[]{"zze", "zzf", zzi.class, "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zzg();
        } else {
            if (i11 == 4) {
                return new zzf((zzc) null);
            }
            if (i11 == 5) {
                return zza;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzi = b10;
            return null;
        }
    }
}
