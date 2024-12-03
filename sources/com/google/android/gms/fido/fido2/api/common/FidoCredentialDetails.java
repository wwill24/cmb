package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Arrays;

public class FidoCredentialDetails extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<FidoCredentialDetails> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final String f39298a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39299b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f39300c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f39301d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39302e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f39303f;

    FidoCredentialDetails(String str, String str2, byte[] bArr, @NonNull byte[] bArr2, boolean z10, boolean z11) {
        this.f39298a = str;
        this.f39299b = str2;
        this.f39300c = bArr;
        this.f39301d = bArr2;
        this.f39302e = z10;
        this.f39303f = z11;
    }

    @NonNull
    public byte[] S() {
        return this.f39301d;
    }

    public boolean Y() {
        return this.f39302e;
    }

    public boolean c0() {
        return this.f39303f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FidoCredentialDetails)) {
            return false;
        }
        FidoCredentialDetails fidoCredentialDetails = (FidoCredentialDetails) obj;
        if (!n.b(this.f39298a, fidoCredentialDetails.f39298a) || !n.b(this.f39299b, fidoCredentialDetails.f39299b) || !Arrays.equals(this.f39300c, fidoCredentialDetails.f39300c) || !Arrays.equals(this.f39301d, fidoCredentialDetails.f39301d) || this.f39302e != fidoCredentialDetails.f39302e || this.f39303f != fidoCredentialDetails.f39303f) {
            return false;
        }
        return true;
    }

    public String f0() {
        return this.f39299b;
    }

    public int hashCode() {
        return n.c(this.f39298a, this.f39299b, this.f39300c, this.f39301d, Boolean.valueOf(this.f39302e), Boolean.valueOf(this.f39303f));
    }

    public byte[] i0() {
        return this.f39300c;
    }

    public String m0() {
        return this.f39298a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, m0(), false);
        a.C(parcel, 2, f0(), false);
        a.k(parcel, 3, i0(), false);
        a.k(parcel, 4, S(), false);
        a.g(parcel, 5, Y());
        a.g(parcel, 6, c0());
        a.b(parcel, a10);
    }
}
