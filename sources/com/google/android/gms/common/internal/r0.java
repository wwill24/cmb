package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class r0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        int i11 = 0;
        Scope[] scopeArr = null;
        int i12 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i12 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.r(parcel, B, Scope.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zax(i10, i12, i11, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zax[i10];
    }
}
