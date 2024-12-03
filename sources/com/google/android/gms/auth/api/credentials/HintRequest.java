package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<HintRequest> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f38252a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialPickerConfig f38253b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38254c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f38255d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f38256e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f38257f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38258g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38259h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f38260a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f38261b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f38262c;

        /* renamed from: d  reason: collision with root package name */
        private CredentialPickerConfig f38263d = new CredentialPickerConfig.a().a();

        /* renamed from: e  reason: collision with root package name */
        private boolean f38264e = false;

        /* renamed from: f  reason: collision with root package name */
        private String f38265f;

        /* renamed from: g  reason: collision with root package name */
        private String f38266g;

        @NonNull
        public HintRequest a() {
            if (this.f38262c == null) {
                this.f38262c = new String[0];
            }
            if (this.f38260a || this.f38261b || this.f38262c.length != 0) {
                return new HintRequest(2, this.f38263d, this.f38260a, this.f38261b, this.f38262c, this.f38264e, this.f38265f, this.f38266g);
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        @NonNull
        public a b(boolean z10) {
            this.f38261b = z10;
            return this;
        }
    }

    HintRequest(int i10, CredentialPickerConfig credentialPickerConfig, boolean z10, boolean z11, String[] strArr, boolean z12, String str, String str2) {
        this.f38252a = i10;
        this.f38253b = (CredentialPickerConfig) p.k(credentialPickerConfig);
        this.f38254c = z10;
        this.f38255d = z11;
        this.f38256e = (String[]) p.k(strArr);
        if (i10 < 2) {
            this.f38257f = true;
            this.f38258g = null;
            this.f38259h = null;
            return;
        }
        this.f38257f = z12;
        this.f38258g = str;
        this.f38259h = str2;
    }

    @NonNull
    public String[] S() {
        return this.f38256e;
    }

    @NonNull
    public CredentialPickerConfig Y() {
        return this.f38253b;
    }

    public String c0() {
        return this.f38259h;
    }

    public String f0() {
        return this.f38258g;
    }

    public boolean i0() {
        return this.f38254c;
    }

    public boolean m0() {
        return this.f38257f;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.A(parcel, 1, Y(), i10, false);
        fe.a.g(parcel, 2, i0());
        fe.a.g(parcel, 3, this.f38255d);
        fe.a.D(parcel, 4, S(), false);
        fe.a.g(parcel, 5, m0());
        fe.a.C(parcel, 6, f0(), false);
        fe.a.C(parcel, 7, c0(), false);
        fe.a.s(parcel, 1000, this.f38252a);
        fe.a.b(parcel, a10);
    }
}
