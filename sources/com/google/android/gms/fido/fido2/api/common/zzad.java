package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.c;

public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new c();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f39375a;

    public zzad(@NonNull String str) {
        this.f39375a = (String) p.k(str);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzad)) {
            return false;
        }
        return this.f39375a.equals(((zzad) obj).f39375a);
    }

    public final int hashCode() {
        return n.c(this.f39375a);
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 1, this.f39375a, false);
        a.b(parcel, a10);
    }
}
