package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzs implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        zzn[] zznArr = null;
        zzf zzf = null;
        zzf zzf2 = null;
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        boolean z10 = false;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    zznArr = (zzn[]) SafeParcelReader.r(parcel, B, zzn.CREATOR);
                    break;
                case 3:
                    zzf = (zzf) SafeParcelReader.n(parcel, B, zzf.CREATOR);
                    break;
                case 4:
                    zzf2 = (zzf) SafeParcelReader.n(parcel, B, zzf.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 6:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 7:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 8:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzr(zznArr, zzf, zzf2, str, f10, str2, z10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzr[i10];
    }
}
