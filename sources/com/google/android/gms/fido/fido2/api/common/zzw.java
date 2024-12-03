package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import se.m;

public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new m();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final boolean f39388a;

    public zzw(@NonNull boolean z10) {
        this.f39388a = ((Boolean) p.k(Boolean.valueOf(z10))).booleanValue();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzw) && this.f39388a == ((zzw) obj).f39388a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(Boolean.valueOf(this.f39388a));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.g(parcel, 1, this.f39388a);
        a.b(parcel, a10);
    }
}
