package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.n;

public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new n();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final long f39389a;

    public zzy(@NonNull long j10) {
        this.f39389a = ((Long) p.k(Long.valueOf(j10))).longValue();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzy) && this.f39389a == ((zzy) obj).f39389a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.n.c(Long.valueOf(this.f39389a));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.v(parcel, 1, this.f39389a);
        a.b(parcel, a10);
    }
}
