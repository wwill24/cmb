package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzcm implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        long j10 = 0;
        long j11 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        boolean z10 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 2:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 3:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 6:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel2, B);
                    break;
                case 8:
                    str4 = SafeParcelReader.o(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzcl(j10, j11, z10, str, str2, str3, bundle, str4);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzcl[i10];
    }
}
