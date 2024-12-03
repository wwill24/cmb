package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import se.a;

public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaa> CREATOR = new a();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final boolean f39374a;

    public zzaa(@NonNull boolean z10) {
        this.f39374a = ((Boolean) p.k(Boolean.valueOf(z10))).booleanValue();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzaa) && this.f39374a == ((zzaa) obj).f39374a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(Boolean.valueOf(this.f39374a));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.g(parcel, 1, this.f39374a);
        fe.a.b(parcel, a10);
    }
}
