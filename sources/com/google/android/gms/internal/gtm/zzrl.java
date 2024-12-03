package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.InputStream;

public final class zzrl extends zzuz<zzrl, zzrk> implements zzwl {
    /* access modifiers changed from: private */
    public static final zzrl zza;
    private int zze;
    private long zzf;
    private zzaa zzg;
    private zzai zzh;
    private byte zzi = 2;

    static {
        zzrl zzrl = new zzrl();
        zza = zzrl;
        zzuz.zzak(zzrl.class, zzrl);
    }

    private zzrl() {
    }

    public static zzrk zze() {
        return (zzrk) zza.zzY();
    }

    public static zzrl zzg(InputStream inputStream, zzuj zzuj) throws IOException {
        return (zzrl) zzuz.zzac(zza, inputStream, zzuj);
    }

    static /* synthetic */ void zzh(zzrl zzrl, long j10) {
        zzrl.zze |= 1;
        zzrl.zzf = j10;
    }

    static /* synthetic */ void zzi(zzrl zzrl, zzaa zzaa) {
        zzaa.getClass();
        zzrl.zzg = zzaa;
        zzrl.zze |= 2;
    }

    static /* synthetic */ void zzj(zzrl zzrl, zzai zzai) {
        zzai.getClass();
        zzrl.zzh = zzai;
        zzrl.zze |= 4;
    }

    public final long zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzi);
        }
        byte b10 = 1;
        if (i11 == 2) {
            return zzuz.zzaj(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔂ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i11 == 3) {
            return new zzrl();
        } else {
            if (i11 == 4) {
                return new zzrk((zzrj) null);
            }
            if (i11 == 5) {
                return zza;
            }
            if (obj == null) {
                b10 = 0;
            }
            this.zzi = b10;
            return null;
        }
    }

    public final zzaa zzc() {
        zzaa zzaa = this.zzg;
        return zzaa == null ? zzaa.zzl() : zzaa;
    }

    public final zzai zzd() {
        zzai zzai = this.zzh;
        return zzai == null ? zzai.zzf() : zzai;
    }

    public final boolean zzk() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzl() {
        return (this.zze & 4) != 0;
    }
}
