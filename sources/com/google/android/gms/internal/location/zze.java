package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zze implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        List zzk = zzds.zzk();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        zzd zzd = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 3:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 7:
                    zzd = (zzd) SafeParcelReader.n(parcel, B, zzd.CREATOR);
                    break;
                case 8:
                    zzk = SafeParcelReader.s(parcel, B, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzd(i10, i11, str, str2, str3, i12, zzk, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzd[i10];
    }
}
