package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import fe.a;

public final class t implements Parcelable.Creator {
    static void a(zzau zzau, Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, zzau.f40491a, false);
        a.A(parcel, 3, zzau.f40492b, i10, false);
        a.C(parcel, 4, zzau.f40493c, false);
        a.v(parcel, 5, zzau.f40494d);
        a.b(parcel, a10);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        zzas zzas = null;
        String str2 = null;
        long j10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                zzas = (zzas) SafeParcelReader.n(parcel, B, zzas.CREATOR);
            } else if (u10 == 4) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                j10 = SafeParcelReader.F(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzau(str, zzas, str2, j10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzau[i10];
    }
}
