package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class s implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        Boolean bool = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                bool = SafeParcelReader.w(parcel, B);
            } else if (u10 == 4) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                str3 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new AuthenticatorSelectionCriteria(str, bool, str2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AuthenticatorSelectionCriteria[i10];
    }
}
