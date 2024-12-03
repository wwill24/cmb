package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzta implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 2:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    str4 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    str5 = SafeParcelReader.o(parcel, B);
                    break;
                case 6:
                    str6 = SafeParcelReader.o(parcel, B);
                    break;
                case 7:
                    str7 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzsh(str, str2, str3, str4, str5, str6, str7);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzsh[i10];
    }
}
