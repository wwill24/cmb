package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import fe.a;

public class BrowserPublicKeyCredentialCreationOptions extends BrowserRequestOptions {
    @NonNull
    public static final Parcelable.Creator<BrowserPublicKeyCredentialCreationOptions> CREATOR = new t();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final PublicKeyCredentialCreationOptions f39271a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Uri f39272b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39273c;

    BrowserPublicKeyCredentialCreationOptions(@NonNull PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions, @NonNull Uri uri, byte[] bArr) {
        this.f39271a = (PublicKeyCredentialCreationOptions) p.k(publicKeyCredentialCreationOptions);
        f0(uri);
        this.f39272b = uri;
        i0(bArr);
        this.f39273c = bArr;
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
        return this.f39273c;
    }

    @NonNull
    public Uri Y() {
        return this.f39272b;
    }

    @NonNull
    public PublicKeyCredentialCreationOptions c0() {
        return this.f39271a;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof BrowserPublicKeyCredentialCreationOptions)) {
            return false;
        }
        BrowserPublicKeyCredentialCreationOptions browserPublicKeyCredentialCreationOptions = (BrowserPublicKeyCredentialCreationOptions) obj;
        if (!n.b(this.f39271a, browserPublicKeyCredentialCreationOptions.f39271a) || !n.b(this.f39272b, browserPublicKeyCredentialCreationOptions.f39272b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39271a, this.f39272b);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 2, c0(), i10, false);
        a.A(parcel, 3, Y(), i10, false);
        a.k(parcel, 4, S(), false);
        a.b(parcel, a10);
    }
}
