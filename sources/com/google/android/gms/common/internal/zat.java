package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new p0();

    /* renamed from: a  reason: collision with root package name */
    final int f39072a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f39073b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39074c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f39075d;

    zat(int i10, Account account, int i11, GoogleSignInAccount googleSignInAccount) {
        this.f39072a = i10;
        this.f39073b = account;
        this.f39074c = i11;
        this.f39075d = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39072a);
        a.A(parcel, 2, this.f39073b, i10, false);
        a.s(parcel, 3, this.f39074c);
        a.A(parcel, 4, this.f39075d, i10, false);
        a.b(parcel, a10);
    }

    public zat(Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i10, googleSignInAccount);
    }
}
