package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import com.google.android.gms.internal.fido.zzap;
import com.google.android.gms.internal.fido.zzaq;
import fe.a;

public class AuthenticatorErrorResponse extends AuthenticatorResponse {
    @NonNull
    public static final Parcelable.Creator<AuthenticatorErrorResponse> CREATOR = new r();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ErrorCode f39265a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39266b;

    AuthenticatorErrorResponse(@NonNull int i10, String str) {
        try {
            this.f39265a = ErrorCode.c(i10);
            this.f39266b = str;
        } catch (ErrorCode.UnsupportedErrorCodeException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public int S() {
        return this.f39265a.a();
    }

    public String Y() {
        return this.f39266b;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorErrorResponse)) {
            return false;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) obj;
        if (!n.b(this.f39265a, authenticatorErrorResponse.f39265a) || !n.b(this.f39266b, authenticatorErrorResponse.f39266b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39265a, this.f39266b);
    }

    @NonNull
    public String toString() {
        zzap zza = zzaq.zza(this);
        zza.zza("errorCode", this.f39265a.a());
        String str = this.f39266b;
        if (str != null) {
            zza.zzb("errorMessage", str);
        }
        return zza.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 2, S());
        a.C(parcel, 3, Y(), false);
        a.b(parcel, a10);
    }
}
