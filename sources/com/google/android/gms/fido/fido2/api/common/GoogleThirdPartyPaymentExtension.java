package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.b;

public class GoogleThirdPartyPaymentExtension extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleThirdPartyPaymentExtension> CREATOR = new b();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final boolean f39304a;

    public GoogleThirdPartyPaymentExtension(boolean z10) {
        this.f39304a = z10;
    }

    public boolean S() {
        return this.f39304a;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof GoogleThirdPartyPaymentExtension) && this.f39304a == ((GoogleThirdPartyPaymentExtension) obj).S()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Boolean.valueOf(this.f39304a));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 1, S());
        a.b(parcel, a10);
    }
}
