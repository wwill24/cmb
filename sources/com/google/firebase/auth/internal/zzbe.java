package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;

public final class zzbe implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        ArrayList<PhoneMultiFactorInfo> arrayList = null;
        ArrayList<TotpMultiFactorInfo> arrayList2 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                arrayList = SafeParcelReader.s(parcel, B, PhoneMultiFactorInfo.CREATOR);
            } else if (u10 != 2) {
                SafeParcelReader.J(parcel, B);
            } else {
                arrayList2 = SafeParcelReader.s(parcel, B, TotpMultiFactorInfo.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzbd(arrayList, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzbd[i10];
    }
}
