package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.List;

public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f38317a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38318b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38319c;

    /* renamed from: d  reason: collision with root package name */
    private final List f38320d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38321e;

    /* renamed from: f  reason: collision with root package name */
    private final int f38322f;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private PendingIntent f38323a;

        /* renamed from: b  reason: collision with root package name */
        private String f38324b;

        /* renamed from: c  reason: collision with root package name */
        private String f38325c;

        /* renamed from: d  reason: collision with root package name */
        private List f38326d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private String f38327e;

        /* renamed from: f  reason: collision with root package name */
        private int f38328f;

        @NonNull
        public SaveAccountLinkingTokenRequest a() {
            boolean z10;
            boolean z11 = false;
            if (this.f38323a != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            p.b(z10, "Consent PendingIntent cannot be null");
            p.b("auth_code".equals(this.f38324b), "Invalid tokenType");
            p.b(!TextUtils.isEmpty(this.f38325c), "serviceId cannot be null or empty");
            if (this.f38326d != null) {
                z11 = true;
            }
            p.b(z11, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.f38323a, this.f38324b, this.f38325c, this.f38326d, this.f38327e, this.f38328f);
        }

        @NonNull
        public a b(@NonNull PendingIntent pendingIntent) {
            this.f38323a = pendingIntent;
            return this;
        }

        @NonNull
        public a c(@NonNull List<String> list) {
            this.f38326d = list;
            return this;
        }

        @NonNull
        public a d(@NonNull String str) {
            this.f38325c = str;
            return this;
        }

        @NonNull
        public a e(@NonNull String str) {
            this.f38324b = str;
            return this;
        }

        @NonNull
        public final a f(@NonNull String str) {
            this.f38327e = str;
            return this;
        }

        @NonNull
        public final a g(int i10) {
            this.f38328f = i10;
            return this;
        }
    }

    SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, List list, String str3, int i10) {
        this.f38317a = pendingIntent;
        this.f38318b = str;
        this.f38319c = str2;
        this.f38320d = list;
        this.f38321e = str3;
        this.f38322f = i10;
    }

    @NonNull
    public static a S() {
        return new a();
    }

    @NonNull
    public static a m0(@NonNull SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        p.k(saveAccountLinkingTokenRequest);
        a S = S();
        S.c(saveAccountLinkingTokenRequest.c0());
        S.d(saveAccountLinkingTokenRequest.f0());
        S.b(saveAccountLinkingTokenRequest.Y());
        S.e(saveAccountLinkingTokenRequest.i0());
        S.g(saveAccountLinkingTokenRequest.f38322f);
        String str = saveAccountLinkingTokenRequest.f38321e;
        if (!TextUtils.isEmpty(str)) {
            S.f(str);
        }
        return S;
    }

    @NonNull
    public PendingIntent Y() {
        return this.f38317a;
    }

    @NonNull
    public List<String> c0() {
        return this.f38320d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        if (this.f38320d.size() != saveAccountLinkingTokenRequest.f38320d.size() || !this.f38320d.containsAll(saveAccountLinkingTokenRequest.f38320d) || !n.b(this.f38317a, saveAccountLinkingTokenRequest.f38317a) || !n.b(this.f38318b, saveAccountLinkingTokenRequest.f38318b) || !n.b(this.f38319c, saveAccountLinkingTokenRequest.f38319c) || !n.b(this.f38321e, saveAccountLinkingTokenRequest.f38321e) || this.f38322f != saveAccountLinkingTokenRequest.f38322f) {
            return false;
        }
        return true;
    }

    @NonNull
    public String f0() {
        return this.f38319c;
    }

    public int hashCode() {
        return n.c(this.f38317a, this.f38318b, this.f38319c, this.f38320d, this.f38321e);
    }

    @NonNull
    public String i0() {
        return this.f38318b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.A(parcel, 1, Y(), i10, false);
        fe.a.C(parcel, 2, i0(), false);
        fe.a.C(parcel, 3, f0(), false);
        fe.a.E(parcel, 4, c0(), false);
        fe.a.C(parcel, 5, this.f38321e, false);
        fe.a.s(parcel, 6, this.f38322f);
        fe.a.b(parcel, a10);
    }
}
