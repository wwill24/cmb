package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzs();
    public int zza;
    public int zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public String zzh;

    public zzf() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, this.zza);
        a.s(parcel, 3, this.zzb);
        a.s(parcel, 4, this.zzc);
        a.s(parcel, 5, this.zzd);
        a.s(parcel, 6, this.zze);
        a.s(parcel, 7, this.zzf);
        a.g(parcel, 8, this.zzg);
        a.C(parcel, 9, this.zzh, false);
        a.b(parcel, a10);
    }

    public zzf(int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, String str) {
        this.zza = i10;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = i15;
        this.zzg = z10;
        this.zzh = str;
    }
}
