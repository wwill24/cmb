package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.j;
import java.util.Arrays;

final class f extends j {

    /* renamed from: a  reason: collision with root package name */
    private final long f38100a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f38101b;

    /* renamed from: c  reason: collision with root package name */
    private final long f38102c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f38103d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38104e;

    /* renamed from: f  reason: collision with root package name */
    private final long f38105f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkConnectionInfo f38106g;

    static final class b extends j.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f38107a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f38108b;

        /* renamed from: c  reason: collision with root package name */
        private Long f38109c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f38110d;

        /* renamed from: e  reason: collision with root package name */
        private String f38111e;

        /* renamed from: f  reason: collision with root package name */
        private Long f38112f;

        /* renamed from: g  reason: collision with root package name */
        private NetworkConnectionInfo f38113g;

        b() {
        }

        public j a() {
            String str = "";
            if (this.f38107a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f38109c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f38112f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.f38107a.longValue(), this.f38108b, this.f38109c.longValue(), this.f38110d, this.f38111e, this.f38112f.longValue(), this.f38113g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public j.a b(Integer num) {
            this.f38108b = num;
            return this;
        }

        public j.a c(long j10) {
            this.f38107a = Long.valueOf(j10);
            return this;
        }

        public j.a d(long j10) {
            this.f38109c = Long.valueOf(j10);
            return this;
        }

        public j.a e(NetworkConnectionInfo networkConnectionInfo) {
            this.f38113g = networkConnectionInfo;
            return this;
        }

        /* access modifiers changed from: package-private */
        public j.a f(byte[] bArr) {
            this.f38110d = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public j.a g(String str) {
            this.f38111e = str;
            return this;
        }

        public j.a h(long j10) {
            this.f38112f = Long.valueOf(j10);
            return this;
        }
    }

    public Integer b() {
        return this.f38101b;
    }

    public long c() {
        return this.f38100a;
    }

    public long d() {
        return this.f38102c;
    }

    public NetworkConnectionInfo e() {
        return this.f38106g;
    }

    public boolean equals(Object obj) {
        Integer num;
        byte[] bArr;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f38100a == jVar.c() && ((num = this.f38101b) != null ? num.equals(jVar.b()) : jVar.b() == null) && this.f38102c == jVar.d()) {
            byte[] bArr2 = this.f38103d;
            if (jVar instanceof f) {
                bArr = ((f) jVar).f38103d;
            } else {
                bArr = jVar.f();
            }
            if (Arrays.equals(bArr2, bArr) && ((str = this.f38104e) != null ? str.equals(jVar.g()) : jVar.g() == null) && this.f38105f == jVar.h()) {
                NetworkConnectionInfo networkConnectionInfo = this.f38106g;
                if (networkConnectionInfo == null) {
                    if (jVar.e() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(jVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    public byte[] f() {
        return this.f38103d;
    }

    public String g() {
        return this.f38104e;
    }

    public long h() {
        return this.f38105f;
    }

    public int hashCode() {
        int i10;
        int i11;
        long j10 = this.f38100a;
        int i12 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f38101b;
        int i13 = 0;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        long j11 = this.f38102c;
        int hashCode = (((((i12 ^ i10) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f38103d)) * 1000003;
        String str = this.f38104e;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        long j12 = this.f38105f;
        int i14 = (((hashCode ^ i11) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f38106g;
        if (networkConnectionInfo != null) {
            i13 = networkConnectionInfo.hashCode();
        }
        return i14 ^ i13;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f38100a + ", eventCode=" + this.f38101b + ", eventUptimeMs=" + this.f38102c + ", sourceExtension=" + Arrays.toString(this.f38103d) + ", sourceExtensionJsonProto3=" + this.f38104e + ", timezoneOffsetSeconds=" + this.f38105f + ", networkConnectionInfo=" + this.f38106g + "}";
    }

    private f(long j10, Integer num, long j11, byte[] bArr, String str, long j12, NetworkConnectionInfo networkConnectionInfo) {
        this.f38100a = j10;
        this.f38101b = num;
        this.f38102c = j11;
        this.f38103d = bArr;
        this.f38104e = str;
        this.f38105f = j12;
        this.f38106g = networkConnectionInfo;
    }
}
