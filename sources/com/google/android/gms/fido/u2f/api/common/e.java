package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.common.Transport;
import java.util.ArrayList;

public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        byte[] bArr = null;
        ArrayList<Transport> arrayList = null;
        int i10 = 0;
        String str = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                bArr = SafeParcelReader.g(parcel, B);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, Transport.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new KeyHandle(i10, bArr, str, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new KeyHandle[i10];
    }
}
