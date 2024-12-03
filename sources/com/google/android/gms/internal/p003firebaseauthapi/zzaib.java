package com.google.android.gms.internal.p003firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaib  reason: invalid package */
public final class zzaib implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            SafeParcelReader.u(B);
            SafeParcelReader.J(parcel, B);
        }
        SafeParcelReader.t(parcel, K);
        return new zzaia();
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzaia[i10];
    }
}
