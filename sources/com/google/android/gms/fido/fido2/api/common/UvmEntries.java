package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.HashSet;
import java.util.List;

public class UvmEntries extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<UvmEntries> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private final List f39370a;

    UvmEntries(List list) {
        this.f39370a = list;
    }

    public List<UvmEntry> S() {
        return this.f39370a;
    }

    public boolean equals(@NonNull Object obj) {
        List list;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        List list2 = this.f39370a;
        if ((list2 != null || uvmEntries.f39370a != null) && (list2 == null || (list = uvmEntries.f39370a) == null || !list2.containsAll(list) || !uvmEntries.f39370a.containsAll(this.f39370a))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(new HashSet(this.f39370a));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.G(parcel, 1, S(), false);
        a.b(parcel, a10);
    }
}
