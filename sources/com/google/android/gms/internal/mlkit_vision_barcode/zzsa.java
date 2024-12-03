package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zzsa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsa> CREATOR = new zzrz();
    private final int zza;
    private final String[] zzb;

    public zzsa(int i10, String[] strArr) {
        this.zza = i10;
        this.zzb = strArr;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.zza);
        a.D(parcel, 2, this.zzb, false);
        a.b(parcel, a10);
    }

    public final int zza() {
        return this.zza;
    }

    public final String[] zzb() {
        return this.zzb;
    }
}
