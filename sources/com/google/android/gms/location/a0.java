package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class a0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        long j10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 3) {
                SafeParcelReader.J(parcel, B);
            } else {
                j10 = SafeParcelReader.F(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new ActivityTransitionEvent(i10, i11, j10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ActivityTransitionEvent[i10];
    }
}
