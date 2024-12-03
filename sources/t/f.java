package t;

import a0.l;
import t.a0;

final class f extends a0.a {

    /* renamed from: a  reason: collision with root package name */
    private final l<a0.b> f17563a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17564b;

    f(l<a0.b> lVar, int i10) {
        if (lVar != null) {
            this.f17563a = lVar;
            this.f17564b = i10;
            return;
        }
        throw new NullPointerException("Null edge");
    }

    /* access modifiers changed from: package-private */
    public l<a0.b> a() {
        return this.f17563a;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f17564b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0.a)) {
            return false;
        }
        a0.a aVar = (a0.a) obj;
        if (!this.f17563a.equals(aVar.a()) || this.f17564b != aVar.b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f17563a.hashCode() ^ 1000003) * 1000003) ^ this.f17564b;
    }

    public String toString() {
        return "In{edge=" + this.f17563a + ", format=" + this.f17564b + "}";
    }
}
