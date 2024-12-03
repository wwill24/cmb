package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzw();
    public int zza;
    public String zzb;
    public String zzc;
    public String zzd;

    public zzj() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, this.zza);
        a.C(parcel, 3, this.zzb, false);
        a.C(parcel, 4, this.zzc, false);
        a.C(parcel, 5, this.zzd, false);
        a.b(parcel, a10);
    }

    public zzj(int i10, String str, String str2, String str3) {
        this.zza = i10;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }
}
