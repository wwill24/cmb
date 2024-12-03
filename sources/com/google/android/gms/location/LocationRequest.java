package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import com.google.firebase.sessions.settings.RemoteSettings;
import me.t;
import org.apache.commons.beanutils.PropertyUtils;
import org.checkerframework.dataflow.qual.Pure;

public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationRequest> CREATOR = new s0();

    /* renamed from: a  reason: collision with root package name */
    private int f39517a;

    /* renamed from: b  reason: collision with root package name */
    private long f39518b;

    /* renamed from: c  reason: collision with root package name */
    private long f39519c;

    /* renamed from: d  reason: collision with root package name */
    private long f39520d;

    /* renamed from: e  reason: collision with root package name */
    private long f39521e;

    /* renamed from: f  reason: collision with root package name */
    private int f39522f;

    /* renamed from: g  reason: collision with root package name */
    private float f39523g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f39524h;

    /* renamed from: j  reason: collision with root package name */
    private long f39525j;

    /* renamed from: k  reason: collision with root package name */
    private final int f39526k;

    /* renamed from: l  reason: collision with root package name */
    private final int f39527l;

    /* renamed from: m  reason: collision with root package name */
    private final String f39528m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f39529n;

    /* renamed from: p  reason: collision with root package name */
    private final WorkSource f39530p;

    /* renamed from: q  reason: collision with root package name */
    private final zzd f39531q;

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationRequest() {
        /*
            r23 = this;
            r0 = r23
            android.os.WorkSource r1 = new android.os.WorkSource
            r21 = r1
            r1.<init>()
            r1 = 102(0x66, float:1.43E-43)
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            r4 = 600000(0x927c0, double:2.964394E-318)
            r6 = 0
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 2147483647(0x7fffffff, float:NaN)
            r13 = 0
            r14 = 1
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r0.<init>(r1, r2, r4, r6, r8, r10, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.LocationRequest.<init>():void");
    }

    private static String A1(long j10) {
        return j10 == Long.MAX_VALUE ? "∞" : zzdj.zza(j10);
    }

    @NonNull
    @Deprecated
    public static LocationRequest S() {
        WorkSource workSource = r1;
        WorkSource workSource2 = new WorkSource();
        return new LocationRequest(102, DateUtils.MILLIS_IN_HOUR, AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED, 0, Long.MAX_VALUE, Long.MAX_VALUE, a.e.API_PRIORITY_OTHER, 0.0f, true, DateUtils.MILLIS_IN_HOUR, 0, 0, (String) null, false, workSource, (zzd) null);
    }

    @Pure
    public long B0() {
        return this.f39519c;
    }

    @Pure
    public boolean E0() {
        long j10 = this.f39520d;
        return j10 > 0 && (j10 >> 1) >= this.f39518b;
    }

    @Pure
    public boolean H0() {
        return this.f39517a == 105;
    }

    public boolean R0() {
        return this.f39524h;
    }

    @NonNull
    @Deprecated
    public LocationRequest W0(long j10) {
        boolean z10;
        if (j10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.c(z10, "illegal fastest interval: %d", Long.valueOf(j10));
        this.f39519c = j10;
        return this;
    }

    @Pure
    public long Y() {
        return this.f39521e;
    }

    @Pure
    public int c0() {
        return this.f39526k;
    }

    @NonNull
    @Deprecated
    public LocationRequest c1(long j10) {
        p.b(j10 >= 0, "intervalMillis must be greater than or equal to 0");
        long j11 = this.f39519c;
        long j12 = this.f39518b;
        if (j11 == j12 / 6) {
            this.f39519c = j10 / 6;
        }
        if (this.f39525j == j12) {
            this.f39525j = j10;
        }
        this.f39518b = j10;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest d1(int i10) {
        if (i10 > 0) {
            this.f39522f = i10;
            return this;
        }
        throw new IllegalArgumentException("invalid numUpdates: " + i10);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f39517a == locationRequest.f39517a && ((H0() || this.f39518b == locationRequest.f39518b) && this.f39519c == locationRequest.f39519c && E0() == locationRequest.E0() && ((!E0() || this.f39520d == locationRequest.f39520d) && this.f39521e == locationRequest.f39521e && this.f39522f == locationRequest.f39522f && this.f39523g == locationRequest.f39523g && this.f39524h == locationRequest.f39524h && this.f39526k == locationRequest.f39526k && this.f39527l == locationRequest.f39527l && this.f39529n == locationRequest.f39529n && this.f39530p.equals(locationRequest.f39530p) && n.b(this.f39528m, locationRequest.f39528m) && n.b(this.f39531q, locationRequest.f39531q)))) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Pure
    public long f0() {
        return this.f39518b;
    }

    @Pure
    public int getPriority() {
        return this.f39517a;
    }

    @NonNull
    @Deprecated
    public LocationRequest h1(int i10) {
        r.a(i10);
        this.f39517a = i10;
        return this;
    }

    public int hashCode() {
        return n.c(Integer.valueOf(this.f39517a), Long.valueOf(this.f39518b), Long.valueOf(this.f39519c), this.f39530p);
    }

    @Pure
    public long i0() {
        return this.f39525j;
    }

    @NonNull
    @Pure
    public final WorkSource i1() {
        return this.f39530p;
    }

    @Pure
    public final zzd j1() {
        return this.f39531q;
    }

    @Pure
    public long m0() {
        return this.f39520d;
    }

    @Pure
    public final boolean m1() {
        return this.f39529n;
    }

    @Pure
    public int q0() {
        return this.f39522f;
    }

    @Pure
    public float t0() {
        return this.f39523g;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        if (H0()) {
            sb2.append(r.b(this.f39517a));
        } else {
            sb2.append("@");
            if (E0()) {
                zzdj.zzb(this.f39518b, sb2);
                sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
                zzdj.zzb(this.f39520d, sb2);
            } else {
                zzdj.zzb(this.f39518b, sb2);
            }
            sb2.append(" ");
            sb2.append(r.b(this.f39517a));
        }
        if (H0() || this.f39519c != this.f39518b) {
            sb2.append(", minUpdateInterval=");
            sb2.append(A1(this.f39519c));
        }
        if (((double) this.f39523g) > 0.0d) {
            sb2.append(", minUpdateDistance=");
            sb2.append(this.f39523g);
        }
        if (!H0() ? this.f39525j != this.f39518b : this.f39525j != Long.MAX_VALUE) {
            sb2.append(", maxUpdateAge=");
            sb2.append(A1(this.f39525j));
        }
        if (this.f39521e != Long.MAX_VALUE) {
            sb2.append(", duration=");
            zzdj.zzb(this.f39521e, sb2);
        }
        if (this.f39522f != Integer.MAX_VALUE) {
            sb2.append(", maxUpdates=");
            sb2.append(this.f39522f);
        }
        if (this.f39527l != 0) {
            sb2.append(", ");
            sb2.append(v.a(this.f39527l));
        }
        if (this.f39526k != 0) {
            sb2.append(", ");
            sb2.append(j0.b(this.f39526k));
        }
        if (this.f39524h) {
            sb2.append(", waitForAccurateLocation");
        }
        if (this.f39529n) {
            sb2.append(", bypass");
        }
        if (this.f39528m != null) {
            sb2.append(", moduleId=");
            sb2.append(this.f39528m);
        }
        if (!t.d(this.f39530p)) {
            sb2.append(", ");
            sb2.append(this.f39530p);
        }
        if (this.f39531q != null) {
            sb2.append(", impersonation=");
            sb2.append(this.f39531q);
        }
        sb2.append(PropertyUtils.INDEXED_DELIM2);
        return sb2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.s(parcel, 1, getPriority());
        fe.a.v(parcel, 2, f0());
        fe.a.v(parcel, 3, B0());
        fe.a.s(parcel, 6, q0());
        fe.a.o(parcel, 7, t0());
        fe.a.v(parcel, 8, m0());
        fe.a.g(parcel, 9, R0());
        fe.a.v(parcel, 10, Y());
        fe.a.v(parcel, 11, i0());
        fe.a.s(parcel, 12, c0());
        fe.a.s(parcel, 13, this.f39527l);
        fe.a.C(parcel, 14, this.f39528m, false);
        fe.a.g(parcel, 15, this.f39529n);
        fe.a.A(parcel, 16, this.f39530p, i10, false);
        fe.a.A(parcel, 17, this.f39531q, i10, false);
        fe.a.b(parcel, a10);
    }

    @Pure
    public final int zza() {
        return this.f39527l;
    }

    @Deprecated
    @Pure
    public final String zzd() {
        return this.f39528m;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f39532a;

        /* renamed from: b  reason: collision with root package name */
        private long f39533b;

        /* renamed from: c  reason: collision with root package name */
        private long f39534c;

        /* renamed from: d  reason: collision with root package name */
        private long f39535d;

        /* renamed from: e  reason: collision with root package name */
        private long f39536e;

        /* renamed from: f  reason: collision with root package name */
        private int f39537f;

        /* renamed from: g  reason: collision with root package name */
        private float f39538g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f39539h;

        /* renamed from: i  reason: collision with root package name */
        private long f39540i;

        /* renamed from: j  reason: collision with root package name */
        private int f39541j;

        /* renamed from: k  reason: collision with root package name */
        private int f39542k;

        /* renamed from: l  reason: collision with root package name */
        private String f39543l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f39544m;

        /* renamed from: n  reason: collision with root package name */
        private WorkSource f39545n;

        /* renamed from: o  reason: collision with root package name */
        private zzd f39546o;

        public a(int i10, long j10) {
            p.b(j10 >= 0, "intervalMillis must be greater than or equal to 0");
            r.a(i10);
            this.f39532a = i10;
            this.f39533b = j10;
            this.f39534c = -1;
            this.f39535d = 0;
            this.f39536e = Long.MAX_VALUE;
            this.f39537f = a.e.API_PRIORITY_OTHER;
            this.f39538g = 0.0f;
            this.f39539h = true;
            this.f39540i = -1;
            this.f39541j = 0;
            this.f39542k = 0;
            this.f39543l = null;
            this.f39544m = false;
            this.f39545n = null;
            this.f39546o = null;
        }

        @NonNull
        public LocationRequest a() {
            long j10;
            int i10 = this.f39532a;
            long j11 = this.f39533b;
            long j12 = this.f39534c;
            if (j12 == -1) {
                j12 = j11;
            } else if (i10 != 105) {
                j12 = Math.min(j12, j11);
            }
            long max = Math.max(this.f39535d, this.f39533b);
            long j13 = this.f39536e;
            int i11 = this.f39537f;
            float f10 = this.f39538g;
            boolean z10 = this.f39539h;
            long j14 = this.f39540i;
            if (j14 == -1) {
                j10 = this.f39533b;
            } else {
                j10 = j14;
            }
            int i12 = this.f39541j;
            int i13 = this.f39542k;
            String str = this.f39543l;
            boolean z11 = this.f39544m;
            WorkSource workSource = r7;
            WorkSource workSource2 = new WorkSource(this.f39545n);
            return new LocationRequest(i10, j11, j12, max, Long.MAX_VALUE, j13, i11, f10, z10, j10, i12, i13, str, z11, workSource, this.f39546o);
        }

        @NonNull
        public a b(long j10) {
            p.b(j10 > 0, "durationMillis must be greater than 0");
            this.f39536e = j10;
            return this;
        }

        @NonNull
        public a c(int i10) {
            j0.a(i10);
            this.f39541j = i10;
            return this;
        }

        @NonNull
        public a d(long j10) {
            boolean z10 = true;
            if (j10 != -1 && j10 < 0) {
                z10 = false;
            }
            p.b(z10, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.f39540i = j10;
            return this;
        }

        @NonNull
        public a e(long j10) {
            boolean z10 = true;
            if (j10 != -1 && j10 < 0) {
                z10 = false;
            }
            p.b(z10, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.f39534c = j10;
            return this;
        }

        @NonNull
        public a f(boolean z10) {
            this.f39539h = z10;
            return this;
        }

        @NonNull
        public final a g(boolean z10) {
            this.f39544m = z10;
            return this;
        }

        @NonNull
        @Deprecated
        public final a h(String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.f39543l = str;
            }
            return this;
        }

        @NonNull
        public final a i(int i10) {
            boolean z10;
            int i11 = 2;
            if (i10 == 0 || i10 == 1) {
                i11 = i10;
            } else if (i10 == 2) {
                i10 = 2;
            } else {
                i11 = i10;
                z10 = false;
                p.c(z10, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i10));
                this.f39542k = i11;
                return this;
            }
            z10 = true;
            p.c(z10, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i10));
            this.f39542k = i11;
            return this;
        }

        @NonNull
        public final a j(WorkSource workSource) {
            this.f39545n = workSource;
            return this;
        }

        public a(@NonNull LocationRequest locationRequest) {
            this.f39532a = locationRequest.getPriority();
            this.f39533b = locationRequest.f0();
            this.f39534c = locationRequest.B0();
            this.f39535d = locationRequest.m0();
            this.f39536e = locationRequest.Y();
            this.f39537f = locationRequest.q0();
            this.f39538g = locationRequest.t0();
            this.f39539h = locationRequest.R0();
            this.f39540i = locationRequest.i0();
            this.f39541j = locationRequest.c0();
            this.f39542k = locationRequest.zza();
            this.f39543l = locationRequest.zzd();
            this.f39544m = locationRequest.m1();
            this.f39545n = locationRequest.i1();
            this.f39546o = locationRequest.j1();
        }
    }

    LocationRequest(int i10, long j10, long j11, long j12, long j13, long j14, int i11, float f10, boolean z10, long j15, int i12, int i13, String str, boolean z11, WorkSource workSource, zzd zzd) {
        long j16;
        this.f39517a = i10;
        long j17 = j10;
        this.f39518b = j17;
        this.f39519c = j11;
        this.f39520d = j12;
        if (j13 == Long.MAX_VALUE) {
            j16 = j14;
        } else {
            j16 = Math.min(Math.max(1, j13 - SystemClock.elapsedRealtime()), j14);
        }
        this.f39521e = j16;
        this.f39522f = i11;
        this.f39523g = f10;
        this.f39524h = z10;
        this.f39525j = j15 != -1 ? j15 : j17;
        this.f39526k = i12;
        this.f39527l = i13;
        this.f39528m = str;
        this.f39529n = z11;
        this.f39530p = workSource;
        this.f39531q = zzd;
    }
}
