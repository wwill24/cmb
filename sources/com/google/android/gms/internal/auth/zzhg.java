package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

final class zzhg extends zzhh {
    zzhg(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j10) {
        return Double.longBitsToDouble(zzj(obj, j10));
    }

    public final float zzb(Object obj, long j10) {
        return Float.intBitsToFloat(zzi(obj, j10));
    }

    public final void zzc(Object obj, long j10, boolean z10) {
        if (zzhi.zza) {
            zzhi.zzi(obj, j10, z10);
        } else {
            zzhi.zzj(obj, j10, z10);
        }
    }

    public final void zzd(Object obj, long j10, double d10) {
        zzn(obj, j10, Double.doubleToLongBits(d10));
    }

    public final void zze(Object obj, long j10, float f10) {
        zzm(obj, j10, Float.floatToIntBits(f10));
    }

    public final boolean zzf(Object obj, long j10) {
        if (zzhi.zza) {
            return zzhi.zzq(obj, j10);
        }
        return zzhi.zzr(obj, j10);
    }
}
