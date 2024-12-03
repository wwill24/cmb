package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f38179a;

    /* renamed from: b  reason: collision with root package name */
    int f38180b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    String f38181c;

    /* renamed from: d  reason: collision with root package name */
    Account f38182d;

    public AccountChangeEventsRequest() {
        this.f38179a = 1;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38179a);
        a.s(parcel, 2, this.f38180b);
        a.C(parcel, 3, this.f38181c, false);
        a.A(parcel, 4, this.f38182d, i10, false);
        a.b(parcel, a10);
    }

    AccountChangeEventsRequest(int i10, int i11, String str, Account account) {
        this.f38179a = i10;
        this.f38180b = i11;
        this.f38181c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f38182d = account;
        } else {
            this.f38182d = new Account(str, "com.google");
        }
    }
}
