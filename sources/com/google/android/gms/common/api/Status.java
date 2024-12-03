package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public final class Status extends AbstractSafeParcelable implements j, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new t();
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public static final Status f38499f = new Status(-1);
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public static final Status f38500g = new Status(0);
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public static final Status f38501h = new Status(14);
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public static final Status f38502j = new Status(8);
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public static final Status f38503k = new Status(15);
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public static final Status f38504l = new Status(16);
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public static final Status f38505m = new Status(18);
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public static final Status f38506n = new Status(17);

    /* renamed from: a  reason: collision with root package name */
    final int f38507a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38508b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38509c;

    /* renamed from: d  reason: collision with root package name */
    private final PendingIntent f38510d;

    /* renamed from: e  reason: collision with root package name */
    private final ConnectionResult f38511e;

    public Status(int i10) {
        this(i10, (String) null);
    }

    Status(int i10, int i11, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f38507a = i10;
        this.f38508b = i11;
        this.f38509c = str;
        this.f38510d = pendingIntent;
        this.f38511e = connectionResult;
    }

    public ConnectionResult S() {
        return this.f38511e;
    }

    public int Y() {
        return this.f38508b;
    }

    public String c0() {
        return this.f38509c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f38507a != status.f38507a || this.f38508b != status.f38508b || !n.b(this.f38509c, status.f38509c) || !n.b(this.f38510d, status.f38510d) || !n.b(this.f38511e, status.f38511e)) {
            return false;
        }
        return true;
    }

    public boolean f0() {
        return this.f38510d != null;
    }

    @NonNull
    public Status getStatus() {
        return this;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f38507a), Integer.valueOf(this.f38508b), this.f38509c, this.f38510d, this.f38511e);
    }

    public boolean i0() {
        return this.f38508b <= 0;
    }

    @NonNull
    public String toString() {
        n.a d10 = n.d(this);
        d10.a("statusCode", zza());
        d10.a("resolution", this.f38510d);
        return d10.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, Y());
        a.C(parcel, 2, c0(), false);
        a.A(parcel, 3, this.f38510d, i10, false);
        a.A(parcel, 4, S(), i10, false);
        a.s(parcel, 1000, this.f38507a);
        a.b(parcel, a10);
    }

    @NonNull
    public final String zza() {
        String str = this.f38509c;
        return str != null ? str : b.a(this.f38508b);
    }

    public Status(int i10, String str) {
        this(1, i10, str, (PendingIntent) null, (ConnectionResult) null);
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this(1, i10, str, pendingIntent, (ConnectionResult) null);
    }

    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str) {
        this(connectionResult, str, 17);
    }

    @Deprecated
    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str, int i10) {
        this(1, i10, str, connectionResult.c0(), connectionResult);
    }
}
