package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgp extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgp zza;
    private zzli zzd = zzlb.zzbH();

    static {
        zzgp zzgp = new zzgp();
        zza = zzgp;
        zzlb.zzbO(zzgp.class, zzgp);
    }

    private zzgp() {
    }

    public static zzgp zzc() {
        return zza;
    }

    public final int zza() {
        return this.zzd.size();
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
            return zzlb.zzbL(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgr.class});
        } else if (i11 == 3) {
            return new zzgp();
        } else {
            if (i11 == 4) {
                return new zzgo((zzgn) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
