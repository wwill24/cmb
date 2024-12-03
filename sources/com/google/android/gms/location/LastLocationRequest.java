package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import org.apache.commons.beanutils.PropertyUtils;
import org.checkerframework.dataflow.qual.Pure;

public final class LastLocationRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new q0();

    /* renamed from: a  reason: collision with root package name */
    private final long f39500a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39501b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39502c;

    /* renamed from: d  reason: collision with root package name */
    private final String f39503d;

    /* renamed from: e  reason: collision with root package name */
    private final zzd f39504e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private long f39505a = Long.MAX_VALUE;

        /* renamed from: b  reason: collision with root package name */
        private int f39506b = 0;

        /* renamed from: c  reason: collision with root package name */
        private boolean f39507c = false;

        /* renamed from: d  reason: collision with root package name */
        private String f39508d = null;

        /* renamed from: e  reason: collision with root package name */
        private zzd f39509e = null;

        @NonNull
        public LastLocationRequest a() {
            return new LastLocationRequest(this.f39505a, this.f39506b, this.f39507c, this.f39508d, this.f39509e);
        }
    }

    LastLocationRequest(long j10, int i10, boolean z10, String str, zzd zzd) {
        this.f39500a = j10;
        this.f39501b = i10;
        this.f39502c = z10;
        this.f39503d = str;
        this.f39504e = zzd;
    }

    @Pure
    public int S() {
        return this.f39501b;
    }

    @Pure
    public long Y() {
        return this.f39500a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        if (this.f39500a == lastLocationRequest.f39500a && this.f39501b == lastLocationRequest.f39501b && this.f39502c == lastLocationRequest.f39502c && n.b(this.f39503d, lastLocationRequest.f39503d) && n.b(this.f39504e, lastLocationRequest.f39504e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return n.c(Long.valueOf(this.f39500a), Integer.valueOf(this.f39501b), Boolean.valueOf(this.f39502c));
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LastLocationRequest[");
        if (this.f39500a != Long.MAX_VALUE) {
            sb2.append("maxAge=");
            zzdj.zzb(this.f39500a, sb2);
        }
        if (this.f39501b != 0) {
            sb2.append(", ");
            sb2.append(j0.b(this.f39501b));
        }
        if (this.f39502c) {
            sb2.append(", bypass");
        }
        if (this.f39503d != null) {
            sb2.append(", moduleId=");
            sb2.append(this.f39503d);
        }
        if (this.f39504e != null) {
            sb2.append(", impersonation=");
            sb2.append(this.f39504e);
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.v(parcel, 1, Y());
        fe.a.s(parcel, 2, S());
        fe.a.g(parcel, 3, this.f39502c);
        fe.a.C(parcel, 4, this.f39503d, false);
        fe.a.A(parcel, 5, this.f39504e, i10, false);
        fe.a.b(parcel, a10);
    }
}
