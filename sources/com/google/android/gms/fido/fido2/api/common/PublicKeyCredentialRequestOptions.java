package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import fe.a;
import java.util.Arrays;
import java.util.List;

public class PublicKeyCredentialRequestOptions extends RequestOptions {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialRequestOptions> CREATOR = new e();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39330a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f39331b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f39332c;

    /* renamed from: d  reason: collision with root package name */
    private final List f39333d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f39334e;

    /* renamed from: f  reason: collision with root package name */
    private final TokenBinding f39335f;

    /* renamed from: g  reason: collision with root package name */
    private final zzat f39336g;

    /* renamed from: h  reason: collision with root package name */
    private final AuthenticationExtensions f39337h;

    /* renamed from: j  reason: collision with root package name */
    private final Long f39338j;

    PublicKeyCredentialRequestOptions(@NonNull byte[] bArr, Double d10, @NonNull String str, List list, Integer num, TokenBinding tokenBinding, String str2, AuthenticationExtensions authenticationExtensions, Long l10) {
        this.f39330a = (byte[]) p.k(bArr);
        this.f39331b = d10;
        this.f39332c = (String) p.k(str);
        this.f39333d = list;
        this.f39334e = num;
        this.f39335f = tokenBinding;
        this.f39338j = l10;
        if (str2 != null) {
            try {
                this.f39336g = zzat.a(str2);
            } catch (zzas e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            this.f39336g = null;
        }
        this.f39337h = authenticationExtensions;
    }

    public List<PublicKeyCredentialDescriptor> S() {
        return this.f39333d;
    }

    public AuthenticationExtensions Y() {
        return this.f39337h;
    }

    @NonNull
    public byte[] c0() {
        return this.f39330a;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialRequestOptions)) {
            return false;
        }
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) obj;
        if (!Arrays.equals(this.f39330a, publicKeyCredentialRequestOptions.f39330a) || !n.b(this.f39331b, publicKeyCredentialRequestOptions.f39331b) || !n.b(this.f39332c, publicKeyCredentialRequestOptions.f39332c) || ((((list = this.f39333d) != null || publicKeyCredentialRequestOptions.f39333d != null) && (list == null || (list2 = publicKeyCredentialRequestOptions.f39333d) == null || !list.containsAll(list2) || !publicKeyCredentialRequestOptions.f39333d.containsAll(this.f39333d))) || !n.b(this.f39334e, publicKeyCredentialRequestOptions.f39334e) || !n.b(this.f39335f, publicKeyCredentialRequestOptions.f39335f) || !n.b(this.f39336g, publicKeyCredentialRequestOptions.f39336g) || !n.b(this.f39337h, publicKeyCredentialRequestOptions.f39337h) || !n.b(this.f39338j, publicKeyCredentialRequestOptions.f39338j))) {
            return false;
        }
        return true;
    }

    public Integer f0() {
        return this.f39334e;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(Arrays.hashCode(this.f39330a)), this.f39331b, this.f39332c, this.f39333d, this.f39334e, this.f39335f, this.f39336g, this.f39337h, this.f39338j);
    }

    @NonNull
    public String i0() {
        return this.f39332c;
    }

    public Double m0() {
        return this.f39331b;
    }

    public TokenBinding q0() {
        return this.f39335f;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str;
        int a10 = a.a(parcel);
        a.k(parcel, 2, c0(), false);
        a.n(parcel, 3, m0(), false);
        a.C(parcel, 4, i0(), false);
        a.G(parcel, 5, S(), false);
        a.u(parcel, 6, f0(), false);
        a.A(parcel, 7, q0(), i10, false);
        zzat zzat = this.f39336g;
        if (zzat == null) {
            str = null;
        } else {
            str = zzat.toString();
        }
        a.C(parcel, 8, str, false);
        a.A(parcel, 9, Y(), i10, false);
        a.x(parcel, 10, this.f39338j, false);
        a.b(parcel, a10);
    }
}
