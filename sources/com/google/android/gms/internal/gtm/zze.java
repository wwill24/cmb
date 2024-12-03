package com.google.android.gms.internal.gtm;

public final class zze extends zzuz<zze, zzd> implements zzwl {
    public static final zzux<zzak, zze> zza;
    /* access modifiers changed from: private */
    public static final zze zze;
    private int zzf;
    private zzm zzg;
    private zzg zzh;
    private byte zzi = 2;

    static {
        zze zze2 = new zze();
        zze = zze2;
        zzuz.zzak(zze.class, zze2);
        zza = zzuz.zzaa(zzak.zzi(), zze2, zze2, (zzvc) null, 47497405, zzye.MESSAGE, zze.class);
    }

    private zze() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzuz.zzaj(zze, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0002\u0001ᐉ\u0000\u0003ᐉ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zze();
        } else {
            if (i11 == 4) {
                return new zzd((zzc) null);
            }
            if (i11 == 5) {
                return zze;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzi = b10;
            return null;
        }
    }
}
