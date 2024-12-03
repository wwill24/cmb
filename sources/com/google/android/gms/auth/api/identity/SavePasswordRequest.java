package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SavePasswordRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final SignInPassword f38330a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38331b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38332c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private SignInPassword f38333a;

        /* renamed from: b  reason: collision with root package name */
        private String f38334b;

        /* renamed from: c  reason: collision with root package name */
        private int f38335c;

        @NonNull
        public SavePasswordRequest a() {
            return new SavePasswordRequest(this.f38333a, this.f38334b, this.f38335c);
        }

        @NonNull
        public a b(@NonNull SignInPassword signInPassword) {
            this.f38333a = signInPassword;
            return this;
        }

        @NonNull
        public final a c(@NonNull String str) {
            this.f38334b = str;
            return this;
        }

        @NonNull
        public final a d(int i10) {
            this.f38335c = i10;
            return this;
        }
    }

    SavePasswordRequest(SignInPassword signInPassword, String str, int i10) {
        this.f38330a = (SignInPassword) p.k(signInPassword);
        this.f38331b = str;
        this.f38332c = i10;
    }

    @NonNull
    public static a S() {
        return new a();
    }

    @NonNull
    public static a c0(@NonNull SavePasswordRequest savePasswordRequest) {
        p.k(savePasswordRequest);
        a S = S();
        S.b(savePasswordRequest.Y());
        S.d(savePasswordRequest.f38332c);
        String str = savePasswordRequest.f38331b;
        if (str != null) {
            S.c(str);
        }
        return S;
    }

    @NonNull
    public SignInPassword Y() {
        return this.f38330a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        if (!n.b(this.f38330a, savePasswordRequest.f38330a) || !n.b(this.f38331b, savePasswordRequest.f38331b) || this.f38332c != savePasswordRequest.f38332c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f38330a, this.f38331b);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.A(parcel, 1, Y(), i10, false);
        fe.a.C(parcel, 2, this.f38331b, false);
        fe.a.s(parcel, 3, this.f38332c);
        fe.a.b(parcel, a10);
    }
}
