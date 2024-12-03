package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class r0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        int i10 = 1;
        int i11 = 1;
        int i12 = 1000;
        long j10 = 0;
        zzac[] zzacArr = null;
        boolean z10 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 3:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 4:
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                case 5:
                    zzacArr = (zzac[]) SafeParcelReader.r(parcel2, B, zzac.CREATOR);
                    break;
                case 6:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new LocationAvailability(i12, i10, i11, j10, zzacArr, z10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationAvailability[i10];
    }
}
