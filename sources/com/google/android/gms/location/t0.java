package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class t0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        List list = LocationResult.f39547b;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.J(parcel, B);
            } else {
                list = SafeParcelReader.s(parcel, B, Location.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new LocationResult(list);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationResult[i10];
    }
}
