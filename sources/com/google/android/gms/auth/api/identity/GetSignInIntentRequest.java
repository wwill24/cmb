package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class GetSignInIntentRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final String f38305a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38306b;

    /* renamed from: c  reason: collision with root package name */
    private String f38307c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38308d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f38309e;

    /* renamed from: f  reason: collision with root package name */
    private final int f38310f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f38311a;

        /* renamed from: b  reason: collision with root package name */
        private String f38312b;

        /* renamed from: c  reason: collision with root package name */
        private String f38313c;

        /* renamed from: d  reason: collision with root package name */
        private String f38314d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f38315e;

        /* renamed from: f  reason: collision with root package name */
        private int f38316f;

        @NonNull
        public GetSignInIntentRequest a() {
            return new GetSignInIntentRequest(this.f38311a, this.f38312b, this.f38313c, this.f38314d, this.f38315e, this.f38316f);
        }

        @NonNull
        public a b(String str) {
            this.f38312b = str;
            return this;
        }

        @NonNull
        public a c(String str) {
            this.f38314d = str;
            return this;
        }

        @NonNull
        public a d(boolean z10) {
            this.f38315e = z10;
            return this;
        }

        @NonNull
        public a e(@NonNull String str) {
            p.k(str);
            this.f38311a = str;
            return this;
        }

        @NonNull
        public final a f(String str) {
            this.f38313c = str;
            return this;
        }

        @NonNull
        public final a g(int i10) {
            this.f38316f = i10;
            return this;
        }
    }

    GetSignInIntentRequest(String str, String str2, String str3, String str4, boolean z10, int i10) {
        p.k(str);
        this.f38305a = str;
        this.f38306b = str2;
        this.f38307c = str3;
        this.f38308d = str4;
        this.f38309e = z10;
        this.f38310f = i10;
    }

    @NonNull
    public static a S() {
        return new a();
    }

    @NonNull
    public static a m0(@NonNull GetSignInIntentRequest getSignInIntentRequest) {
        p.k(getSignInIntentRequest);
        a S = S();
        S.e(getSignInIntentRequest.f0());
        S.c(getSignInIntentRequest.c0());
        S.b(getSignInIntentRequest.Y());
        S.d(getSignInIntentRequest.f38309e);
        S.g(getSignInIntentRequest.f38310f);
        String str = getSignInIntentRequest.f38307c;
        if (str != null) {
            S.f(str);
        }
        return S;
    }

    public String Y() {
        return this.f38306b;
    }

    public String c0() {
        return this.f38308d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        if (!n.b(this.f38305a, getSignInIntentRequest.f38305a) || !n.b(this.f38308d, getSignInIntentRequest.f38308d) || !n.b(this.f38306b, getSignInIntentRequest.f38306b) || !n.b(Boolean.valueOf(this.f38309e), Boolean.valueOf(getSignInIntentRequest.f38309e)) || this.f38310f != getSignInIntentRequest.f38310f) {
            return false;
        }
        return true;
    }

    @NonNull
    public String f0() {
        return this.f38305a;
    }

    public int hashCode() {
        return n.c(this.f38305a, this.f38306b, this.f38308d, Boolean.valueOf(this.f38309e), Integer.valueOf(this.f38310f));
    }

    public boolean i0() {
        return this.f38309e;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.C(parcel, 1, f0(), false);
        fe.a.C(parcel, 2, Y(), false);
        fe.a.C(parcel, 3, this.f38307c, false);
        fe.a.C(parcel, 4, c0(), false);
        fe.a.g(parcel, 5, i0());
        fe.a.s(parcel, 6, this.f38310f);
        fe.a.b(parcel, a10);
    }
}
