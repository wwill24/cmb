package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.k;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new k();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final boolean f39387a;

    public zzr(@NonNull boolean z10) {
        this.f39387a = ((Boolean) p.k(Boolean.valueOf(z10))).booleanValue();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzr) && this.f39387a == ((zzr) obj).f39387a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(Boolean.valueOf(this.f39387a));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 1, this.f39387a);
        a.b(parcel, a10);
    }
}
