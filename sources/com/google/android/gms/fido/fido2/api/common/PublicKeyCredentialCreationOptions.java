package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import fe.a;
import java.util.Arrays;
import java.util.List;

public class PublicKeyCredentialCreationOptions extends RequestOptions {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new c();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final PublicKeyCredentialRpEntity f39313a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final PublicKeyCredentialUserEntity f39314b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39315c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final List f39316d;

    /* renamed from: e  reason: collision with root package name */
    private final Double f39317e;

    /* renamed from: f  reason: collision with root package name */
    private final List f39318f;

    /* renamed from: g  reason: collision with root package name */
    private final AuthenticatorSelectionCriteria f39319g;

    /* renamed from: h  reason: collision with root package name */
    private final Integer f39320h;

    /* renamed from: j  reason: collision with root package name */
    private final TokenBinding f39321j;

    /* renamed from: k  reason: collision with root package name */
    private final AttestationConveyancePreference f39322k;

    /* renamed from: l  reason: collision with root package name */
    private final AuthenticationExtensions f39323l;

    PublicKeyCredentialCreationOptions(@NonNull PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, @NonNull PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, @NonNull byte[] bArr, @NonNull List list, Double d10, List list2, AuthenticatorSelectionCriteria authenticatorSelectionCriteria, Integer num, TokenBinding tokenBinding, String str, AuthenticationExtensions authenticationExtensions) {
        this.f39313a = (PublicKeyCredentialRpEntity) p.k(publicKeyCredentialRpEntity);
        this.f39314b = (PublicKeyCredentialUserEntity) p.k(publicKeyCredentialUserEntity);
        this.f39315c = (byte[]) p.k(bArr);
        this.f39316d = (List) p.k(list);
        this.f39317e = d10;
        this.f39318f = list2;
        this.f39319g = authenticatorSelectionCriteria;
        this.f39320h = num;
        this.f39321j = tokenBinding;
        if (str != null) {
            try {
                this.f39322k = AttestationConveyancePreference.a(str);
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            this.f39322k = null;
        }
        this.f39323l = authenticationExtensions;
    }

    public Double B0() {
        return this.f39317e;
    }

    public TokenBinding E0() {
        return this.f39321j;
    }

    @NonNull
    public PublicKeyCredentialUserEntity H0() {
        return this.f39314b;
    }

    public String S() {
        AttestationConveyancePreference attestationConveyancePreference = this.f39322k;
        if (attestationConveyancePreference == null) {
            return null;
        }
        return attestationConveyancePreference.toString();
    }

    public AuthenticationExtensions Y() {
        return this.f39323l;
    }

    public AuthenticatorSelectionCriteria c0() {
        return this.f39319g;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        List list2;
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        if (!n.b(this.f39313a, publicKeyCredentialCreationOptions.f39313a) || !n.b(this.f39314b, publicKeyCredentialCreationOptions.f39314b) || !Arrays.equals(this.f39315c, publicKeyCredentialCreationOptions.f39315c) || !n.b(this.f39317e, publicKeyCredentialCreationOptions.f39317e) || !this.f39316d.containsAll(publicKeyCredentialCreationOptions.f39316d) || !publicKeyCredentialCreationOptions.f39316d.containsAll(this.f39316d) || ((((list = this.f39318f) != null || publicKeyCredentialCreationOptions.f39318f != null) && (list == null || (list2 = publicKeyCredentialCreationOptions.f39318f) == null || !list.containsAll(list2) || !publicKeyCredentialCreationOptions.f39318f.containsAll(this.f39318f))) || !n.b(this.f39319g, publicKeyCredentialCreationOptions.f39319g) || !n.b(this.f39320h, publicKeyCredentialCreationOptions.f39320h) || !n.b(this.f39321j, publicKeyCredentialCreationOptions.f39321j) || !n.b(this.f39322k, publicKeyCredentialCreationOptions.f39322k) || !n.b(this.f39323l, publicKeyCredentialCreationOptions.f39323l))) {
            return false;
        }
        return true;
    }

    @NonNull
    public byte[] f0() {
        return this.f39315c;
    }

    public int hashCode() {
        return n.c(this.f39313a, this.f39314b, Integer.valueOf(Arrays.hashCode(this.f39315c)), this.f39316d, this.f39317e, this.f39318f, this.f39319g, this.f39320h, this.f39321j, this.f39322k, this.f39323l);
    }

    public List<PublicKeyCredentialDescriptor> i0() {
        return this.f39318f;
    }

    @NonNull
    public List<PublicKeyCredentialParameters> m0() {
        return this.f39316d;
    }

    public Integer q0() {
        return this.f39320h;
    }

    @NonNull
    public PublicKeyCredentialRpEntity t0() {
        return this.f39313a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 2, t0(), i10, false);
        a.A(parcel, 3, H0(), i10, false);
        a.k(parcel, 4, f0(), false);
        a.G(parcel, 5, m0(), false);
        a.n(parcel, 6, B0(), false);
        a.G(parcel, 7, i0(), false);
        a.A(parcel, 8, c0(), i10, false);
        a.u(parcel, 9, q0(), false);
        a.A(parcel, 10, E0(), i10, false);
        a.C(parcel, 11, S(), false);
        a.A(parcel, 12, Y(), i10, false);
        a.b(parcel, a10);
    }
}
