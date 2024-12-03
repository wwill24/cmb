package com.google.android.gms.internal.play_billing;

public final class zzfb extends zzcb implements zzdg {
    /* access modifiers changed from: private */
    public static final zzfb zzb;
    private int zzd;
    private int zze;
    private zzfj zzf;
    private zzfs zzg;

    static {
        zzfb zzfb = new zzfb();
        zzb = zzfb;
        zzcb.zzo(zzfb.class, zzfb);
    }

    private zzfb() {
    }

    public static zzfa zzu() {
        return (zzfa) zzb.zze();
    }

    public static zzfb zzw(byte[] bArr, zzbn zzbn) throws zzci {
        return (zzfb) zzcb.zzi(zzb, bArr, zzbn);
    }

    static /* synthetic */ void zzx(zzfb zzfb, zzfj zzfj) {
        zzfj.getClass();
        zzfb.zzf = zzfj;
        zzfb.zzd |= 2;
    }

    static /* synthetic */ void zzy(zzfb zzfb, int i10) {
        zzfb.zze = i10 - 1;
        zzfb.zzd |= 1;
    }

    /* access modifiers changed from: protected */
    public final Object zzt(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzcb.zzl(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzfc.zza, "zzf", "zzg"});
        } else if (i11 == 3) {
            return new zzfb();
        } else {
            if (i11 == 4) {
                return new zzfa((zzez) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
