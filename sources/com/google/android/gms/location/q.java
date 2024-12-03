package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class q implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        long j10 = -1;
        long j11 = -1;
        int i10 = 1;
        int i11 = 1;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                j11 = SafeParcelReader.F(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzac(i10, i11, j10, j11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzac[i10];
    }
}
