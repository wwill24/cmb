package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaw implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        String str2 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                z11 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new UserProfileChangeRequest(str, str2, z10, z11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new UserProfileChangeRequest[i10];
    }
}
