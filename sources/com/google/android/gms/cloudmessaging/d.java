package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class d implements Parcelable.Creator<CloudMessage> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.J(parcel, B);
            } else {
                intent = (Intent) SafeParcelReader.n(parcel, B, Intent.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new CloudMessage(intent);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i10) {
        return new CloudMessage[i10];
    }
}
