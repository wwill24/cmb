package ed;

import ed.i;
import java.util.Map;

final class b extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f40703a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f40704b;

    /* renamed from: c  reason: collision with root package name */
    private final h f40705c;

    /* renamed from: d  reason: collision with root package name */
    private final long f40706d;

    /* renamed from: e  reason: collision with root package name */
    private final long f40707e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f40708f;

    /* renamed from: ed.b$b  reason: collision with other inner class name */
    static final class C0490b extends i.a {

        /* renamed from: a  reason: collision with root package name */
        private String f40709a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f40710b;

        /* renamed from: c  reason: collision with root package name */
        private h f40711c;

        /* renamed from: d  reason: collision with root package name */
        private Long f40712d;

        /* renamed from: e  reason: collision with root package name */
        private Long f40713e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f40714f;

        C0490b() {
        }

        public i d() {
            String str = "";
            if (this.f40709a == null) {
                str = str + " transportName";
            }
            if (this.f40711c == null) {
                str = str + " encodedPayload";
            }
            if (this.f40712d == null) {
                str = str + " eventMillis";
            }
            if (this.f40713e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f40714f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f40709a, this.f40710b, this.f40711c, this.f40712d.longValue(), this.f40713e.longValue(), this.f40714f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: protected */
        public Map<String, String> e() {
            Map<String, String> map = this.f40714f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* access modifiers changed from: protected */
        public i.a f(Map<String, String> map) {
            if (map != null) {
                this.f40714f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        public i.a g(Integer num) {
            this.f40710b = num;
            return this;
        }

        public i.a h(h hVar) {
            if (hVar != null) {
                this.f40711c = hVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public i.a i(long j10) {
            this.f40712d = Long.valueOf(j10);
            return this;
        }

        public i.a j(String str) {
            if (str != null) {
                this.f40709a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public i.a k(long j10) {
            this.f40713e = Long.valueOf(j10);
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, String> c() {
        return this.f40708f;
    }

    public Integer d() {
        return this.f40704b;
    }

    public h e() {
        return this.f40705c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.f40703a.equals(iVar.j()) || ((num = this.f40704b) != null ? !num.equals(iVar.d()) : iVar.d() != null) || !this.f40705c.equals(iVar.e()) || this.f40706d != iVar.f() || this.f40707e != iVar.k() || !this.f40708f.equals(iVar.c())) {
            return false;
        }
        return true;
    }

    public long f() {
        return this.f40706d;
    }

    public int hashCode() {
        int i10;
        int hashCode = (this.f40703a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f40704b;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        long j10 = this.f40706d;
        long j11 = this.f40707e;
        return ((((((((hashCode ^ i10) * 1000003) ^ this.f40705c.hashCode()) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f40708f.hashCode();
    }

    public String j() {
        return this.f40703a;
    }

    public long k() {
        return this.f40707e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f40703a + ", code=" + this.f40704b + ", encodedPayload=" + this.f40705c + ", eventMillis=" + this.f40706d + ", uptimeMillis=" + this.f40707e + ", autoMetadata=" + this.f40708f + "}";
    }

    private b(String str, Integer num, h hVar, long j10, long j11, Map<String, String> map) {
        this.f40703a = str;
        this.f40704b = num;
        this.f40705c = hVar;
        this.f40706d = j10;
        this.f40707e = j11;
        this.f40708f = map;
    }
}
