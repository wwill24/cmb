package com.google.android.gms.internal.mlkit_vision_face;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzox implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        Rect rect = null;
        ArrayList<zzpc> arrayList = null;
        ArrayList<zzos> arrayList2 = null;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        int i10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    rect = (Rect) SafeParcelReader.n(parcel2, B, Rect.CREATOR);
                    break;
                case 3:
                    f10 = SafeParcelReader.z(parcel2, B);
                    break;
                case 4:
                    f11 = SafeParcelReader.z(parcel2, B);
                    break;
                case 5:
                    f12 = SafeParcelReader.z(parcel2, B);
                    break;
                case 6:
                    f13 = SafeParcelReader.z(parcel2, B);
                    break;
                case 7:
                    f14 = SafeParcelReader.z(parcel2, B);
                    break;
                case 8:
                    f15 = SafeParcelReader.z(parcel2, B);
                    break;
                case 9:
                    f16 = SafeParcelReader.z(parcel2, B);
                    break;
                case 10:
                    arrayList = SafeParcelReader.s(parcel2, B, zzpc.CREATOR);
                    break;
                case 11:
                    arrayList2 = SafeParcelReader.s(parcel2, B, zzos.CREATOR);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new zzow(i10, rect, f10, f11, f12, f13, f14, f15, f16, arrayList, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzow[i10];
    }
}
