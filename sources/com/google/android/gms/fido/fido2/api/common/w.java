package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class w implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        long j10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 == 2) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 == 3) {
                bArr2 = SafeParcelReader.g(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                bArr3 = SafeParcelReader.g(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzn(j10, bArr, bArr2, bArr3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzn[i10];
    }
}
