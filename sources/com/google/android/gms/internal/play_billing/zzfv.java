package com.google.android.gms.internal.play_billing;

public final class zzfv extends zzcb implements zzdg {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final zzfv zzd;

    static {
        zzfv zzfv = new zzfv();
        zzd = zzfv;
        zzcb.zzo(zzfv.class, zzfv);
    }

    private zzfv() {
    }

    /* access modifiers changed from: protected */
    public final Object zzt(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcb.zzl(zzd, "\u0001\u0000", (Object[]) null);
        }
        if (i11 == 3) {
            return new zzfv();
        }
        if (i11 == 4) {
            return new zzfu((zzft) null);
        }
        if (i11 != 5) {
            return null;
        }
        return zzd;
    }
}
