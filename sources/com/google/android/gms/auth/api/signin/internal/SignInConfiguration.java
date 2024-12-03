package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import ce.a;
import ce.u;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new u();

    /* renamed from: a  reason: collision with root package name */
    private final String f38419a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInOptions f38420b;

    public SignInConfiguration(@NonNull String str, @NonNull GoogleSignInOptions googleSignInOptions) {
        this.f38419a = p.g(str);
        this.f38420b = googleSignInOptions;
    }

    @NonNull
    public final GoogleSignInOptions S() {
        return this.f38420b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f38419a.equals(signInConfiguration.f38419a)) {
            GoogleSignInOptions googleSignInOptions = this.f38420b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f38420b;
            if (googleSignInOptions == null) {
                if (googleSignInOptions2 == null) {
                    return true;
                }
            } else if (!googleSignInOptions.equals(googleSignInOptions2)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new a().a(this.f38419a).a(this.f38420b).b();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.C(parcel, 2, this.f38419a, false);
        fe.a.A(parcel, 5, this.f38420b, i10, false);
        fe.a.b(parcel, a10);
    }
}
