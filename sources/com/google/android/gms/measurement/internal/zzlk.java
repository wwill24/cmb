package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzlk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlk> CREATOR = new q9();

    /* renamed from: a  reason: collision with root package name */
    public final int f40499a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40500b;

    /* renamed from: c  reason: collision with root package name */
    public final long f40501c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f40502d;

    /* renamed from: e  reason: collision with root package name */
    public final String f40503e;

    /* renamed from: f  reason: collision with root package name */
    public final String f40504f;

    /* renamed from: g  reason: collision with root package name */
    public final Double f40505g;

    zzlk(int i10, String str, long j10, Long l10, Float f10, String str2, String str3, Double d10) {
        this.f40499a = i10;
        this.f40500b = str;
        this.f40501c = j10;
        this.f40502d = l10;
        if (i10 == 1) {
            this.f40505g = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f40505g = d10;
        }
        this.f40503e = str2;
        this.f40504f = str3;
    }

    public final Object S() {
        Long l10 = this.f40502d;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f40505g;
        if (d10 != null) {
            return d10;
        }
        String str = this.f40503e;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        q9.a(this, parcel, i10);
    }

    zzlk(r9 r9Var) {
        this(r9Var.f40233c, r9Var.f40234d, r9Var.f40235e, r9Var.f40232b);
    }

    zzlk(String str, long j10, Object obj, String str2) {
        p.g(str);
        this.f40499a = 2;
        this.f40500b = str;
        this.f40501c = j10;
        this.f40504f = str2;
        if (obj == null) {
            this.f40502d = null;
            this.f40505g = null;
            this.f40503e = null;
        } else if (obj instanceof Long) {
            this.f40502d = (Long) obj;
            this.f40505g = null;
            this.f40503e = null;
        } else if (obj instanceof String) {
            this.f40502d = null;
            this.f40505g = null;
            this.f40503e = (String) obj;
        } else if (obj instanceof Double) {
            this.f40502d = null;
            this.f40505g = (Double) obj;
            this.f40503e = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
