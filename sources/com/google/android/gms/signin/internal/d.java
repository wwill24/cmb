package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zat;

public final class d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        zat zat = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                zat = (zat) SafeParcelReader.n(parcel, B, zat.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zai(i10, zat);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zai[i10];
    }
}
