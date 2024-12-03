package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import fe.a;

public class BrowserPublicKeyCredentialRequestOptions extends BrowserRequestOptions {
    @NonNull
    public static final Parcelable.Creator<BrowserPublicKeyCredentialRequestOptions> CREATOR = new u();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final PublicKeyCredentialRequestOptions f39274a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Uri f39275b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39276c;

    BrowserPublicKeyCredentialRequestOptions(@NonNull PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions, @NonNull Uri uri, byte[] bArr) {
        this.f39274a = (PublicKeyCredentialRequestOptions) p.k(publicKeyCredentialRequestOptions);
        f0(uri);
        this.f39275b = uri;
        i0(bArr);
        this.f39276c = bArr;
    }

    private static Uri f0(Uri uri) {
        boolean z10;
        p.k(uri);
        boolean z11 = true;
        if (uri.getScheme() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.b(z10, "origin scheme must be non-empty");
        if (uri.getAuthority() == null) {
            z11 = false;
        }
        p.b(z11, "origin authority must be non-empty");
        return uri;
    }

    private static byte[] i0(byte[] bArr) {
        boolean z10 = true;
        if (!(bArr == null || bArr.length == 32)) {
            z10 = false;
        }
        p.b(z10, "clientDataHash must be 32 bytes long");
        return bArr;
    }

    @NonNull
    public byte[] S() {
        return this.f39276c;
    }

    @NonNull
    public Uri Y() {
        return this.f39275b;
    }

    @NonNull
    public PublicKeyCredentialRequestOptions c0() {
        return this.f39274a;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof BrowserPublicKeyCredentialRequestOptions)) {
            return false;
        }
        BrowserPublicKeyCredentialRequestOptions browserPublicKeyCredentialRequestOptions = (BrowserPublicKeyCredentialRequestOptions) obj;
        if (!n.b(this.f39274a, browserPublicKeyCredentialRequestOptions.f39274a) || !n.b(this.f39275b, browserPublicKeyCredentialRequestOptions.f39275b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39274a, this.f39275b);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 2, c0(), i10, false);
        a.A(parcel, 3, Y(), i10, false);
        a.k(parcel, 4, S(), false);
        a.b(parcel, a10);
    }
}
