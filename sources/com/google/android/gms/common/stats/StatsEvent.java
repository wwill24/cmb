package com.google.android.gms.common.stats;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public final String toString() {
        long zzc = zzc();
        int zza = zza();
        long zzb = zzb();
        String zzd = zzd();
        return zzc + "\t" + zza + "\t" + zzb + zzd;
    }

    public abstract int zza();

    public abstract long zzb();

    public abstract long zzc();

    @NonNull
    public abstract String zzd();
}
