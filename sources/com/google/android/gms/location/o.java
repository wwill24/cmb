package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class o implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        Status status = null;
        LocationSettingsStates locationSettingsStates = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                status = (Status) SafeParcelReader.n(parcel, B, Status.CREATOR);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                locationSettingsStates = (LocationSettingsStates) SafeParcelReader.n(parcel, B, LocationSettingsStates.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationSettingsResult[i10];
    }
}
