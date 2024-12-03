package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzh implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        Status status = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.J(parcel, B);
            } else {
                status = (Status) SafeParcelReader.n(parcel, B, Status.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzg(status);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzg[i10];
    }
}
