package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class SleepClassifyEvent extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final int f39563a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39564b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39565c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39566d;

    /* renamed from: e  reason: collision with root package name */
    private final int f39567e;

    /* renamed from: f  reason: collision with root package name */
    private final int f39568f;

    /* renamed from: g  reason: collision with root package name */
    private final int f39569g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f39570h;

    /* renamed from: j  reason: collision with root package name */
    private final int f39571j;

    public SleepClassifyEvent(int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z10, int i17) {
        this.f39563a = i10;
        this.f39564b = i11;
        this.f39565c = i12;
        this.f39566d = i13;
        this.f39567e = i14;
        this.f39568f = i15;
        this.f39569g = i16;
        this.f39570h = z10;
        this.f39571j = i17;
    }

    public int S() {
        return this.f39564b;
    }

    public int Y() {
        return this.f39566d;
    }

    public int c0() {
        return this.f39565c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        if (this.f39563a == sleepClassifyEvent.f39563a && this.f39564b == sleepClassifyEvent.f39564b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f39563a), Integer.valueOf(this.f39564b));
    }

    @NonNull
    public String toString() {
        int i10 = this.f39563a;
        int i11 = this.f39564b;
        int i12 = this.f39565c;
        int i13 = this.f39566d;
        return i10 + " Conf:" + i11 + " Motion:" + i12 + " Light:" + i13;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        p.k(parcel);
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f39563a);
        a.s(parcel, 2, S());
        a.s(parcel, 3, c0());
        a.s(parcel, 4, Y());
        a.s(parcel, 5, this.f39567e);
        a.s(parcel, 6, this.f39568f);
        a.s(parcel, 7, this.f39569g);
        a.g(parcel, 8, this.f39570h);
        a.s(parcel, 9, this.f39571j);
        a.b(parcel, a10);
    }
}
