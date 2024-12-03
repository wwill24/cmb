package com.google.android.gms.internal.gtm;

import java.util.List;

public final class zzw extends zzuz<zzw, zzv> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzw zza;
    private zzvh<zzak> zze = zzuz.zzag();
    private zzvh<zzak> zzf = zzuz.zzag();
    private zzvh<zzu> zzg = zzuz.zzag();
    private byte zzh = 2;

    static {
        zzw zzw = new zzw();
        zza = zzw;
        zzuz.zzak(zzw.class, zzw);
    }

    private zzw() {
    }

    public static zzw zzc() {
        return zza;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        Class<zzak> cls = zzak.class;
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzh);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzuz.zzaj(zza, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0002\u0001Л\u0002Л\u0003\u001b", new Object[]{"zze", cls, "zzf", cls, "zzg", zzu.class});
        } else if (i11 == 3) {
            return new zzw();
        } else {
            if (i11 == 4) {
                return new zzv((zzn) null);
            }
            if (i11 == 5) {
                return zza;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzh = b10;
            return null;
        }
    }

    public final List<zzu> zzd() {
        return this.zzg;
    }

    public final List<zzak> zze() {
        return this.zzf;
    }

    public final List<zzak> zzf() {
        return this.zze;
    }
}
