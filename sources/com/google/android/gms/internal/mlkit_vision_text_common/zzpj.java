package com.google.android.gms.internal.mlkit_vision_text_common;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzpj implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        float f10 = 0.0f;
        float f11 = 0.0f;
        String str = null;
        Rect rect = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 2) {
                rect = (Rect) SafeParcelReader.n(parcel, B, Rect.CREATOR);
            } else if (u10 == 3) {
                arrayList = SafeParcelReader.s(parcel, B, Point.CREATOR);
            } else if (u10 == 4) {
                f10 = SafeParcelReader.z(parcel, B);
            } else if (u10 != 5) {
                SafeParcelReader.J(parcel, B);
            } else {
                f11 = SafeParcelReader.z(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzpi(str, rect, arrayList, f10, f11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzpi[i10];
    }
}
