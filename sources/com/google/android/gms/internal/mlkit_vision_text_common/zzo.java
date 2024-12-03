package com.google.android.gms.internal.mlkit_vision_text_common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzo implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            SafeParcelReader.u(B);
            SafeParcelReader.J(parcel, B);
        }
        SafeParcelReader.t(parcel, K);
        return new zzn();
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzn[i10];
    }
}
