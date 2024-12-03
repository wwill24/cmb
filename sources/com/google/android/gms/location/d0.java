package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class d0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        ArrayList<ActivityTransitionEvent> arrayList = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                arrayList = SafeParcelReader.s(parcel, B, ActivityTransitionEvent.CREATOR);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                bundle = SafeParcelReader.f(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new ActivityTransitionResult(arrayList, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ActivityTransitionResult[i10];
    }
}
