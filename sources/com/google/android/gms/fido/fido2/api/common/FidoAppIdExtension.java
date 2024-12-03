package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.l;

public class FidoAppIdExtension extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<FidoAppIdExtension> CREATOR = new l();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f39297a;

    public FidoAppIdExtension(@NonNull String str) {
        this.f39297a = (String) p.k(str);
    }

    @NonNull
    public String S() {
        return this.f39297a;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof FidoAppIdExtension)) {
            return false;
        }
        return this.f39297a.equals(((FidoAppIdExtension) obj).f39297a);
    }

    public int hashCode() {
        return n.c(this.f39297a);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, S(), false);
        a.b(parcel, a10);
    }
}
