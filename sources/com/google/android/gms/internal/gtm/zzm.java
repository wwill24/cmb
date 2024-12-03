package com.google.android.gms.internal.gtm;

public final class zzm extends zzuz<zzm, zzl> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzm zza;
    private zzvh<zzk> zze = zzuz.zzag();
    private zzvh<zzg> zzf = zzuz.zzag();
    private byte zzg = 2;

    static {
        zzm zzm = new zzm();
        zza = zzm;
        zzuz.zzak(zzm.class, zzm);
    }

    private zzm() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzuz.zzaj(zza, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0001Л\u0002Л", new Object[]{"zze", zzk.class, "zzf", zzg.class});
        } else if (i11 == 3) {
            return new zzm();
        } else {
            if (i11 == 4) {
                return new zzl((zzc) null);
            }
            if (i11 == 5) {
                return zza;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzg = b10;
            return null;
        }
    }
}
