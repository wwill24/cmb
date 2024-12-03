package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class AuthenticationExtensions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AuthenticationExtensions> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    private final FidoAppIdExtension f39245a;

    /* renamed from: b  reason: collision with root package name */
    private final zzp f39246b;

    /* renamed from: c  reason: collision with root package name */
    private final UserVerificationMethodExtension f39247c;

    /* renamed from: d  reason: collision with root package name */
    private final zzw f39248d;

    /* renamed from: e  reason: collision with root package name */
    private final zzy f39249e;

    /* renamed from: f  reason: collision with root package name */
    private final zzaa f39250f;

    /* renamed from: g  reason: collision with root package name */
    private final zzr f39251g;

    /* renamed from: h  reason: collision with root package name */
    private final zzad f39252h;

    /* renamed from: j  reason: collision with root package name */
    private final GoogleThirdPartyPaymentExtension f39253j;

    AuthenticationExtensions(FidoAppIdExtension fidoAppIdExtension, zzp zzp, UserVerificationMethodExtension userVerificationMethodExtension, zzw zzw, zzy zzy, zzaa zzaa, zzr zzr, zzad zzad, GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension) {
        this.f39245a = fidoAppIdExtension;
        this.f39247c = userVerificationMethodExtension;
        this.f39246b = zzp;
        this.f39248d = zzw;
        this.f39249e = zzy;
        this.f39250f = zzaa;
        this.f39251g = zzr;
        this.f39252h = zzad;
        this.f39253j = googleThirdPartyPaymentExtension;
    }

    public FidoAppIdExtension S() {
        return this.f39245a;
    }

    public UserVerificationMethodExtension Y() {
        return this.f39247c;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticationExtensions)) {
            return false;
        }
        AuthenticationExtensions authenticationExtensions = (AuthenticationExtensions) obj;
        if (!n.b(this.f39245a, authenticationExtensions.f39245a) || !n.b(this.f39246b, authenticationExtensions.f39246b) || !n.b(this.f39247c, authenticationExtensions.f39247c) || !n.b(this.f39248d, authenticationExtensions.f39248d) || !n.b(this.f39249e, authenticationExtensions.f39249e) || !n.b(this.f39250f, authenticationExtensions.f39250f) || !n.b(this.f39251g, authenticationExtensions.f39251g) || !n.b(this.f39252h, authenticationExtensions.f39252h) || !n.b(this.f39253j, authenticationExtensions.f39253j)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39245a, this.f39246b, this.f39247c, this.f39248d, this.f39249e, this.f39250f, this.f39251g, this.f39252h, this.f39253j);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 2, S(), i10, false);
        a.A(parcel, 3, this.f39246b, i10, false);
        a.A(parcel, 4, Y(), i10, false);
        a.A(parcel, 5, this.f39248d, i10, false);
        a.A(parcel, 6, this.f39249e, i10, false);
        a.A(parcel, 7, this.f39250f, i10, false);
        a.A(parcel, 8, this.f39251g, i10, false);
        a.A(parcel, 9, this.f39252h, i10, false);
        a.A(parcel, 10, this.f39253j, i10, false);
        a.b(parcel, a10);
    }
}
