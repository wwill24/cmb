package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class p implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 2:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 3:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                case 4:
                    z13 = SafeParcelReader.v(parcel, B);
                    break;
                case 5:
                    z14 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    z15 = SafeParcelReader.v(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new LocationSettingsStates(z10, z11, z12, z13, z14, z15);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationSettingsStates[i10];
    }
}
