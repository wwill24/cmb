package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    final int f38497a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38498b;

    Scope(int i10, String str) {
        p.h(str, "scopeUri must not be null or empty");
        this.f38497a = i10;
        this.f38498b = str;
    }

    @NonNull
    public String S() {
        return this.f38498b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f38498b.equals(((Scope) obj).f38498b);
    }

    public int hashCode() {
        return this.f38498b.hashCode();
    }

    @NonNull
    public String toString() {
        return this.f38498b;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38497a);
        a.C(parcel, 2, S(), false);
        a.b(parcel, a10);
    }

    public Scope(@NonNull String str) {
        this(1, str);
    }
}
