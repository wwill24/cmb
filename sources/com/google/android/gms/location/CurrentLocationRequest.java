package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import me.t;
import org.apache.commons.beanutils.PropertyUtils;
import org.checkerframework.dataflow.qual.Pure;

public final class CurrentLocationRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new e0();

    /* renamed from: a  reason: collision with root package name */
    private final long f39472a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39473b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39474c;

    /* renamed from: d  reason: collision with root package name */
    private final long f39475d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39476e;

    /* renamed from: f  reason: collision with root package name */
    private final int f39477f;

    /* renamed from: g  reason: collision with root package name */
    private final String f39478g;

    /* renamed from: h  reason: collision with root package name */
    private final WorkSource f39479h;

    /* renamed from: j  reason: collision with root package name */
    private final zzd f39480j;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f39481a = DateUtils.MILLIS_IN_MINUTE;

        /* renamed from: b  reason: collision with root package name */
        private int f39482b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f39483c = 102;

        /* renamed from: d  reason: collision with root package name */
        private long f39484d = Long.MAX_VALUE;

        /* renamed from: e  reason: collision with root package name */
        private boolean f39485e = false;

        /* renamed from: f  reason: collision with root package name */
        private int f39486f = 0;

        /* renamed from: g  reason: collision with root package name */
        private String f39487g = null;

        /* renamed from: h  reason: collision with root package name */
        private WorkSource f39488h = null;

        /* renamed from: i  reason: collision with root package name */
        private zzd f39489i = null;

        @NonNull
        public CurrentLocationRequest a() {
            return new CurrentLocationRequest(this.f39481a, this.f39482b, this.f39483c, this.f39484d, this.f39485e, this.f39486f, this.f39487g, new WorkSource(this.f39488h), this.f39489i);
        }

        @NonNull
        public a b(int i10) {
            r.a(i10);
            this.f39483c = i10;
            return this;
        }
    }

    CurrentLocationRequest(long j10, int i10, int i11, long j11, boolean z10, int i12, String str, WorkSource workSource, zzd zzd) {
        boolean z11 = true;
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            z11 = false;
        }
        p.a(z11);
        this.f39472a = j10;
        this.f39473b = i10;
        this.f39474c = i11;
        this.f39475d = j11;
        this.f39476e = z10;
        this.f39477f = i12;
        this.f39478g = str;
        this.f39479h = workSource;
        this.f39480j = zzd;
    }

    @Pure
    public long S() {
        return this.f39475d;
    }

    @Pure
    public int Y() {
        return this.f39473b;
    }

    @Pure
    public long c0() {
        return this.f39472a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        if (this.f39472a == currentLocationRequest.f39472a && this.f39473b == currentLocationRequest.f39473b && this.f39474c == currentLocationRequest.f39474c && this.f39475d == currentLocationRequest.f39475d && this.f39476e == currentLocationRequest.f39476e && this.f39477f == currentLocationRequest.f39477f && n.b(this.f39478g, currentLocationRequest.f39478g) && n.b(this.f39479h, currentLocationRequest.f39479h) && n.b(this.f39480j, currentLocationRequest.f39480j)) {
            return true;
        }
        return false;
    }

    @NonNull
    @Pure
    public final WorkSource f0() {
        return this.f39479h;
    }

    @Pure
    public int getPriority() {
        return this.f39474c;
    }

    public int hashCode() {
        return n.c(Long.valueOf(this.f39472a), Integer.valueOf(this.f39473b), Integer.valueOf(this.f39474c), Long.valueOf(this.f39475d));
    }

    @Pure
    public final boolean i0() {
        return this.f39476e;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CurrentLocationRequest[");
        sb2.append(r.b(this.f39474c));
        if (this.f39472a != Long.MAX_VALUE) {
            sb2.append(", maxAge=");
            zzdj.zzb(this.f39472a, sb2);
        }
        if (this.f39475d != Long.MAX_VALUE) {
            sb2.append(", duration=");
            sb2.append(this.f39475d);
            sb2.append("ms");
        }
        if (this.f39473b != 0) {
            sb2.append(", ");
            sb2.append(j0.b(this.f39473b));
        }
        if (this.f39476e) {
            sb2.append(", bypass");
        }
        if (this.f39477f != 0) {
            sb2.append(", ");
            sb2.append(v.a(this.f39477f));
        }
        if (this.f39478g != null) {
            sb2.append(", moduleId=");
            sb2.append(this.f39478g);
        }
        if (!t.d(this.f39479h)) {
            sb2.append(", workSource=");
            sb2.append(this.f39479h);
        }
        if (this.f39480j != null) {
            sb2.append(", impersonation=");
            sb2.append(this.f39480j);
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.v(parcel, 1, c0());
        fe.a.s(parcel, 2, Y());
        fe.a.s(parcel, 3, getPriority());
        fe.a.v(parcel, 4, S());
        fe.a.g(parcel, 5, this.f39476e);
        fe.a.A(parcel, 6, this.f39479h, i10, false);
        fe.a.s(parcel, 7, this.f39477f);
        fe.a.C(parcel, 8, this.f39478g, false);
        fe.a.A(parcel, 9, this.f39480j, i10, false);
        fe.a.b(parcel, a10);
    }

    @Pure
    public final int zza() {
        return this.f39477f;
    }

    @Deprecated
    @Pure
    public final String zzd() {
        return this.f39478g;
    }
}
