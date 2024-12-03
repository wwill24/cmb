package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzm implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        boolean z10 = false;
        int i11 = 0;
        int i12 = 0;
        zzr[] zzrArr = null;
        zzf zzf = null;
        zzf zzf2 = null;
        zzf zzf3 = null;
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    zzrArr = (zzr[]) SafeParcelReader.r(parcel2, B, zzr.CREATOR);
                    break;
                case 3:
                    zzf = (zzf) SafeParcelReader.n(parcel2, B, zzf.CREATOR);
                    break;
                case 4:
                    zzf2 = (zzf) SafeParcelReader.n(parcel2, B, zzf.CREATOR);
                    break;
                case 5:
                    zzf3 = (zzf) SafeParcelReader.n(parcel2, B, zzf.CREATOR);
                    break;
                case 6:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 7:
                    f10 = SafeParcelReader.z(parcel2, B);
                    break;
                case 8:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 9:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 10:
                    z10 = SafeParcelReader.v(parcel2, B);
                    break;
                case 11:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 12:
                    i12 = SafeParcelReader.D(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzl(zzrArr, zzf, zzf2, zzf3, str, f10, str2, i10, z10, i11, i12);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzl[i10];
    }
}
