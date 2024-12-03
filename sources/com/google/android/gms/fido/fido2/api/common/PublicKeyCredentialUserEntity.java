package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Arrays;
import se.g;

public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialUserEntity> CREATOR = new g();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f39344a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f39345b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39346c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final String f39347d;

    public PublicKeyCredentialUserEntity(@NonNull byte[] bArr, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.f39344a = (byte[]) p.k(bArr);
        this.f39345b = (String) p.k(str);
        this.f39346c = str2;
        this.f39347d = (String) p.k(str3);
    }

    public String S() {
        return this.f39346c;
    }

    @NonNull
    public byte[] Y() {
        return this.f39344a;
    }

    @NonNull
    public String c0() {
        return this.f39345b;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        if (!Arrays.equals(this.f39344a, publicKeyCredentialUserEntity.f39344a) || !n.b(this.f39345b, publicKeyCredentialUserEntity.f39345b) || !n.b(this.f39346c, publicKeyCredentialUserEntity.f39346c) || !n.b(this.f39347d, publicKeyCredentialUserEntity.f39347d)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getDisplayName() {
        return this.f39347d;
    }

    public int hashCode() {
        return n.c(this.f39344a, this.f39345b, this.f39346c, this.f39347d);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.k(parcel, 2, Y(), false);
        a.C(parcel, 3, c0(), false);
        a.C(parcel, 4, S(), false);
        a.C(parcel, 5, getDisplayName(), false);
        a.b(parcel, a10);
    }
}
