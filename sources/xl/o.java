package xl;

import am.p;
import am.q;
import am.s;
import cm.d;
import cm.f;
import cm.g;
import cm.h;

public class o extends cm.a {

    /* renamed from: a  reason: collision with root package name */
    private final p f24768a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24769b;

    /* renamed from: c  reason: collision with root package name */
    private int f24770c;

    public static class a extends cm.b {
        public f a(h hVar, g gVar) {
            boolean z10;
            d b10 = gVar.b();
            if (hVar.d() >= zl.d.f24828a) {
                return f.c();
            }
            int e10 = hVar.e();
            int c10 = hVar.c() + hVar.d();
            if (gVar.a() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            b i10 = o.n(hVar.b(), e10, c10, z10);
            if (i10 == null) {
                return f.c();
            }
            int i11 = i10.f24772b;
            p pVar = new p(i11 - hVar.c());
            if (!(b10 instanceof o) || !o.m((p) b10.e(), i10.f24771a)) {
                o oVar = new o(i10.f24771a);
                i10.f24771a.o(true);
                return f.d(oVar, pVar).a(i11);
            }
            return f.d(pVar).a(i11);
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final p f24771a;

        /* renamed from: b  reason: collision with root package name */
        final int f24772b;

        b(p pVar, int i10) {
            this.f24771a = pVar;
            this.f24772b = i10;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final p f24773a;

        /* renamed from: b  reason: collision with root package name */
        final int f24774b;

        c(p pVar, int i10) {
            this.f24773a = pVar;
            this.f24774b = i10;
        }
    }

    public o(p pVar) {
        this.f24768a = pVar;
    }

    private static boolean k(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static boolean l(CharSequence charSequence, int i10) {
        char charAt;
        if (i10 >= charSequence.length() || (charAt = charSequence.charAt(i10)) == 9 || charAt == ' ') {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean m(p pVar, p pVar2) {
        if ((pVar instanceof am.c) && (pVar2 instanceof am.c)) {
            return k(Character.valueOf(((am.c) pVar).p()), Character.valueOf(((am.c) pVar2).p()));
        }
        if (!(pVar instanceof s) || !(pVar2 instanceof s)) {
            return false;
        }
        return k(Character.valueOf(((s) pVar).p()), Character.valueOf(((s) pVar2).p()));
    }

    /* access modifiers changed from: private */
    public static b n(CharSequence charSequence, int i10, int i11, boolean z10) {
        c o10 = o(charSequence, i10);
        if (o10 == null) {
            return null;
        }
        p pVar = o10.f24773a;
        int i12 = o10.f24774b;
        int i13 = i11 + (i12 - i10);
        boolean z11 = false;
        int length = charSequence.length();
        int i14 = i13;
        while (true) {
            if (i12 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i12);
            if (charAt != 9) {
                if (charAt != ' ') {
                    z11 = true;
                    break;
                }
                i14++;
            } else {
                i14 += zl.d.a(i14);
            }
            i12++;
        }
        if (z10 && (((pVar instanceof s) && ((s) pVar).q() != 1) || !z11)) {
            return null;
        }
        if (!z11 || i14 - i13 > zl.d.f24828a) {
            i14 = i13 + 1;
        }
        return new b(pVar, i14);
    }

    private static c o(CharSequence charSequence, int i10) {
        char charAt = charSequence.charAt(i10);
        if (charAt != '*' && charAt != '+' && charAt != '-') {
            return p(charSequence, i10);
        }
        int i11 = i10 + 1;
        if (!l(charSequence, i11)) {
            return null;
        }
        am.c cVar = new am.c();
        cVar.q(charAt);
        return new c(cVar, i11);
    }

    private static c p(CharSequence charSequence, int i10) {
        char charAt;
        int length = charSequence.length();
        int i11 = 0;
        int i12 = i10;
        while (true) {
            if (i12 < length) {
                charAt = charSequence.charAt(i12);
                if (charAt != ')' && charAt != '.') {
                    switch (charAt) {
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            i11++;
                            if (i11 > 9) {
                                return null;
                            }
                            i12++;
                        default:
                            return null;
                    }
                }
            }
        }
        if (i11 >= 1) {
            int i13 = i12 + 1;
            if (l(charSequence, i13)) {
                String charSequence2 = charSequence.subSequence(i10, i12).toString();
                s sVar = new s();
                sVar.s(Integer.parseInt(charSequence2));
                sVar.r(charAt);
                return new c(sVar, i13);
            }
        }
        return null;
    }

    public boolean a() {
        return true;
    }

    public boolean b(am.a aVar) {
        if (!(aVar instanceof q)) {
            return false;
        }
        if (this.f24769b && this.f24770c == 1) {
            this.f24768a.o(false);
            this.f24769b = false;
        }
        return true;
    }

    public cm.c c(h hVar) {
        if (hVar.a()) {
            this.f24769b = true;
            this.f24770c = 0;
        } else if (this.f24769b) {
            this.f24770c++;
        }
        return cm.c.b(hVar.getIndex());
    }

    public am.a e() {
        return this.f24768a;
    }
}
