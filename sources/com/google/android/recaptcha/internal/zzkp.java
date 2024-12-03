package com.google.android.recaptcha.internal;

public final class zzkp extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzkp zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzkp zzkp = new zzkp();
        zzb = zzkp;
        zzgo.zzC(zzkp.class, zzkp);
    }

    private zzkp() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i11 == 3) {
            return new zzkp();
        } else {
            if (i11 == 4) {
                return new zzko((zzkn) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
