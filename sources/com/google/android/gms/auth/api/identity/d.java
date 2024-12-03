package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 4:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 5:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                case 6:
                    arrayList = SafeParcelReader.q(parcel, B);
                    break;
                case 7:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new BeginSignInRequest.GoogleIdTokenRequestOptions(z10, str, str2, z11, str3, arrayList, z12);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new BeginSignInRequest.GoogleIdTokenRequestOptions[i10];
    }
}
