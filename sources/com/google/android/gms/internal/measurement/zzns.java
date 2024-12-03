package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

final class zzns extends zznt {
    zzns(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j10) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j10));
    }

    public final float zzb(Object obj, long j10) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j10));
    }

    public final void zzc(Object obj, long j10, boolean z10) {
        if (zznu.zzb) {
            zznu.zzD(obj, j10, r3 ? (byte) 1 : 0);
        } else {
            zznu.zzE(obj, j10, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j10, byte b10) {
        if (zznu.zzb) {
            zznu.zzD(obj, j10, b10);
        } else {
            zznu.zzE(obj, j10, b10);
        }
    }

    public final void zze(Object obj, long j10, double d10) {
        this.zza.putLong(obj, j10, Double.doubleToLongBits(d10));
    }

    public final void zzf(Object obj, long j10, float f10) {
        this.zza.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    public final boolean zzg(Object obj, long j10) {
        if (zznu.zzb) {
            return zznu.zzt(obj, j10);
        }
        return zznu.zzu(obj, j10);
    }
}
