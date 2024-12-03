package com.google.android.gms.internal.gtm;

public final class zzub extends zzuv<zzub, zzua> {
    /* access modifiers changed from: private */
    public static final zzub zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk = "";
    private zzvh<zzuf> zzl = zzwu.zze();
    private byte zzm = 2;

    static {
        zzub zzub = new zzub();
        zze = zzub;
        zzuz.zzak(zzub.class, zzub);
    }

    private zzub() {
    }

    public static zzub zze() {
        return zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzm);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return new zzwv(zze, "\u0001\u0006\u0000\u0001\u0001ϧ\u0006\u0000\u0001\u0001\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\nဈ\u0004ϧЛ", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzuf.class});
        } else if (i11 == 3) {
            return new zzub();
        } else {
            if (i11 == 4) {
                return new zzua((zztq) null);
            }
            if (i11 == 5) {
                return zze;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzm = b10;
            return null;
        }
    }
}
