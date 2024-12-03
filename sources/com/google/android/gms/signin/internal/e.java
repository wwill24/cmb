package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zav;

public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        ConnectionResult connectionResult = null;
        int i10 = 0;
        zav zav = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.n(parcel, B, ConnectionResult.CREATOR);
            } else if (u10 != 3) {
                SafeParcelReader.J(parcel, B);
            } else {
                zav = (zav) SafeParcelReader.n(parcel, B, zav.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zak(i10, connectionResult, zav);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zak[i10];
    }
}
