package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInAccount> CREATOR = new g();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    String f38411a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f38412b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    String f38413c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f38412b = googleSignInAccount;
        this.f38411a = p.h(str, "8.3 and 8.4 SDKs require non-null email");
        this.f38413c = p.h(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount S() {
        return this.f38412b;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 4, this.f38411a, false);
        a.A(parcel, 7, this.f38412b, i10, false);
        a.C(parcel, 8, this.f38413c, false);
        a.b(parcel, a10);
    }
}
