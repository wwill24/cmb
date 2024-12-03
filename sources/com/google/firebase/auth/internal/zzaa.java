package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaa implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        long j10 = 0;
        long j11 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                j11 = SafeParcelReader.F(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzz(j10, j11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzz[i10];
    }
}
