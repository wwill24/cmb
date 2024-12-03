package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzd();
    public int zza;
    public String[] zzb;

    public zze() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, this.zza);
        a.D(parcel, 3, this.zzb, false);
        a.b(parcel, a10);
    }

    public zze(int i10, String[] strArr) {
        this.zza = i10;
        this.zzb = strArr;
    }
}
