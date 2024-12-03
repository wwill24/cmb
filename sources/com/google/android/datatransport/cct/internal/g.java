package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.k;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class g extends k {

    /* renamed from: a  reason: collision with root package name */
    private final long f38114a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38115b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientInfo f38116c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f38117d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38118e;

    /* renamed from: f  reason: collision with root package name */
    private final List<j> f38119f;

    /* renamed from: g  reason: collision with root package name */
    private final QosTier f38120g;

    static final class b extends k.a {

        /* renamed from: a  reason: collision with root package name */
        private Long f38121a;

        /* renamed from: b  reason: collision with root package name */
        private Long f38122b;

        /* renamed from: c  reason: collision with root package name */
        private ClientInfo f38123c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f38124d;

        /* renamed from: e  reason: collision with root package name */
        private String f38125e;

        /* renamed from: f  reason: collision with root package name */
        private List<j> f38126f;

        /* renamed from: g  reason: collision with root package name */
        private QosTier f38127g;

        b() {
        }

        public k a() {
            String str = "";
            if (this.f38121a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f38122b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.f38121a.longValue(), this.f38122b.longValue(), this.f38123c, this.f38124d, this.f38125e, this.f38126f, this.f38127g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public k.a b(ClientInfo clientInfo) {
            this.f38123c = clientInfo;
            return this;
        }

        public k.a c(List<j> list) {
            this.f38126f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public k.a d(Integer num) {
            this.f38124d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public k.a e(String str) {
            this.f38125e = str;
            return this;
        }

        public k.a f(QosTier qosTier) {
            this.f38127g = qosTier;
            return this;
        }

        public k.a g(long j10) {
            this.f38121a = Long.valueOf(j10);
            return this;
        }

        public k.a h(long j10) {
            this.f38122b = Long.valueOf(j10);
            return this;
        }
    }

    public ClientInfo b() {
        return this.f38116c;
    }

    @Encodable.Field(name = "logEvent")
    public List<j> c() {
        return this.f38119f;
    }

    public Integer d() {
        return this.f38117d;
    }

    public String e() {
        return this.f38118e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<j> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f38114a == kVar.g() && this.f38115b == kVar.h() && ((clientInfo = this.f38116c) != null ? clientInfo.equals(kVar.b()) : kVar.b() == null) && ((num = this.f38117d) != null ? num.equals(kVar.d()) : kVar.d() == null) && ((str = this.f38118e) != null ? str.equals(kVar.e()) : kVar.e() == null) && ((list = this.f38119f) != null ? list.equals(kVar.c()) : kVar.c() == null)) {
            QosTier qosTier = this.f38120g;
            if (qosTier == null) {
                if (kVar.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(kVar.f())) {
                return true;
            }
        }
        return false;
    }

    public QosTier f() {
        return this.f38120g;
    }

    public long g() {
        return this.f38114a;
    }

    public long h() {
        return this.f38115b;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        long j10 = this.f38114a;
        long j11 = this.f38115b;
        int i14 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        ClientInfo clientInfo = this.f38116c;
        int i15 = 0;
        if (clientInfo == null) {
            i10 = 0;
        } else {
            i10 = clientInfo.hashCode();
        }
        int i16 = (i14 ^ i10) * 1000003;
        Integer num = this.f38117d;
        if (num == null) {
            i11 = 0;
        } else {
            i11 = num.hashCode();
        }
        int i17 = (i16 ^ i11) * 1000003;
        String str = this.f38118e;
        if (str == null) {
            i12 = 0;
        } else {
            i12 = str.hashCode();
        }
        int i18 = (i17 ^ i12) * 1000003;
        List<j> list = this.f38119f;
        if (list == null) {
            i13 = 0;
        } else {
            i13 = list.hashCode();
        }
        int i19 = (i18 ^ i13) * 1000003;
        QosTier qosTier = this.f38120g;
        if (qosTier != null) {
            i15 = qosTier.hashCode();
        }
        return i19 ^ i15;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f38114a + ", requestUptimeMs=" + this.f38115b + ", clientInfo=" + this.f38116c + ", logSource=" + this.f38117d + ", logSourceName=" + this.f38118e + ", logEvents=" + this.f38119f + ", qosTier=" + this.f38120g + "}";
    }

    private g(long j10, long j11, ClientInfo clientInfo, Integer num, String str, List<j> list, QosTier qosTier) {
        this.f38114a = j10;
        this.f38115b = j11;
        this.f38116c = clientInfo;
        this.f38117d = num;
        this.f38118e = str;
        this.f38119f = list;
        this.f38120g = qosTier;
    }
}
