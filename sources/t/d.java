package t;

import a0.o;
import androidx.camera.core.o1;
import t.n;

final class d extends n.a {

    /* renamed from: a  reason: collision with root package name */
    private final o<o1> f17553a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17554b;

    d(o<o1> oVar, int i10) {
        if (oVar != null) {
            this.f17553a = oVar;
            this.f17554b = i10;
            return;
        }
        throw new NullPointerException("Null packet");
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f17554b;
    }

    /* access modifiers changed from: package-private */
    public o<o1> b() {
        return this.f17553a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n.a)) {
            return false;
        }
        n.a aVar = (n.a) obj;
        if (!this.f17553a.equals(aVar.b()) || this.f17554b != aVar.a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f17553a.hashCode() ^ 1000003) * 1000003) ^ this.f17554b;
    }

    public String toString() {
        return "In{packet=" + this.f17553a + ", jpegQuality=" + this.f17554b + "}";
    }
}
