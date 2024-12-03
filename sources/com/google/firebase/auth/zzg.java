package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzg implements Parcelable.Creator {
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
            } else if (u10 == 3) {
                str3 = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                str4 = SafeParcelReader.o(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                z10 = SafeParcelReader.v(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new EmailAuthCredential(str, str2, str3, str4, z10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new EmailAuthCredential[i10];
    }
}
