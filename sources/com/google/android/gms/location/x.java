package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class x implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        boolean z11 = false;
        long j10 = 0;
        long j11 = 0;
        WorkSource workSource = null;
        String str = null;
        int[] iArr = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 2:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 3:
                    workSource = (WorkSource) SafeParcelReader.n(parcel2, B, WorkSource.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    iArr = SafeParcelReader.j(parcel2, B);
                    break;
                case 6:
                    z11 = SafeParcelReader.v(parcel2, B);
                    break;
                case 7:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 8:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 9:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzb(j10, z10, workSource, str, iArr, z11, str2, j11, str3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzb[i10];
    }
}
