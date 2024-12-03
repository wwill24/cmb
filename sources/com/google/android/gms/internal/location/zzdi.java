package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzdi implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        short s10 = 0;
        int i11 = 0;
        String str = null;
        float f10 = 0.0f;
        long j10 = 0;
        int i12 = -1;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 2:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 3:
                    s10 = SafeParcelReader.H(parcel2, B);
                    break;
                case 4:
                    d10 = SafeParcelReader.x(parcel2, B);
                    break;
                case 5:
                    d11 = SafeParcelReader.x(parcel2, B);
                    break;
                case 6:
                    f10 = SafeParcelReader.z(parcel2, B);
                    break;
                case 7:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 8:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 9:
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzdh(str, i10, s10, d10, d11, f10, j10, i11, i12);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzdh[i10];
    }
}
