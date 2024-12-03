package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class UvmEntry extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<UvmEntry> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private int f39371a;

    /* renamed from: b  reason: collision with root package name */
    private short f39372b;

    /* renamed from: c  reason: collision with root package name */
    private short f39373c;

    UvmEntry(int i10, short s10, short s11) {
        this.f39371a = i10;
        this.f39372b = s10;
        this.f39373c = s11;
    }

    public short S() {
        return this.f39372b;
    }

    public short Y() {
        return this.f39373c;
    }

    public int c0() {
        return this.f39371a;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof UvmEntry)) {
            return false;
        }
        UvmEntry uvmEntry = (UvmEntry) obj;
        if (this.f39371a == uvmEntry.f39371a && this.f39372b == uvmEntry.f39372b && this.f39373c == uvmEntry.f39373c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f39371a), Short.valueOf(this.f39372b), Short.valueOf(this.f39373c));
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, c0());
        a.B(parcel, 2, S());
        a.B(parcel, 3, Y());
        a.b(parcel, a10);
    }
}
