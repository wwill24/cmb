package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        String str = null;
        String str2 = null;
        zzlk zzlk = null;
        String str3 = null;
        zzau zzau = null;
        zzau zzau2 = null;
        zzau zzau3 = null;
        boolean z10 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 4:
                    zzlk = (zzlk) SafeParcelReader.n(parcel2, B, zzlk.CREATOR);
                    break;
                case 5:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 6:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 7:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                case 8:
                    zzau = (zzau) SafeParcelReader.n(parcel2, B, zzau.CREATOR);
                    break;
                case 9:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 10:
                    zzau2 = (zzau) SafeParcelReader.n(parcel2, B, zzau.CREATOR);
                    break;
                case 11:
                    j12 = SafeParcelReader.F(parcel2, B);
                    break;
                case 12:
                    zzau3 = (zzau) SafeParcelReader.n(parcel2, B, zzau.CREATOR);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzac(str, str2, zzlk, j10, z10, str3, zzau, j11, zzau2, j12, zzau3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzac[i10];
    }
}
