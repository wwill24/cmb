package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.HashSet;
import java.util.List;
import se.j;

public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new j();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final List f39386a;

    public zzp(@NonNull List list) {
        this.f39386a = (List) p.k(list);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzp)) {
            return false;
        }
        zzp zzp = (zzp) obj;
        if (!this.f39386a.containsAll(zzp.f39386a) || !zzp.f39386a.containsAll(this.f39386a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return n.c(new HashSet(this.f39386a));
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.G(parcel, 1, this.f39386a, false);
        a.b(parcel, a10);
    }
}
