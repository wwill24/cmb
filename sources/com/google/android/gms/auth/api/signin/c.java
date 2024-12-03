package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int K = SafeParcelReader.K(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList<Scope> arrayList = null;
        String str7 = null;
        String str8 = null;
        int i10 = 0;
        long j10 = 0;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel2, B);
                    break;
                case 2:
                    str = SafeParcelReader.o(parcel2, B);
                    break;
                case 3:
                    str2 = SafeParcelReader.o(parcel2, B);
                    break;
                case 4:
                    str3 = SafeParcelReader.o(parcel2, B);
                    break;
                case 5:
                    str4 = SafeParcelReader.o(parcel2, B);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.n(parcel2, B, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.o(parcel2, B);
                    break;
                case 8:
                    j10 = SafeParcelReader.F(parcel2, B);
                    break;
                case 9:
                    str6 = SafeParcelReader.o(parcel2, B);
                    break;
                case 10:
                    arrayList = SafeParcelReader.s(parcel2, B, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.o(parcel2, B);
                    break;
                case 12:
                    str8 = SafeParcelReader.o(parcel2, B);
                    break;
                default:
                    SafeParcelReader.J(parcel2, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel2, K);
        return new GoogleSignInAccount(i10, str, str2, str3, str4, uri, str5, j10, str6, arrayList, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInAccount[i10];
    }
}
