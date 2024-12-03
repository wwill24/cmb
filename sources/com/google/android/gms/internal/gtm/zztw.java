package com.google.android.gms.internal.gtm;

public final class zztw extends zzuv<zztw, zztr> {
    /* access modifiers changed from: private */
    public static final zztw zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private zzvh<zztv> zzm = zzwu.zze();
    private boolean zzn;
    private boolean zzo = true;
    private boolean zzp;
    private zzvh<zzuf> zzq = zzwu.zze();
    private byte zzr = 2;

    static {
        zztw zztw = new zztw();
        zze = zztw;
        zzuz.zzak(zztw.class, zztw);
    }

    private zztw() {
    }

    public static zztw zze() {
        return zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzr);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return new zzwv(zze, "\u0001\u000b\u0000\u0001\u0001ϧ\u000b\u0000\u0002\u0001\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0004\u0005ဇ\u0003\u0006ဌ\u0002\nဇ\u0005\u000b\u001b\fဇ\u0006\rဇ\u0007\u000eဇ\bϧЛ", new Object[]{"zzf", "zzg", zzts.zza, "zzh", "zzk", "zzj", "zzi", zztt.zza, "zzl", "zzm", zztv.class, "zzn", "zzo", "zzp", "zzq", zzuf.class});
        } else if (i11 == 3) {
            return new zztw();
        } else {
            if (i11 == 4) {
                return new zztr((zztq) null);
            }
            if (i11 == 5) {
                return zze;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzr = b10;
            return null;
        }
    }
}
