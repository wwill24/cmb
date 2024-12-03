package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class e implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        ArrayList<Scope> arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2 = null;
        String str3 = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            switch (SafeParcelReader.u(B)) {
                case 1:
                    i10 = SafeParcelReader.D(parcel, B);
                    break;
                case 2:
                    arrayList = SafeParcelReader.s(parcel, B, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.n(parcel, B, Account.CREATOR);
                    break;
                case 4:
                    z10 = SafeParcelReader.v(parcel, B);
                    break;
                case 5:
                    z11 = SafeParcelReader.v(parcel, B);
                    break;
                case 6:
                    z12 = SafeParcelReader.v(parcel, B);
                    break;
                case 7:
                    str = SafeParcelReader.o(parcel, B);
                    break;
                case 8:
                    str2 = SafeParcelReader.o(parcel, B);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.s(parcel, B, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    str3 = SafeParcelReader.o(parcel, B);
                    break;
                default:
                    SafeParcelReader.J(parcel, B);
                    break;
            }
        }
        SafeParcelReader.t(parcel, K);
        return new GoogleSignInOptions(i10, (ArrayList) arrayList, account, z10, z11, z12, str, str2, (ArrayList) arrayList2, str3);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new GoogleSignInOptions[i10];
    }
}
