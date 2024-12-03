package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.f;

public class PublicKeyCredentialRpEntity extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialRpEntity> CREATOR = new f();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f39339a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f39340b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39341c;

    public PublicKeyCredentialRpEntity(@NonNull String str, @NonNull String str2, String str3) {
        this.f39339a = (String) p.k(str);
        this.f39340b = (String) p.k(str2);
        this.f39341c = str3;
    }

    public String S() {
        return this.f39341c;
    }

    @NonNull
    public String Y() {
        return this.f39339a;
    }

    @NonNull
    public String c0() {
        return this.f39340b;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof PublicKeyCredentialRpEntity)) {
            return false;
        }
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) obj;
        if (!n.b(this.f39339a, publicKeyCredentialRpEntity.f39339a) || !n.b(this.f39340b, publicKeyCredentialRpEntity.f39340b) || !n.b(this.f39341c, publicKeyCredentialRpEntity.f39341c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39339a, this.f39340b, this.f39341c);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, Y(), false);
        a.C(parcel, 3, c0(), false);
        a.C(parcel, 4, S(), false);
        a.b(parcel, a10);
    }
}
