package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

public final class y9 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        boolean z10 = true;
        boolean z11 = true;
        String str = "";
        String str2 = str;
        boolean z12 = false;
        int i10 = 0;
        boolean z13 = false;
        boolean z14 = false;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str10 = null;
        String str11 = null;
        long j16 = -2147483648L;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                case 3:
                    str4 = SafeParcelReader.o(parcel2, B);
                    break;
                case 4:
                    str5 = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    str6 = SafeParcelReader.o(parcel2, B);
                    break;
                case 6:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 7:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 8:
                    str7 = SafeParcelReader.o(parcel2, B);
                    break;
                case 9:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 10:
                    z12 = SafeParcelReader.v(parcel2, B);
                    break;
                case 11:
                    j16 = SafeParcelReader.F(parcel2, B);
                    break;
                case 12:
                    str8 = SafeParcelReader.o(parcel2, B);
                    break;
                case 13:
                    j12 = SafeParcelReader.F(parcel2, B);
                    break;
                case 14:
                    j13 = SafeParcelReader.F(parcel2, B);
                    break;
                case 15:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 16:
                    z11 = SafeParcelReader.v(parcel2, B);
                    break;
                case 18:
                    z13 = SafeParcelReader.v(parcel2, B);
                    break;
                case 19:
                    str9 = SafeParcelReader.o(parcel2, B);
                    break;
                case 21:
                    bool = SafeParcelReader.w(parcel2, B);
                    break;
                case 22:
                    j14 = SafeParcelReader.F(parcel2, B);
                    break;
                case 23:
                    arrayList = SafeParcelReader.q(parcel2, B);
                    break;
                case 24:
                    str10 = SafeParcelReader.o(parcel2, B);
                    break;
                case 25:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 26:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 27:
                    str11 = SafeParcelReader.o(parcel2, B);
                    break;
                case 28:
                    z14 = SafeParcelReader.v(parcel2, B);
                    break;
                case 29:
                    j15 = SafeParcelReader.F(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzq(str3, str4, str5, str6, j10, j11, str7, z10, z12, j16, str8, j12, j13, i10, z11, z13, str9, bool, j14, (List) arrayList, str10, str, str2, str11, z14, j15);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzq[i10];
    }
}
