package xl;

import am.q;
import am.t;
import cm.a;
import cm.c;
import cm.h;

public class p extends a {

    /* renamed from: a  reason: collision with root package name */
    private final q f24775a = new q();

    /* renamed from: b  reason: collision with root package name */
    private int f24776b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24777c;

    public p(int i10) {
        this.f24776b = i10;
    }

    public boolean a() {
        return true;
    }

    public boolean b(am.a aVar) {
        if (!this.f24777c) {
            return true;
        }
        am.a m10 = this.f24775a.f();
        if (!(m10 instanceof am.p)) {
            return true;
        }
        ((am.p) m10).o(false);
        return true;
    }

    public c c(h hVar) {
        boolean z10;
        if (hVar.a()) {
            if (this.f24775a.c() == null) {
                return c.d();
            }
            am.a e10 = hVar.f().e();
            if ((e10 instanceof t) || (e10 instanceof q)) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f24777c = z10;
            return c.b(hVar.e());
        } else if (hVar.d() >= this.f24776b) {
            return c.a(hVar.c() + this.f24776b);
        } else {
            return c.d();
        }
    }

    public am.a e() {
        return this.f24775a;
    }
}
