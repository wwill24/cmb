package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    public int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    public int zze;

    public zzd() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, this.zza);
        a.s(parcel, 3, this.zzb);
        a.s(parcel, 4, this.zzc);
        a.v(parcel, 5, this.zzd);
        a.s(parcel, 6, this.zze);
        a.b(parcel, a10);
    }

    public zzd(int i10, int i11, int i12, long j10, int i13) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = j10;
        this.zze = i13;
    }
}
