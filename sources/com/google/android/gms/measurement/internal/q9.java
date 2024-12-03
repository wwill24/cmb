package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import fe.a;

public final class q9 implements Parcelable.Creator {
    static void a(zzlk zzlk, Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, zzlk.f40499a);
        a.C(parcel, 2, zzlk.f40500b, false);
        a.v(parcel, 3, zzlk.f40501c);
        a.x(parcel, 4, zzlk.f40502d, false);
        a.q(parcel, 5, (Float) null, false);
        a.C(parcel, 6, zzlk.f40503e, false);
        a.C(parcel, 7, zzlk.f40504f, false);
        a.n(parcel, 8, zzlk.f40505g, false);
        a.b(parcel, a10);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        String str = null;
        Long l10 = null;
        Float f10 = null;
        String str2 = null;
        String str3 = null;
        Double d10 = null;
        long j10 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 3:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 4:
                    l10 = SafeParcelReader.G(parcel2, B);
                    break;
                case 5:
                    f10 = SafeParcelReader.A(parcel2, B);
                    break;
                case 6:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 7:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                case 8:
                    d10 = SafeParcelReader.y(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzlk(i10, str, j10, l10, f10, str2, str3, d10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzlk[i10];
    }
}
