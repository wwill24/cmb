package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzg implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        zzn[] zznArr = null;
        zzd[] zzdArr = null;
        int i10 = 0;
        int i11 = 0;
        float f10 = Float.MAX_VALUE;
        float f11 = Float.MAX_VALUE;
        float f12 = Float.MAX_VALUE;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = -1.0f;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    i11 = SafeParcelReader.D(parcel2, B);
                    break;
                case 3:
                    f13 = SafeParcelReader.z(parcel2, B);
                    break;
                case 4:
                    f14 = SafeParcelReader.z(parcel2, B);
                    break;
                case 5:
                    f15 = SafeParcelReader.z(parcel2, B);
                    break;
                case 6:
                    f16 = SafeParcelReader.z(parcel2, B);
                    break;
                case 7:
                    f10 = SafeParcelReader.z(parcel2, B);
                    break;
                case 8:
                    f11 = SafeParcelReader.z(parcel2, B);
                    break;
                case 9:
                    zznArr = (zzn[]) SafeParcelReader.r(parcel2, B, zzn.CREATOR);
                    break;
                case 10:
                    f17 = SafeParcelReader.z(parcel2, B);
                    break;
                case 11:
                    f18 = SafeParcelReader.z(parcel2, B);
                    break;
                case 12:
                    f19 = SafeParcelReader.z(parcel2, B);
                    break;
                case 13:
                    zzdArr = (zzd[]) SafeParcelReader.r(parcel2, B, zzd.CREATOR);
                    break;
                case 14:
                    f12 = SafeParcelReader.z(parcel2, B);
                    break;
                case 15:
                    f20 = SafeParcelReader.z(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzf(i10, i11, f13, f14, f15, f16, f10, f11, f12, zznArr, f17, f18, f19, zzdArr, f20);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzf[i10];
    }
}
