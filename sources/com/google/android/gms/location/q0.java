package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

public final class q0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        zzd zzd = null;
        int i10 = 0;
        boolean z10 = false;
        long j10 = Long.MAX_VALUE;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                z10 = SafeParcelReader.v(parcel, B);
            } else if (u10 == 4) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                zzd = (zzd) SafeParcelReader.n(parcel, B, zzd.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new LastLocationRequest(j10, i10, z10, str, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LastLocationRequest[i10];
    }
}
