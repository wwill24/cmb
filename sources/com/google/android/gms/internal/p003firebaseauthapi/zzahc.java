package com.google.android.gms.internal.p003firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahc  reason: invalid package */
public final class zzahc implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        String str2 = null;
        Long l10 = null;
        String str3 = null;
        Long l11 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 2) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 == 3) {
                str2 = SafeParcelReader.o(parcel, B);
            } else if (u10 == 4) {
                l10 = SafeParcelReader.G(parcel, B);
            } else if (u10 == 5) {
                str3 = SafeParcelReader.o(parcel, B);
            } else if (u10 != 6) {
                SafeParcelReader.J(parcel, B);
            } else {
                l11 = SafeParcelReader.G(parcel, B);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new zzahb(str, str2, l10, str3, l11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzahb[i10];
    }
}
