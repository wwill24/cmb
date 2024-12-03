package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class c0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        ArrayList<ActivityTransition> arrayList = null;
        String str = null;
        ArrayList<ClientIdentity> arrayList2 = null;
        String str2 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                arrayList = SafeParcelReader.s(parcel, B, ActivityTransition.CREATOR);
            } else if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                arrayList2 = SafeParcelReader.s(parcel, B, ClientIdentity.CREATOR);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                str2 = SafeParcelReader.o(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new ActivityTransitionRequest(arrayList, str, arrayList2, str2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new ActivityTransitionRequest[i10];
    }
}
