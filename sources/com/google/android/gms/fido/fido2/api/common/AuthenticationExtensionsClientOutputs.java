package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class AuthenticationExtensionsClientOutputs extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AuthenticationExtensionsClientOutputs> CREATOR = new n();

    /* renamed from: a  reason: collision with root package name */
    private final UvmEntries f39254a;

    /* renamed from: b  reason: collision with root package name */
    private final zze f39255b;

    AuthenticationExtensionsClientOutputs(UvmEntries uvmEntries, zze zze) {
        this.f39254a = uvmEntries;
        this.f39255b = zze;
    }

    @NonNull
    public UvmEntries S() {
        return this.f39254a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensionsClientOutputs)) {
            return false;
        }
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = (AuthenticationExtensionsClientOutputs) obj;
        if (!n.b(this.f39254a, authenticationExtensionsClientOutputs.f39254a) || !n.b(this.f39255b, authenticationExtensionsClientOutputs.f39255b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39254a, this.f39255b);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, S(), i10, false);
        a.A(parcel, 2, this.f39255b, i10, false);
        a.b(parcel, a10);
    }
}
