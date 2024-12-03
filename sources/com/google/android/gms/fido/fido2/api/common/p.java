package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class p implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 == 3) {
                bArr2 = SafeParcelReader.g(parcel, B);
            } else if (u10 == 4) {
                bArr3 = SafeParcelReader.g(parcel, B);
            } else if (u10 == 5) {
                bArr4 = SafeParcelReader.g(parcel, B);
            } else if (u10 != 6) {
                SafeParcelReader.J(parcel, B);
            } else {
                bArr5 = SafeParcelReader.g(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new AuthenticatorAssertionResponse(bArr, bArr2, bArr3, bArr4, bArr5);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AuthenticatorAssertionResponse[i10];
    }
}
