package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class q implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        String[] strArr = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 == 3) {
                bArr2 = SafeParcelReader.g(parcel, B);
            } else if (u10 == 4) {
                bArr3 = SafeParcelReader.g(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                strArr = SafeParcelReader.p(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new AuthenticatorAttestationResponse(bArr, bArr2, bArr3, strArr);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AuthenticatorAttestationResponse[i10];
    }
}
