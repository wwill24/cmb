package com.google.android.gms.internal.mlkit_vision_text_common;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzpd implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        float f10 = 0.0f;
        float f11 = 0.0f;
        String str = null;
        Rect rect = null;
        ArrayList arrayList = null;
        String str2 = null;
        ArrayList<zzpi> arrayList2 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 2:
                    rect = (Rect) SafeParcelReader.n(parcel, B, Rect.CREATOR);
                    break;
                case 3:
                    arrayList = SafeParcelReader.s(parcel, B, Point.CREATOR);
                    break;
                case 4:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    f10 = SafeParcelReader.z(parcel, B);
                    break;
                case 6:
                    f11 = SafeParcelReader.z(parcel, B);
                    break;
                case 7:
                    arrayList2 = SafeParcelReader.s(parcel, B, zzpi.CREATOR);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzpc(str, rect, arrayList, str2, f10, f11, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzpc[i10];
    }
}
