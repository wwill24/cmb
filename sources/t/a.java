package t;

import a0.o;
import android.graphics.Bitmap;
import t.i;

final class a extends i.a {

    /* renamed from: a  reason: collision with root package name */
    private final o<Bitmap> f17528a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17529b;

    a(o<Bitmap> oVar, int i10) {
        if (oVar != null) {
            this.f17528a = oVar;
            this.f17529b = i10;
            return;
        }
        throw new NullPointerException("Null packet");
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f17529b;
    }

    /* access modifiers changed from: package-private */
    public o<Bitmap> b() {
        return this.f17528a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i.a)) {
            return false;
        }
        i.a aVar = (i.a) obj;
        if (!this.f17528a.equals(aVar.b()) || this.f17529b != aVar.a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f17528a.hashCode() ^ 1000003) * 1000003) ^ this.f17529b;
    }

    public String toString() {
        return "In{packet=" + this.f17528a + ", jpegQuality=" + this.f17529b + "}";
    }
}
