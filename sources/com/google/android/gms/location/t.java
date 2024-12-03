package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class t implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 == 2) {
                j11 = SafeParcelReader.F(parcel, B);
            } else if (u10 == 3) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 4) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                i12 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new SleepSegmentEvent(j10, j11, i10, i11, i12);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new SleepSegmentEvent[i10];
    }
}
