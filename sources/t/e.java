package t;

import a0.o;
import androidx.annotation.NonNull;
import androidx.camera.core.h1;
import t.r;

final class e extends r.a {

    /* renamed from: a  reason: collision with root package name */
    private final o<byte[]> f17560a;

    /* renamed from: b  reason: collision with root package name */
    private final h1.o f17561b;

    e(o<byte[]> oVar, h1.o oVar2) {
        if (oVar != null) {
            this.f17560a = oVar;
            if (oVar2 != null) {
                this.f17561b = oVar2;
                return;
            }
            throw new NullPointerException("Null outputFileOptions");
        }
        throw new NullPointerException("Null packet");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public h1.o a() {
        return this.f17561b;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public o<byte[]> b() {
        return this.f17560a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r.a)) {
            return false;
        }
        r.a aVar = (r.a) obj;
        if (!this.f17560a.equals(aVar.b()) || !this.f17561b.equals(aVar.a())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f17560a.hashCode() ^ 1000003) * 1000003) ^ this.f17561b.hashCode();
    }

    public String toString() {
        return "In{packet=" + this.f17560a + ", outputFileOptions=" + this.f17561b + "}";
    }
}
