package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgb extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgb zza;
    private zzli zzd = zzlb.zzbH();

    static {
        zzgb zzgb = new zzgb();
        zza = zzgb;
        zzlb.zzbO(zzgb.class, zzgb);
    }

    private zzgb() {
    }

    public static zzga zza() {
        return (zzga) zza.zzbA();
    }

    static /* synthetic */ void zze(zzgb zzgb, zzgd zzgd) {
        zzgd.getClass();
        zzli zzli = zzgb.zzd;
        if (!zzli.zzc()) {
            zzgb.zzd = zzlb.zzbI(zzli);
        }
        zzgb.zzd.add(zzgd);
    }

    public final zzgd zzc(int i10) {
        return (zzgd) this.zzd.get(0);
    }

    public final List zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgd.class});
        } else if (i11 == 3) {
            return new zzgb();
        } else {
            if (i11 == 4) {
                return new zzga((zzfk) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
