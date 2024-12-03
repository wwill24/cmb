package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

@Deprecated
public final class CredentialRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f38243a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38244b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f38245c;

    /* renamed from: d  reason: collision with root package name */
    private final CredentialPickerConfig f38246d;

    /* renamed from: e  reason: collision with root package name */
    private final CredentialPickerConfig f38247e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f38248f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38249g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38250h;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f38251j;

    CredentialRequest(int i10, boolean z10, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z11, String str, String str2, boolean z12) {
        this.f38243a = i10;
        this.f38244b = z10;
        this.f38245c = (String[]) p.k(strArr);
        this.f38246d = credentialPickerConfig == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig;
        this.f38247e = credentialPickerConfig2 == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig2;
        if (i10 < 3) {
            this.f38248f = true;
            this.f38249g = null;
            this.f38250h = null;
        } else {
            this.f38248f = z11;
            this.f38249g = str;
            this.f38250h = str2;
        }
        this.f38251j = z12;
    }

    @NonNull
    public String[] S() {
        return this.f38245c;
    }

    @NonNull
    public CredentialPickerConfig Y() {
        return this.f38247e;
    }

    @NonNull
    public CredentialPickerConfig c0() {
        return this.f38246d;
    }

    public String f0() {
        return this.f38250h;
    }

    public String i0() {
        return this.f38249g;
    }

    public boolean m0() {
        return this.f38248f;
    }

    public boolean q0() {
        return this.f38244b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 1, q0());
        a.D(parcel, 2, S(), false);
        a.A(parcel, 3, c0(), i10, false);
        a.A(parcel, 4, Y(), i10, false);
        a.g(parcel, 5, m0());
        a.C(parcel, 6, i0(), false);
        a.C(parcel, 7, f0(), false);
        a.g(parcel, 8, this.f38251j);
        a.s(parcel, 1000, this.f38243a);
        a.b(parcel, a10);
    }
}
