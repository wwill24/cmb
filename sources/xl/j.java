package xl;

import am.i;
import cm.b;
import cm.c;
import cm.f;
import cm.g;
import cm.h;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import zl.d;

public class j extends cm.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f24734a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24735b;

    public static class a extends b {
        public f a(h hVar, g gVar) {
            CharSequence a10;
            if (hVar.d() >= d.f24828a) {
                return f.c();
            }
            CharSequence b10 = hVar.b();
            int e10 = hVar.e();
            j i10 = j.k(b10, e10);
            if (i10 != null) {
                return f.d(i10).b(b10.length());
            }
            int j10 = j.l(b10, e10);
            if (j10 <= 0 || (a10 = gVar.a()) == null) {
                return f.c();
            }
            return f.d(new j(j10, a10.toString())).b(b10.length()).e();
        }
    }

    public j(int i10, String str) {
        i iVar = new i();
        this.f24734a = iVar;
        iVar.o(i10);
        this.f24735b = str;
    }

    /* access modifiers changed from: private */
    public static j k(CharSequence charSequence, int i10) {
        int k10 = d.k('#', charSequence, i10, charSequence.length()) - i10;
        if (k10 == 0 || k10 > 6) {
            return null;
        }
        int i11 = i10 + k10;
        if (i11 >= charSequence.length()) {
            return new j(k10, "");
        }
        char charAt = charSequence.charAt(i11);
        if (charAt != ' ' && charAt != 9) {
            return null;
        }
        int n10 = d.n(charSequence, charSequence.length() - 1, i11);
        int l10 = d.l('#', charSequence, n10, i11);
        int n11 = d.n(charSequence, l10, i11);
        if (n11 != l10) {
            return new j(k10, charSequence.subSequence(i11, n11 + 1).toString());
        }
        return new j(k10, charSequence.subSequence(i11, n10 + 1).toString());
    }

    /* access modifiers changed from: private */
    public static int l(CharSequence charSequence, int i10) {
        char charAt = charSequence.charAt(i10);
        if (charAt != '-') {
            if (charAt != '=') {
                return 0;
            }
            if (m(charSequence, i10 + 1, SignatureVisitor.INSTANCEOF)) {
                return 1;
            }
        }
        if (m(charSequence, i10 + 1, SignatureVisitor.SUPER)) {
            return 2;
        }
        return 0;
    }

    private static boolean m(CharSequence charSequence, int i10, char c10) {
        if (d.m(charSequence, d.k(c10, charSequence, i10, charSequence.length()), charSequence.length()) >= charSequence.length()) {
            return true;
        }
        return false;
    }

    public c c(h hVar) {
        return c.d();
    }

    public am.a e() {
        return this.f24734a;
    }

    public void h(bm.a aVar) {
        aVar.a(this.f24735b, this.f24734a);
    }
}
