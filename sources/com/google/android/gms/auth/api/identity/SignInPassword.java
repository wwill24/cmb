package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import yd.f;

public class SignInPassword extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInPassword> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final String f38346a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38347b;

    public SignInPassword(@NonNull String str, @NonNull String str2) {
        this.f38346a = p.h(((String) p.l(str, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.f38347b = p.g(str2);
    }

    @NonNull
    public String S() {
        return this.f38346a;
    }

    @NonNull
    public String Y() {
        return this.f38347b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) obj;
        if (!n.b(this.f38346a, signInPassword.f38346a) || !n.b(this.f38347b, signInPassword.f38347b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f38346a, this.f38347b);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, S(), false);
        a.C(parcel, 2, Y(), false);
        a.b(parcel, a10);
    }
}
