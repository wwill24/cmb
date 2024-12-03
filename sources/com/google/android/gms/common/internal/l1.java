package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class l1 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 0;
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        int[] iArr2 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.n(parcel, B, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 3:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 4:
                    iArr = SafeParcelReader.j(parcel, B);
                    break;
                case 5:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    iArr2 = SafeParcelReader.j(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z10, z11, iArr, i10, iArr2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ConnectionTelemetryConfiguration[i10];
    }
}
