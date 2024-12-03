package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class w implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        ArrayList<MethodInvocation> arrayList = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, MethodInvocation.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new TelemetryData(i10, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new TelemetryData[i10];
    }
}
