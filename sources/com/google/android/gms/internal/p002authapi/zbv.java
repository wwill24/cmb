package com.google.android.gms.internal.p002authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.auth-api.zbv  reason: invalid package */
public final class zbv implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            if (SafeParcelReader.u(B) != 1) {
                SafeParcelReader.J(parcel, B);
            } else {
                credential = (Credential) SafeParcelReader.n(parcel, B, Credential.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zbu(credential);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zbu[i10];
    }
}
