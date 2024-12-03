package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    public int zza;
    public int zzb;
    public int zzc;
    public boolean zzd;
    public boolean zze;
    public float zzf;

    public zzh() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, this.zza);
        a.s(parcel, 3, this.zzb);
        a.s(parcel, 4, this.zzc);
        a.g(parcel, 5, this.zzd);
        a.g(parcel, 6, this.zze);
        a.o(parcel, 7, this.zzf);
        a.b(parcel, a10);
    }

    public zzh(int i10, int i11, int i12, boolean z10, boolean z11, float f10) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = z10;
        this.zze = z11;
        this.zzf = f10;
    }
}
