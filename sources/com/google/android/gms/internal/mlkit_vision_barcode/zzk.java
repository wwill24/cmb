package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzx();
    public double zza;
    public double zzb;

    public zzk() {
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.zza);
        a.l(parcel, 3, this.zzb);
        a.b(parcel, a10);
    }

    public zzk(double d10, double d11) {
        this.zza = d10;
        this.zzb = d11;
    }
}
