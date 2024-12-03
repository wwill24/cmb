package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class k0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        String str = null;
        String str2 = null;
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = -1;
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
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                case 4:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 5:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 6:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 7:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 8:
                    i13 = SafeParcelReader.D(parcel2, B);
                    break;
                case 9:
                    i14 = SafeParcelReader.D(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new MethodInvocation(i10, i11, i12, j10, j11, str, str2, i13, i14);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new MethodInvocation[i10];
    }
}
