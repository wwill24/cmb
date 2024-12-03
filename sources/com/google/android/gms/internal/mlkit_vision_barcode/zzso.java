package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzso extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzso> CREATOR = new zzsp();
    private final int zza;
    private final boolean zzb;

    public zzso(int i10, boolean z10) {
        this.zza = i10;
        this.zzb = z10;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.g(parcel, 2, this.zzb);
        a.b(parcel, a10);
    }
}
