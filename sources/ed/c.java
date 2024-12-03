package ed;

import cd.d;
import ed.o;

final class c extends o {

    /* renamed from: a  reason: collision with root package name */
    private final p f40715a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40716b;

    /* renamed from: c  reason: collision with root package name */
    private final cd.c<?> f40717c;

    /* renamed from: d  reason: collision with root package name */
    private final d<?, byte[]> f40718d;

    /* renamed from: e  reason: collision with root package name */
    private final cd.b f40719e;

    static final class b extends o.a {

        /* renamed from: a  reason: collision with root package name */
        private p f40720a;

        /* renamed from: b  reason: collision with root package name */
        private String f40721b;

        /* renamed from: c  reason: collision with root package name */
        private cd.c<?> f40722c;

        /* renamed from: d  reason: collision with root package name */
        private d<?, byte[]> f40723d;

        /* renamed from: e  reason: collision with root package name */
        private cd.b f40724e;

        b() {
        }

        public o a() {
            String str = "";
            if (this.f40720a == null) {
                str = str + " transportContext";
            }
            if (this.f40721b == null) {
                str = str + " transportName";
            }
            if (this.f40722c == null) {
                str = str + " event";
            }
            if (this.f40723d == null) {
                str = str + " transformer";
            }
            if (this.f40724e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new c(this.f40720a, this.f40721b, this.f40722c, this.f40723d, this.f40724e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public o.a b(cd.b bVar) {
            if (bVar != null) {
                this.f40724e = bVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        public o.a c(cd.c<?> cVar) {
            if (cVar != null) {
                this.f40722c = cVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public o.a d(d<?, byte[]> dVar) {
            if (dVar != null) {
                this.f40723d = dVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        public o.a e(p pVar) {
            if (pVar != null) {
                this.f40720a = pVar;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public o.a f(String str) {
            if (str != null) {
                this.f40721b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    public cd.b b() {
        return this.f40719e;
    }

    /* access modifiers changed from: package-private */
    public cd.c<?> c() {
        return this.f40717c;
    }

    /* access modifiers changed from: package-private */
    public d<?, byte[]> e() {
        return this.f40718d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.f40715a.equals(oVar.f()) || !this.f40716b.equals(oVar.g()) || !this.f40717c.equals(oVar.c()) || !this.f40718d.equals(oVar.e()) || !this.f40719e.equals(oVar.b())) {
            return false;
        }
        return true;
    }

    public p f() {
        return this.f40715a;
    }

    public String g() {
        return this.f40716b;
    }

    public int hashCode() {
        return ((((((((this.f40715a.hashCode() ^ 1000003) * 1000003) ^ this.f40716b.hashCode()) * 1000003) ^ this.f40717c.hashCode()) * 1000003) ^ this.f40718d.hashCode()) * 1000003) ^ this.f40719e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f40715a + ", transportName=" + this.f40716b + ", event=" + this.f40717c + ", transformer=" + this.f40718d + ", encoding=" + this.f40719e + "}";
    }

    private c(p pVar, String str, cd.c<?> cVar, d<?, byte[]> dVar, cd.b bVar) {
        this.f40715a = pVar;
        this.f40716b = str;
        this.f40717c = cVar;
        this.f40718d = dVar;
        this.f40719e = bVar;
    }
}
