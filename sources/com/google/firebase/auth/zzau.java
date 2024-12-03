package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.p003firebaseauthapi.zzaia;

public final class zzau implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        String str2 = null;
        zzaia zzaia = null;
        long j10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 2) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                zzaia = (zzaia) SafeParcelReader.n(parcel, B, zzaia.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new TotpMultiFactorInfo(str, str2, j10, zzaia);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new TotpMultiFactorInfo[i10];
    }
}
