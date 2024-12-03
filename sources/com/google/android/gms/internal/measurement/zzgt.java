package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgt extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgt zza;
    private int zzd;
    private zzli zze = zzlb.zzbH();
    private zzgp zzf;

    static {
        zzgt zzgt = new zzgt();
        zza = zzgt;
        zzlb.zzbO(zzgt.class, zzgt);
    }

    private zzgt() {
    }

    public final zzgp zza() {
        zzgp zzgp = this.zzf;
        return zzgp == null ? zzgp.zzc() : zzgp;
    }

    public final List zzc() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", zzgy.class, "zzf"});
        } else if (i11 == 3) {
            return new zzgt();
        } else {
            if (i11 == 4) {
                return new zzgs((zzgn) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
