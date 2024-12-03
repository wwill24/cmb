package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class y implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        boolean z11 = false;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 2:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    bArr = SafeParcelReader.g(parcel, B);
                    break;
                case 4:
                    bArr2 = SafeParcelReader.g(parcel, B);
                    break;
                case 5:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new FidoCredentialDetails(str, str2, bArr, bArr2, z10, z11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new FidoCredentialDetails[i10];
    }
}
