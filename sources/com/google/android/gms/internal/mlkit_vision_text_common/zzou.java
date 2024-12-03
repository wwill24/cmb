package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzou extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzou> CREATOR = new zzov();
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;

    public zzou(int i10, int i11, int i12, int i13, long j10) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = j10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.s(parcel, 2, this.zzb);
        a.s(parcel, 3, this.zzc);
        a.s(parcel, 4, this.zzd);
        a.v(parcel, 5, this.zze);
        a.b(parcel, a10);
    }
}
