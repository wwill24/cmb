package t;

import a0.l;
import androidx.camera.core.o1;
import t.m;

final class c extends m.b {

    /* renamed from: a  reason: collision with root package name */
    private final l<o1> f17549a;

    /* renamed from: b  reason: collision with root package name */
    private final l<b0> f17550b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17551c;

    c(l<o1> lVar, l<b0> lVar2, int i10) {
        if (lVar != null) {
            this.f17549a = lVar;
            if (lVar2 != null) {
                this.f17550b = lVar2;
                this.f17551c = i10;
                return;
            }
            throw new NullPointerException("Null requestEdge");
        }
        throw new NullPointerException("Null imageEdge");
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f17551c;
    }

    /* access modifiers changed from: package-private */
    public l<o1> b() {
        return this.f17549a;
    }

    /* access modifiers changed from: package-private */
    public l<b0> c() {
        return this.f17550b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m.b)) {
            return false;
        }
        m.b bVar = (m.b) obj;
        if (!this.f17549a.equals(bVar.b()) || !this.f17550b.equals(bVar.c()) || this.f17551c != bVar.a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f17549a.hashCode() ^ 1000003) * 1000003) ^ this.f17550b.hashCode()) * 1000003) ^ this.f17551c;
    }

    public String toString() {
        return "Out{imageEdge=" + this.f17549a + ", requestEdge=" + this.f17550b + ", format=" + this.f17551c + "}";
    }
}
