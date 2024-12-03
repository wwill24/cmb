package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class y implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        long j10 = 0;
        long j11 = 0;
        ArrayList<DetectedActivity> arrayList = null;
        Bundle bundle = null;
        int i10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                arrayList = SafeParcelReader.s(parcel, B, DetectedActivity.CREATOR);
            } else if (u10 == 2) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 == 3) {
                j11 = SafeParcelReader.F(parcel, B);
            } else if (u10 == 4) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                bundle = SafeParcelReader.f(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new ActivityRecognitionResult(arrayList, j10, j11, i10, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ActivityRecognitionResult[i10];
    }
}
