package com.google.android.gms.internal.gtm;

public final class zzuf extends zzuz<zzuf, zzuc> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzuf zza;
    private int zze;
    private zzvh<zzue> zzf = zzwu.zze();
    private String zzg = "";
    private long zzh;
    private long zzi;
    private double zzj;
    private zztd zzk = zztd.zzb;
    private String zzl = "";
    private byte zzm = 2;

    static {
        zzuf zzuf = new zzuf();
        zza = zzuf;
        zzuz.zzak(zzuf.class, zzuf);
    }

    private zzuf() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzm);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return new zzwv(zza, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zze", "zzf", zzue.class, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i11 == 3) {
            return new zzuf();
        } else {
            if (i11 == 4) {
                return new zzuc((zztq) null);
            }
            if (i11 == 5) {
                return zza;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzm = b10;
            return null;
        }
    }
}
