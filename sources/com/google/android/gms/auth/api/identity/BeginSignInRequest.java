package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class BeginSignInRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final PasswordRequestOptions f38269a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleIdTokenRequestOptions f38270b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38271c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f38272d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38273e;

    /* renamed from: f  reason: collision with root package name */
    private final PasskeysRequestOptions f38274f;

    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new d();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f38275a;

        /* renamed from: b  reason: collision with root package name */
        private final String f38276b;

        /* renamed from: c  reason: collision with root package name */
        private final String f38277c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f38278d;

        /* renamed from: e  reason: collision with root package name */
        private final String f38279e;

        /* renamed from: f  reason: collision with root package name */
        private final List f38280f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f38281g;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f38282a = false;

            /* renamed from: b  reason: collision with root package name */
            private String f38283b = null;

            /* renamed from: c  reason: collision with root package name */
            private String f38284c = null;

            /* renamed from: d  reason: collision with root package name */
            private boolean f38285d = true;

            /* renamed from: e  reason: collision with root package name */
            private String f38286e = null;

            /* renamed from: f  reason: collision with root package name */
            private List f38287f = null;

            /* renamed from: g  reason: collision with root package name */
            private boolean f38288g = false;

            @NonNull
            public GoogleIdTokenRequestOptions a() {
                return new GoogleIdTokenRequestOptions(this.f38282a, this.f38283b, this.f38284c, this.f38285d, this.f38286e, this.f38287f, this.f38288g);
            }

            @NonNull
            public a b(boolean z10) {
                this.f38282a = z10;
                return this;
            }
        }

        GoogleIdTokenRequestOptions(boolean z10, String str, String str2, boolean z11, String str3, List list, boolean z12) {
            boolean z13 = true;
            if (z11 && z12) {
                z13 = false;
            }
            p.b(z13, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.f38275a = z10;
            if (z10) {
                p.l(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f38276b = str;
            this.f38277c = str2;
            this.f38278d = z11;
            Parcelable.Creator<BeginSignInRequest> creator = BeginSignInRequest.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.f38280f = arrayList;
            this.f38279e = str3;
            this.f38281g = z12;
        }

        @NonNull
        public static a S() {
            return new a();
        }

        public boolean Y() {
            return this.f38278d;
        }

        public List<String> c0() {
            return this.f38280f;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            if (this.f38275a != googleIdTokenRequestOptions.f38275a || !n.b(this.f38276b, googleIdTokenRequestOptions.f38276b) || !n.b(this.f38277c, googleIdTokenRequestOptions.f38277c) || this.f38278d != googleIdTokenRequestOptions.f38278d || !n.b(this.f38279e, googleIdTokenRequestOptions.f38279e) || !n.b(this.f38280f, googleIdTokenRequestOptions.f38280f) || this.f38281g != googleIdTokenRequestOptions.f38281g) {
                return false;
            }
            return true;
        }

        public String f0() {
            return this.f38279e;
        }

        public int hashCode() {
            return n.c(Boolean.valueOf(this.f38275a), this.f38276b, this.f38277c, Boolean.valueOf(this.f38278d), this.f38279e, this.f38280f, Boolean.valueOf(this.f38281g));
        }

        public String i0() {
            return this.f38277c;
        }

        public String m0() {
            return this.f38276b;
        }

        public boolean q0() {
            return this.f38275a;
        }

        public boolean t0() {
            return this.f38281g;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            int a10 = fe.a.a(parcel);
            fe.a.g(parcel, 1, q0());
            fe.a.C(parcel, 2, m0(), false);
            fe.a.C(parcel, 3, i0(), false);
            fe.a.g(parcel, 4, Y());
            fe.a.C(parcel, 5, f0(), false);
            fe.a.E(parcel, 6, c0(), false);
            fe.a.g(parcel, 7, t0());
            fe.a.b(parcel, a10);
        }
    }

    public static final class PasskeysRequestOptions extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<PasskeysRequestOptions> CREATOR = new e();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f38289a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f38290b;

        /* renamed from: c  reason: collision with root package name */
        private final String f38291c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f38292a = false;

            /* renamed from: b  reason: collision with root package name */
            private byte[] f38293b;

            /* renamed from: c  reason: collision with root package name */
            private String f38294c;

            @NonNull
            public PasskeysRequestOptions a() {
                return new PasskeysRequestOptions(this.f38292a, this.f38293b, this.f38294c);
            }

            @NonNull
            public a b(boolean z10) {
                this.f38292a = z10;
                return this;
            }
        }

        PasskeysRequestOptions(boolean z10, byte[] bArr, String str) {
            if (z10) {
                p.k(bArr);
                p.k(str);
            }
            this.f38289a = z10;
            this.f38290b = bArr;
            this.f38291c = str;
        }

        @NonNull
        public static a S() {
            return new a();
        }

        @NonNull
        public byte[] Y() {
            return this.f38290b;
        }

        @NonNull
        public String c0() {
            return this.f38291c;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PasskeysRequestOptions)) {
                return false;
            }
            PasskeysRequestOptions passkeysRequestOptions = (PasskeysRequestOptions) obj;
            if (this.f38289a != passkeysRequestOptions.f38289a || !Arrays.equals(this.f38290b, passkeysRequestOptions.f38290b) || ((str = this.f38291c) != (str2 = passkeysRequestOptions.f38291c) && (str == null || !str.equals(str2)))) {
                return false;
            }
            return true;
        }

        public boolean f0() {
            return this.f38289a;
        }

        public int hashCode() {
            return (Arrays.hashCode(new Object[]{Boolean.valueOf(this.f38289a), this.f38291c}) * 31) + Arrays.hashCode(this.f38290b);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            int a10 = fe.a.a(parcel);
            fe.a.g(parcel, 1, f0());
            fe.a.k(parcel, 2, Y(), false);
            fe.a.C(parcel, 3, c0(), false);
            fe.a.b(parcel, a10);
        }
    }

    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new f();

        /* renamed from: a  reason: collision with root package name */
        private final boolean f38295a;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f38296a = false;

            @NonNull
            public PasswordRequestOptions a() {
                return new PasswordRequestOptions(this.f38296a);
            }

            @NonNull
            public a b(boolean z10) {
                this.f38296a = z10;
                return this;
            }
        }

        PasswordRequestOptions(boolean z10) {
            this.f38295a = z10;
        }

        @NonNull
        public static a S() {
            return new a();
        }

        public boolean Y() {
            return this.f38295a;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof PasswordRequestOptions) && this.f38295a == ((PasswordRequestOptions) obj).f38295a) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return n.c(Boolean.valueOf(this.f38295a));
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            int a10 = fe.a.a(parcel);
            fe.a.g(parcel, 1, Y());
            fe.a.b(parcel, a10);
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private PasswordRequestOptions f38297a;

        /* renamed from: b  reason: collision with root package name */
        private GoogleIdTokenRequestOptions f38298b;

        /* renamed from: c  reason: collision with root package name */
        private PasskeysRequestOptions f38299c;

        /* renamed from: d  reason: collision with root package name */
        private String f38300d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f38301e;

        /* renamed from: f  reason: collision with root package name */
        private int f38302f;

        public a() {
            PasswordRequestOptions.a S = PasswordRequestOptions.S();
            S.b(false);
            this.f38297a = S.a();
            GoogleIdTokenRequestOptions.a S2 = GoogleIdTokenRequestOptions.S();
            S2.b(false);
            this.f38298b = S2.a();
            PasskeysRequestOptions.a S3 = PasskeysRequestOptions.S();
            S3.b(false);
            this.f38299c = S3.a();
        }

        @NonNull
        public BeginSignInRequest a() {
            return new BeginSignInRequest(this.f38297a, this.f38298b, this.f38300d, this.f38301e, this.f38302f, this.f38299c);
        }

        @NonNull
        public a b(boolean z10) {
            this.f38301e = z10;
            return this;
        }

        @NonNull
        public a c(@NonNull GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.f38298b = (GoogleIdTokenRequestOptions) p.k(googleIdTokenRequestOptions);
            return this;
        }

        @NonNull
        public a d(@NonNull PasskeysRequestOptions passkeysRequestOptions) {
            this.f38299c = (PasskeysRequestOptions) p.k(passkeysRequestOptions);
            return this;
        }

        @NonNull
        public a e(@NonNull PasswordRequestOptions passwordRequestOptions) {
            this.f38297a = (PasswordRequestOptions) p.k(passwordRequestOptions);
            return this;
        }

        @NonNull
        public final a f(@NonNull String str) {
            this.f38300d = str;
            return this;
        }

        @NonNull
        public final a g(int i10) {
            this.f38302f = i10;
            return this;
        }
    }

    BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, String str, boolean z10, int i10, PasskeysRequestOptions passkeysRequestOptions) {
        this.f38269a = (PasswordRequestOptions) p.k(passwordRequestOptions);
        this.f38270b = (GoogleIdTokenRequestOptions) p.k(googleIdTokenRequestOptions);
        this.f38271c = str;
        this.f38272d = z10;
        this.f38273e = i10;
        if (passkeysRequestOptions == null) {
            PasskeysRequestOptions.a S = PasskeysRequestOptions.S();
            S.b(false);
            passkeysRequestOptions = S.a();
        }
        this.f38274f = passkeysRequestOptions;
    }

    @NonNull
    public static a S() {
        return new a();
    }

    @NonNull
    public static a m0(@NonNull BeginSignInRequest beginSignInRequest) {
        p.k(beginSignInRequest);
        a S = S();
        S.c(beginSignInRequest.Y());
        S.e(beginSignInRequest.f0());
        S.d(beginSignInRequest.c0());
        S.b(beginSignInRequest.f38272d);
        S.g(beginSignInRequest.f38273e);
        String str = beginSignInRequest.f38271c;
        if (str != null) {
            S.f(str);
        }
        return S;
    }

    @NonNull
    public GoogleIdTokenRequestOptions Y() {
        return this.f38270b;
    }

    @NonNull
    public PasskeysRequestOptions c0() {
        return this.f38274f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        if (!n.b(this.f38269a, beginSignInRequest.f38269a) || !n.b(this.f38270b, beginSignInRequest.f38270b) || !n.b(this.f38274f, beginSignInRequest.f38274f) || !n.b(this.f38271c, beginSignInRequest.f38271c) || this.f38272d != beginSignInRequest.f38272d || this.f38273e != beginSignInRequest.f38273e) {
            return false;
        }
        return true;
    }

    @NonNull
    public PasswordRequestOptions f0() {
        return this.f38269a;
    }

    public int hashCode() {
        return n.c(this.f38269a, this.f38270b, this.f38274f, this.f38271c, Boolean.valueOf(this.f38272d));
    }

    public boolean i0() {
        return this.f38272d;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.A(parcel, 1, f0(), i10, false);
        fe.a.A(parcel, 2, Y(), i10, false);
        fe.a.C(parcel, 3, this.f38271c, false);
        fe.a.g(parcel, 4, i0());
        fe.a.s(parcel, 5, this.f38273e);
        fe.a.A(parcel, 6, c0(), i10, false);
        fe.a.b(parcel, a10);
    }
}
