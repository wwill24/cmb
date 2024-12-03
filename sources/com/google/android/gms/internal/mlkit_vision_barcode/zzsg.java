package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzsg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsg> CREATOR = new zzsv();
    private final double zza;
    private final double zzb;

    public zzsg(double d10, double d11) {
        this.zza = d10;
        this.zzb = d11;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.zza);
        a.l(parcel, 2, this.zzb);
        a.b(parcel, a10);
    }

    public final double zza() {
        return this.zza;
    }

    public final double zzb() {
        return this.zzb;
    }
}
