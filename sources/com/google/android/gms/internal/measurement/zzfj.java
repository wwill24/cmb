package com.google.android.gms.internal.measurement;

public final class zzfj extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfj zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzfj zzfj = new zzfj();
        zza = zzfj;
        zzlb.zzbO(zzfj.class, zzfj);
    }

    private zzfj() {
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i11 == 3) {
            return new zzfj();
        } else {
            if (i11 == 4) {
                return new zzfi((zzez) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zza;
        }
    }
}
