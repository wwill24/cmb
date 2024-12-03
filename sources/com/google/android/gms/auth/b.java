package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int K = SafeParcelReader.K(parcel);
        String str = null;
        int i10 = 0;
        int i11 = 0;
        Account account = null;
        while (parcel.dataPosition() < K) {
            int B = SafeParcelReader.B(parcel);
            int u10 = SafeParcelReader.u(B);
            if (u10 == 1) {
                i10 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 2) {
                i11 = SafeParcelReader.D(parcel, B);
            } else if (u10 == 3) {
                str = SafeParcelReader.o(parcel, B);
            } else if (u10 != 4) {
                SafeParcelReader.J(parcel, B);
            } else {
                account = (Account) SafeParcelReader.n(parcel, B, Account.CREATOR);
            }
        }
        SafeParcelReader.t(parcel, K);
        return new AccountChangeEventsRequest(i10, i11, str, account);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AccountChangeEventsRequest[i10];
    }
}
