package t;

import a0.l;
import android.util.Size;
import androidx.annotation.NonNull;
import t.m;

final class b extends m.a {

    /* renamed from: c  reason: collision with root package name */
    private final Size f17538c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17539d;

    /* renamed from: e  reason: collision with root package name */
    private final l<b0> f17540e;

    b(Size size, int i10, l<b0> lVar) {
        if (size != null) {
            this.f17538c = size;
            this.f17539d = i10;
            if (lVar != null) {
                this.f17540e = lVar;
                return;
            }
            throw new NullPointerException("Null requestEdge");
        }
        throw new NullPointerException("Null size");
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f17539d;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public l<b0> d() {
        return this.f17540e;
    }

    /* access modifiers changed from: package-private */
    public Size e() {
        return this.f17538c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m.a)) {
            return false;
        }
        m.a aVar = (m.a) obj;
        if (!this.f17538c.equals(aVar.e()) || this.f17539d != aVar.c() || !this.f17540e.equals(aVar.d())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f17538c.hashCode() ^ 1000003) * 1000003) ^ this.f17539d) * 1000003) ^ this.f17540e.hashCode();
    }

    public String toString() {
        return "In{size=" + this.f17538c + ", format=" + this.f17539d + ", requestEdge=" + this.f17540e + "}";
    }
}
