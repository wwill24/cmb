package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                stringToIntConverter = (StringToIntConverter) SafeParcelReader.n(parcel, B, StringToIntConverter.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zaa(i10, stringToIntConverter);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zaa[i10];
    }
}
