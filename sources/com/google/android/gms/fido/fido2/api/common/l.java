package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class l implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        short s10 = 0;
        short s11 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                s10 = SafeParcelReader.H(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.J(parcel, B);
            } else {
                s11 = SafeParcelReader.H(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new UvmEntry(i10, s10, s11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new UvmEntry[i10];
    }
}
