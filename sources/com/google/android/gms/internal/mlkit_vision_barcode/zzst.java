package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzst implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 2:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 3:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                case 4:
                    str4 = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    str5 = SafeParcelReader.o(parcel2, B);
                    break;
                case 6:
                    str6 = SafeParcelReader.o(parcel2, B);
                    break;
                case 7:
                    str7 = SafeParcelReader.o(parcel2, B);
                    break;
                case 8:
                    str8 = SafeParcelReader.o(parcel2, B);
                    break;
                case 9:
                    str9 = SafeParcelReader.o(parcel2, B);
                    break;
                case 10:
                    str10 = SafeParcelReader.o(parcel2, B);
                    break;
                case 11:
                    str11 = SafeParcelReader.o(parcel2, B);
                    break;
                case 12:
                    str12 = SafeParcelReader.o(parcel2, B);
                    break;
                case 13:
                    str13 = SafeParcelReader.o(parcel2, B);
                    break;
                case 14:
                    str14 = SafeParcelReader.o(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzse(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzse[i10];
    }
}
