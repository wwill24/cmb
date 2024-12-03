package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

public final class e0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        WorkSource workSource = new WorkSource();
        String str = null;
        zzd zzd = null;
        long j10 = Long.MAX_VALUE;
        long j11 = Long.MAX_VALUE;
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        int i12 = 102;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 2:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 3:
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                case 4:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 5:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 6:
                    workSource = (WorkSource) SafeParcelReader.n(parcel2, B, WorkSource.CREATOR);
                    break;
                case 7:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 8:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 9:
                    zzd = (zzd) SafeParcelReader.n(parcel2, B, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new CurrentLocationRequest(j10, i10, i12, j11, z10, i11, str, workSource, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new CurrentLocationRequest[i10];
    }
}
