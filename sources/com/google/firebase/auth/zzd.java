package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthProvider;

public final class zzd implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            SafeParcelReader.u(B);
            SafeParcelReader.J(parcel, B);
        }
        SafeParcelReader.t(parcel, K);
        return new PhoneAuthProvider.ForceResendingToken();
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new PhoneAuthProvider.ForceResendingToken[i10];
    }
}
