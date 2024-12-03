package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

public final class s0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        WorkSource workSource = new WorkSource();
        String str = null;
        zzd zzd = null;
        long j10 = Long.MAX_VALUE;
        long j11 = Long.MAX_VALUE;
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 102;
        long j12 = 3600000;
        long j13 = 600000;
        long j14 = 0;
        int i13 = Integer.MAX_VALUE;
        float f10 = 0.0f;
        long j15 = -1;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    j12 = SafeParcelReader.F(parcel2, B);
                    break;
                case 3:
                    j13 = SafeParcelReader.F(parcel2, B);
                    break;
                case 5:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 6:
                    i13 = SafeParcelReader.D(parcel2, B);
                    break;
                case 7:
                    f10 = SafeParcelReader.z(parcel2, B);
                    break;
                case 8:
                    j14 = SafeParcelReader.F(parcel2, B);
                    break;
                case 9:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 10:
                    j11 = SafeParcelReader.F(parcel2, B);
                    break;
                case 11:
                    j15 = SafeParcelReader.F(parcel2, B);
                    break;
                case 12:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 13:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 14:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 15:
                    z11 = SafeParcelReader.v(parcel2, B);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.n(parcel2, B, WorkSource.CREATOR);
                    break;
                case 17:
                    zzd = (zzd) SafeParcelReader.n(parcel2, B, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new LocationRequest(i12, j12, j13, j14, j10, j11, i13, f10, z10, j15, i10, i11, str, z11, workSource, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new LocationRequest[i10];
    }
}
