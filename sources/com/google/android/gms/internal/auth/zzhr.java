package com.google.android.gms.internal.auth;

import java.util.List;

public final class zzhr extends zzeu implements zzfx {
    /* access modifiers changed from: private */
    public static final zzhr zzb;
    private zzey zzd = zzeu.zzc();

    static {
        zzhr zzhr = new zzhr();
        zzb = zzhr;
        zzeu.zzg(zzhr.class, zzhr);
    }

    private zzhr() {
    }

    public static zzhr zzk(byte[] bArr) throws zzfa {
        return (zzhr) zzeu.zzb(zzb, bArr);
    }

    /* access modifiers changed from: protected */
    public final Object zzi(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzeu.zzf(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzd"});
        } else if (i11 == 3) {
            return new zzhr();
        } else {
            if (i11 == 4) {
                return new zzhq((zzhp) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzl() {
        return this.zzd;
    }
}
