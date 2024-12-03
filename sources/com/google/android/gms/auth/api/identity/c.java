package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        int i10 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 2:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    str4 = SafeParcelReader.o(parcel, B);
                    break;
                case 5:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new GetSignInIntentRequest(str, str2, str3, str4, z10, i10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new GetSignInIntentRequest[i10];
    }
}
