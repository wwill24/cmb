package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzi implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = -1.0f;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 2:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 3:
                    i11 = SafeParcelReader.D(parcel, B);
                    break;
                case 4:
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 5:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 7:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzh(i10, i11, i12, z10, z11, f10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzh[i10];
    }
}
