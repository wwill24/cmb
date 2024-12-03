package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzph implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        ArrayList<zzpa> arrayList = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, zzpa.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzpg(str, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzpg[i10];
    }
}
