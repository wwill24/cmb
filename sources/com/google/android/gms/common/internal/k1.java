package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class k1 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        Bundle bundle = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i10 = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                bundle = SafeParcelReader.f(parcel, B);
            } else if (u10 == 2) {
                featureArr = (Feature[]) SafeParcelReader.r(parcel, B, Feature.CREATOR);
            } else if (u10 == 3) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.n(parcel, B, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzj(bundle, featureArr, i10, connectionTelemetryConfiguration);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzj[i10];
    }
}
