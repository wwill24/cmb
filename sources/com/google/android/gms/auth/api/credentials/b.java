package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        int i11 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 2) {
                z11 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 3) {
                z12 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 4) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 1000) {
                SafeParcelReader.J(parcel, B);
            } else {
                i10 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new CredentialPickerConfig(i10, z10, z11, z12, i11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new CredentialPickerConfig[i10];
    }
}
