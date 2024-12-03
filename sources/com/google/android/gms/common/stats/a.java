package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        boolean z10 = false;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        float f10 = 0.0f;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                case 6:
                    arrayList = SafeParcelReader.q(parcel2, B);
                    break;
                case 8:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 10:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                case 11:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 12:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 13:
                    str4 = SafeParcelReader.o(parcel2, B);
                    break;
                case 14:
                    i13 = SafeParcelReader.D(parcel2, B);
                    break;
                case 15:
                    f10 = SafeParcelReader.z(parcel2, B);
                    break;
                case 16:
                    j12 = SafeParcelReader.F(parcel2, B);
                    break;
                case 17:
                    str5 = SafeParcelReader.o(parcel2, B);
                    break;
                case 18:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new WakeLockEvent(i10, j10, i11, str, i12, arrayList, str2, j11, i13, str3, str4, f10, j12, str5, z10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new WakeLockEvent[i10];
    }
}
