package xl;

import am.g;
import cm.b;
import cm.c;
import cm.f;
import cm.h;
import zl.d;

public class i extends cm.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final g f24731a;

    /* renamed from: b  reason: collision with root package name */
    private String f24732b;

    /* renamed from: c  reason: collision with root package name */
    private StringBuilder f24733c = new StringBuilder();

    public static class a extends b {
        public f a(h hVar, cm.g gVar) {
            int d10 = hVar.d();
            if (d10 >= d.f24828a) {
                return f.c();
            }
            int e10 = hVar.e();
            i i10 = i.k(hVar.b(), e10, d10);
            if (i10 == null) {
                return f.c();
            }
            return f.d(i10).b(e10 + i10.f24731a.p());
        }
    }

    public i(char c10, int i10, int i11) {
        g gVar = new g();
        this.f24731a = gVar;
        gVar.s(c10);
        gVar.u(i10);
        gVar.t(i11);
    }

    /* access modifiers changed from: private */
    public static i k(CharSequence charSequence, int i10, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = i10; i14 < length; i14++) {
            char charAt = charSequence.charAt(i14);
            if (charAt == '`') {
                i12++;
            } else if (charAt != '~') {
                break;
            } else {
                i13++;
            }
        }
        if (i12 < 3 || i13 != 0) {
            if (i13 < 3 || i12 != 0) {
                return null;
            }
            return new i('~', i13, i11);
        } else if (d.b('`', charSequence, i10 + i12) != -1) {
            return null;
        } else {
            return new i('`', i12, i11);
        }
    }

    private boolean l(CharSequence charSequence, int i10) {
        char n10 = this.f24731a.n();
        int p10 = this.f24731a.p();
        int k10 = d.k(n10, charSequence, i10, charSequence.length()) - i10;
        if (k10 >= p10 && d.m(charSequence, i10 + k10, charSequence.length()) == charSequence.length()) {
            return true;
        }
        return false;
    }

    public c c(h hVar) {
        boolean z10;
        int e10 = hVar.e();
        int index = hVar.getIndex();
        CharSequence b10 = hVar.b();
        if (hVar.d() >= d.f24828a || !l(b10, e10)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return c.c();
        }
        int length = b10.length();
        for (int o10 = this.f24731a.o(); o10 > 0 && index < length && b10.charAt(index) == ' '; o10--) {
            index++;
        }
        return c.b(index);
    }

    public am.a e() {
        return this.f24731a;
    }

    public void f(CharSequence charSequence) {
        if (this.f24732b == null) {
            this.f24732b = charSequence.toString();
            return;
        }
        this.f24733c.append(charSequence);
        this.f24733c.append(10);
    }

    public void g() {
        this.f24731a.v(zl.a.e(this.f24732b.trim()));
        this.f24731a.w(this.f24733c.toString());
    }
}
