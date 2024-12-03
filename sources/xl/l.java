package xl;

import am.m;
import am.t;
import cm.b;
import cm.c;
import cm.f;
import cm.g;
import cm.h;
import java.util.ArrayList;
import java.util.List;
import zl.d;

public class l extends cm.a {

    /* renamed from: a  reason: collision with root package name */
    private final m f24741a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final List<CharSequence> f24742b = new ArrayList();

    public static class a extends b {
        public f a(h hVar, g gVar) {
            if (hVar.d() < d.f24828a || hVar.a() || (hVar.f().e() instanceof t)) {
                return f.c();
            }
            return f.d(new l()).a(hVar.c() + d.f24828a);
        }
    }

    public c c(h hVar) {
        if (hVar.d() >= d.f24828a) {
            return c.a(hVar.c() + d.f24828a);
        }
        if (hVar.a()) {
            return c.b(hVar.e());
        }
        return c.d();
    }

    public am.a e() {
        return this.f24741a;
    }

    public void f(CharSequence charSequence) {
        this.f24742b.add(charSequence);
    }

    public void g() {
        int size = this.f24742b.size() - 1;
        while (size >= 0 && d.f(this.f24742b.get(size))) {
            size--;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < size + 1; i10++) {
            sb2.append(this.f24742b.get(i10));
            sb2.append(10);
        }
        this.f24741a.o(sb2.toString());
    }
}
