package xl;

import am.b;
import cm.f;
import cm.g;
import cm.h;
import zl.d;

public class c extends cm.a {

    /* renamed from: a  reason: collision with root package name */
    private final b f24692a = new b();

    public static class a extends cm.b {
        public f a(h hVar, g gVar) {
            int e10 = hVar.e();
            if (!c.k(hVar, e10)) {
                return f.c();
            }
            int c10 = hVar.c() + hVar.d() + 1;
            if (d.i(hVar.b(), e10 + 1)) {
                c10++;
            }
            return f.d(new c()).a(c10);
        }
    }

    /* access modifiers changed from: private */
    public static boolean k(h hVar, int i10) {
        CharSequence b10 = hVar.b();
        if (hVar.d() >= d.f24828a || i10 >= b10.length() || b10.charAt(i10) != '>') {
            return false;
        }
        return true;
    }

    public boolean a() {
        return true;
    }

    public boolean b(am.a aVar) {
        return true;
    }

    public cm.c c(h hVar) {
        int e10 = hVar.e();
        if (!k(hVar, e10)) {
            return cm.c.d();
        }
        int c10 = hVar.c() + hVar.d() + 1;
        if (d.i(hVar.b(), e10 + 1)) {
            c10++;
        }
        return cm.c.a(c10);
    }

    /* renamed from: j */
    public b e() {
        return this.f24692a;
    }
}
