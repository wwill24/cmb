package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class n implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        UvmEntries uvmEntries = null;
        zze zze = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                uvmEntries = (UvmEntries) SafeParcelReader.n(parcel, B, UvmEntries.CREATOR);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                zze = (zze) SafeParcelReader.n(parcel, B, zze.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new AuthenticationExtensionsClientOutputs(uvmEntries, zze);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AuthenticationExtensionsClientOutputs[i10];
    }
}
