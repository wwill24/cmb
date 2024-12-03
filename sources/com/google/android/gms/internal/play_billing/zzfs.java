package com.google.android.gms.internal.play_billing;

public final class zzfs extends zzcb implements zzdg {
    /* access modifiers changed from: private */
    public static final zzfs zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzfs zzfs = new zzfs();
        zzb = zzfs;
        zzcb.zzo(zzfs.class, zzfs);
    }

    private zzfs() {
    }

    /* access modifiers changed from: protected */
    public final Object zzt(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcb.zzl(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzfo.zza, "zzf"});
        } else if (i11 == 3) {
            return new zzfs();
        } else {
            if (i11 == 4) {
                return new zzfr((zzfq) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
