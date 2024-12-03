package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzsq implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z10 = false;
        String str = null;
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
                    i12 = SafeParcelReader.D(parcel, B);
                    break;
                case 4:
                    i13 = SafeParcelReader.D(parcel, B);
                    break;
                case 5:
                    i14 = SafeParcelReader.D(parcel, B);
                    break;
                case 6:
                    i15 = SafeParcelReader.D(parcel, B);
                    break;
                case 7:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 8:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzsb(i10, i11, i12, i13, i14, i15, z10, str);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzsb[i10];
    }
}
