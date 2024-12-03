package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Iterator;

public final class zzas extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzas> CREATOR = new s();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f40490a;

    zzas(Bundle bundle) {
        this.f40490a = bundle;
    }

    public final Bundle Y() {
        return new Bundle(this.f40490a);
    }

    /* access modifiers changed from: package-private */
    public final Double c0(String str) {
        return Double.valueOf(this.f40490a.getDouble("value"));
    }

    /* access modifiers changed from: package-private */
    public final Long f0(String str) {
        return Long.valueOf(this.f40490a.getLong("value"));
    }

    /* access modifiers changed from: package-private */
    public final Object i0(String str) {
        return this.f40490a.get(str);
    }

    public final Iterator iterator() {
        return new r(this);
    }

    /* access modifiers changed from: package-private */
    public final String m0(String str) {
        return this.f40490a.getString(str);
    }

    public final String toString() {
        return this.f40490a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.j(parcel, 2, Y(), false);
        a.b(parcel, a10);
    }

    public final int zza() {
        return this.f40490a.size();
    }
}
