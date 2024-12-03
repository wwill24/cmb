package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;
import fe.a;
import se.e;

public class PublicKeyCredentialParameters extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialParameters> CREATOR = new e();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final PublicKeyCredentialType f39328a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final COSEAlgorithmIdentifier f39329b;

    public PublicKeyCredentialParameters(@NonNull String str, int i10) {
        p.k(str);
        try {
            this.f39328a = PublicKeyCredentialType.a(str);
            p.k(Integer.valueOf(i10));
            try {
                this.f39329b = COSEAlgorithmIdentifier.a(i10);
            } catch (COSEAlgorithmIdentifier.UnsupportedAlgorithmIdentifierException e10) {
                throw new IllegalArgumentException(e10);
            }
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public int S() {
        return this.f39329b.c();
    }

    @NonNull
    public String Y() {
        return this.f39328a.toString();
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof PublicKeyCredentialParameters)) {
            return false;
        }
        PublicKeyCredentialParameters publicKeyCredentialParameters = (PublicKeyCredentialParameters) obj;
        if (!this.f39328a.equals(publicKeyCredentialParameters.f39328a) || !this.f39329b.equals(publicKeyCredentialParameters.f39329b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39328a, this.f39329b);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, Y(), false);
        a.u(parcel, 3, Integer.valueOf(S()), false);
        a.b(parcel, a10);
    }
}
