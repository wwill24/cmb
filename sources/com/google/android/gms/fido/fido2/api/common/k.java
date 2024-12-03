package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class k implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        ArrayList<UvmEntry> arrayList = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.J(parcel, B);
            } else {
                arrayList = SafeParcelReader.s(parcel, B, UvmEntry.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new UvmEntries(arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new UvmEntries[i10];
    }
}
