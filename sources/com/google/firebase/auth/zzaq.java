package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaq implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z10 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 2) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                str3 = SafeParcelReader.o(parcel, B);
            } else if (u10 == 5) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 != 6) {
                SafeParcelReader.J(parcel, B);
            } else {
                str4 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new PhoneAuthCredential(str, str2, str3, z10, str4);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new PhoneAuthCredential[i10];
    }
}
