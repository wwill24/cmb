package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zze implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        long j10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 4) {
                i12 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 5) {
                j10 = SafeParcelReader.F(parcel, B);
            } else if (u10 != 6) {
                SafeParcelReader.J(parcel, B);
            } else {
                i13 = SafeParcelReader.D(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzd(i10, i11, i12, j10, i13);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzd[i10];
    }
}
