package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Arrays;

public class PublicKeyCredential extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredential> CREATOR = new d();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f39305a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f39306b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39307c;

    /* renamed from: d  reason: collision with root package name */
    private final AuthenticatorAttestationResponse f39308d;

    /* renamed from: e  reason: collision with root package name */
    private final AuthenticatorAssertionResponse f39309e;

    /* renamed from: f  reason: collision with root package name */
    private final AuthenticatorErrorResponse f39310f;

    /* renamed from: g  reason: collision with root package name */
    private final AuthenticationExtensionsClientOutputs f39311g;

    /* renamed from: h  reason: collision with root package name */
    private final String f39312h;

    PublicKeyCredential(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr, AuthenticatorAttestationResponse authenticatorAttestationResponse, AuthenticatorAssertionResponse authenticatorAssertionResponse, AuthenticatorErrorResponse authenticatorErrorResponse, AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, String str3) {
        boolean z10 = true;
        if (!((authenticatorAttestationResponse != null && authenticatorAssertionResponse == null && authenticatorErrorResponse == null) || ((authenticatorAttestationResponse == null && authenticatorAssertionResponse != null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse == null && authenticatorErrorResponse != null)))) {
            z10 = false;
        }
        p.a(z10);
        this.f39305a = str;
        this.f39306b = str2;
        this.f39307c = bArr;
        this.f39308d = authenticatorAttestationResponse;
        this.f39309e = authenticatorAssertionResponse;
        this.f39310f = authenticatorErrorResponse;
        this.f39311g = authenticationExtensionsClientOutputs;
        this.f39312h = str3;
    }

    public String S() {
        return this.f39312h;
    }

    public AuthenticationExtensionsClientOutputs Y() {
        return this.f39311g;
    }

    @NonNull
    public String c0() {
        return this.f39305a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredential)) {
            return false;
        }
        PublicKeyCredential publicKeyCredential = (PublicKeyCredential) obj;
        if (!n.b(this.f39305a, publicKeyCredential.f39305a) || !n.b(this.f39306b, publicKeyCredential.f39306b) || !Arrays.equals(this.f39307c, publicKeyCredential.f39307c) || !n.b(this.f39308d, publicKeyCredential.f39308d) || !n.b(this.f39309e, publicKeyCredential.f39309e) || !n.b(this.f39310f, publicKeyCredential.f39310f) || !n.b(this.f39311g, publicKeyCredential.f39311g) || !n.b(this.f39312h, publicKeyCredential.f39312h)) {
            return false;
        }
        return true;
    }

    @NonNull
    public byte[] f0() {
        return this.f39307c;
    }

    public int hashCode() {
        return n.c(this.f39305a, this.f39306b, this.f39307c, this.f39309e, this.f39308d, this.f39310f, this.f39311g, this.f39312h);
    }

    @NonNull
    public String i0() {
        return this.f39306b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, c0(), false);
        a.C(parcel, 2, i0(), false);
        a.k(parcel, 3, f0(), false);
        a.A(parcel, 4, this.f39308d, i10, false);
        a.A(parcel, 5, this.f39309e, i10, false);
        a.A(parcel, 6, this.f39310f, i10, false);
        a.A(parcel, 7, Y(), i10, false);
        a.C(parcel, 8, S(), false);
        a.b(parcel, a10);
    }
}
