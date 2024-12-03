package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;
import fe.a;

public final class SignInCredential extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInCredential> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final String f38337a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38338b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38339c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38340d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri f38341e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38342f;

    /* renamed from: g  reason: collision with root package name */
    private final String f38343g;

    /* renamed from: h  reason: collision with root package name */
    private final String f38344h;

    /* renamed from: j  reason: collision with root package name */
    private final PublicKeyCredential f38345j;

    SignInCredential(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, PublicKeyCredential publicKeyCredential) {
        this.f38337a = p.g(str);
        this.f38338b = str2;
        this.f38339c = str3;
        this.f38340d = str4;
        this.f38341e = uri;
        this.f38342f = str5;
        this.f38343g = str6;
        this.f38344h = str7;
        this.f38345j = publicKeyCredential;
    }

    public String S() {
        return this.f38340d;
    }

    public String Y() {
        return this.f38339c;
    }

    public String c0() {
        return this.f38343g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        if (!n.b(this.f38337a, signInCredential.f38337a) || !n.b(this.f38338b, signInCredential.f38338b) || !n.b(this.f38339c, signInCredential.f38339c) || !n.b(this.f38340d, signInCredential.f38340d) || !n.b(this.f38341e, signInCredential.f38341e) || !n.b(this.f38342f, signInCredential.f38342f) || !n.b(this.f38343g, signInCredential.f38343g) || !n.b(this.f38344h, signInCredential.f38344h) || !n.b(this.f38345j, signInCredential.f38345j)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String f0() {
        return this.f38337a;
    }

    public String getDisplayName() {
        return this.f38338b;
    }

    public String getPhoneNumber() {
        return this.f38344h;
    }

    public int hashCode() {
        return n.c(this.f38337a, this.f38338b, this.f38339c, this.f38340d, this.f38341e, this.f38342f, this.f38343g, this.f38344h, this.f38345j);
    }

    public String i0() {
        return this.f38342f;
    }

    public Uri m0() {
        return this.f38341e;
    }

    public PublicKeyCredential q0() {
        return this.f38345j;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, f0(), false);
        a.C(parcel, 2, getDisplayName(), false);
        a.C(parcel, 3, Y(), false);
        a.C(parcel, 4, S(), false);
        a.A(parcel, 5, m0(), i10, false);
        a.C(parcel, 6, i0(), false);
        a.C(parcel, 7, c0(), false);
        a.C(parcel, 8, getPhoneNumber(), false);
        a.A(parcel, 9, q0(), i10, false);
        a.b(parcel, a10);
    }
}
