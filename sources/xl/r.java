package xl;

import am.x;
import cm.b;
import cm.c;
import cm.f;
import cm.g;
import cm.h;

public class r extends cm.a {

    /* renamed from: a  reason: collision with root package name */
    private final x f24781a = new x();

    public static class a extends b {
        public f a(h hVar, g gVar) {
            if (hVar.d() >= 4) {
                return f.c();
            }
            int e10 = hVar.e();
            CharSequence b10 = hVar.b();
            if (!r.j(b10, e10)) {
                return f.c();
            }
            return f.d(new r()).b(b10.length());
        }
    }

    /* access modifiers changed from: private */
    public static boolean j(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (!(charAt == 9 || charAt == ' ')) {
                if (charAt == '*') {
                    i13++;
                } else if (charAt == '-') {
                    i11++;
                } else if (charAt != '_') {
                    return false;
                } else {
                    i12++;
                }
            }
            i10++;
        }
        if ((i11 >= 3 && i12 == 0 && i13 == 0) || ((i12 >= 3 && i11 == 0 && i13 == 0) || (i13 >= 3 && i11 == 0 && i12 == 0))) {
            return true;
        }
        return false;
    }

    public c c(h hVar) {
        return c.d();
    }

    public am.a e() {
        return this.f24781a;
    }
}
