package xl;

import am.d;
import am.h;
import am.k;
import am.r;
import am.u;
import am.w;
import bm.b;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import yl.c;

public class n implements bm.a {

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f24745i = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f24746j = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f24747k = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f24748l = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f24749m = Pattern.compile("`+");

    /* renamed from: n  reason: collision with root package name */
    private static final Pattern f24750n = Pattern.compile("^`+");

    /* renamed from: o  reason: collision with root package name */
    private static final Pattern f24751o = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");

    /* renamed from: p  reason: collision with root package name */
    private static final Pattern f24752p = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");

    /* renamed from: q  reason: collision with root package name */
    private static final Pattern f24753q = Pattern.compile("^ *(?:\n *)?");

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f24754r = Pattern.compile("^[\\p{Zs}\t\r\n\f]");

    /* renamed from: s  reason: collision with root package name */
    private static final Pattern f24755s = Pattern.compile("\\s+");

    /* renamed from: t  reason: collision with root package name */
    private static final Pattern f24756t = Pattern.compile(" *$");

    /* renamed from: a  reason: collision with root package name */
    private final BitSet f24757a;

    /* renamed from: b  reason: collision with root package name */
    private final BitSet f24758b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Character, dm.a> f24759c;

    /* renamed from: d  reason: collision with root package name */
    private final b f24760d;

    /* renamed from: e  reason: collision with root package name */
    private String f24761e;

    /* renamed from: f  reason: collision with root package name */
    private int f24762f;

    /* renamed from: g  reason: collision with root package name */
    private f f24763g;

    /* renamed from: h  reason: collision with root package name */
    private e f24764h;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f24765a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f24766b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f24767c;

        a(int i10, boolean z10, boolean z11) {
            this.f24765a = i10;
            this.f24767c = z10;
            this.f24766b = z11;
        }
    }

    public n(b bVar) {
        Map<Character, dm.a> f10 = f(bVar.b());
        this.f24759c = f10;
        BitSet e10 = e(f10.keySet());
        this.f24758b = e10;
        this.f24757a = g(e10);
        this.f24760d = bVar;
    }

    private r A() {
        int i10 = this.f24762f;
        int length = this.f24761e.length();
        while (true) {
            int i11 = this.f24762f;
            if (i11 == length || this.f24757a.get(this.f24761e.charAt(i11))) {
                int i12 = this.f24762f;
            } else {
                this.f24762f++;
            }
        }
        int i122 = this.f24762f;
        if (i10 != i122) {
            return M(this.f24761e, i10, i122);
        }
        return null;
    }

    private char B() {
        if (this.f24762f < this.f24761e.length()) {
            return this.f24761e.charAt(this.f24762f);
        }
        return 0;
    }

    private void C(f fVar) {
        boolean z10;
        HashMap hashMap = new HashMap();
        f fVar2 = this.f24763g;
        while (fVar2 != null) {
            f fVar3 = fVar2.f24708e;
            if (fVar3 == fVar) {
                break;
            }
            fVar2 = fVar3;
        }
        while (fVar2 != null) {
            char c10 = fVar2.f24705b;
            dm.a aVar = this.f24759c.get(Character.valueOf(c10));
            if (!fVar2.f24707d || aVar == null) {
                fVar2 = fVar2.f24709f;
            } else {
                char d10 = aVar.d();
                f fVar4 = fVar2.f24708e;
                int i10 = 0;
                boolean z11 = false;
                while (true) {
                    z10 = true;
                    if (fVar4 == null || fVar4 == fVar || fVar4 == hashMap.get(Character.valueOf(c10))) {
                        z10 = false;
                    } else {
                        if (fVar4.f24706c && fVar4.f24705b == d10) {
                            i10 = aVar.a(fVar4, fVar2);
                            z11 = true;
                            if (i10 > 0) {
                                break;
                            }
                        }
                        fVar4 = fVar4.f24708e;
                    }
                }
                z10 = false;
                if (!z10) {
                    if (!z11) {
                        hashMap.put(Character.valueOf(c10), fVar2.f24708e);
                        if (!fVar2.f24706c) {
                            F(fVar2);
                        }
                    }
                    fVar2 = fVar2.f24709f;
                } else {
                    w wVar = fVar4.f24704a;
                    w wVar2 = fVar2.f24704a;
                    fVar4.f24710g -= i10;
                    fVar2.f24710g -= i10;
                    wVar.n(wVar.m().substring(0, wVar.m().length() - i10));
                    wVar2.n(wVar2.m().substring(0, wVar2.m().length() - i10));
                    G(fVar4, fVar2);
                    k(wVar, wVar2);
                    aVar.e(wVar, wVar2, i10);
                    if (fVar4.f24710g == 0) {
                        E(fVar4);
                    }
                    if (fVar2.f24710g == 0) {
                        f fVar5 = fVar2.f24709f;
                        E(fVar2);
                        fVar2 = fVar5;
                    }
                }
            }
        }
        while (true) {
            f fVar6 = this.f24763g;
            if (fVar6 != null && fVar6 != fVar) {
                F(fVar6);
            } else {
                return;
            }
        }
    }

    private void D(f fVar) {
        f fVar2 = fVar.f24708e;
        if (fVar2 != null) {
            fVar2.f24709f = fVar.f24709f;
        }
        f fVar3 = fVar.f24709f;
        if (fVar3 == null) {
            this.f24763g = fVar2;
        } else {
            fVar3.f24708e = fVar2;
        }
    }

    private void E(f fVar) {
        fVar.f24704a.l();
        D(fVar);
    }

    private void F(f fVar) {
        D(fVar);
    }

    private void G(f fVar, f fVar2) {
        f fVar3 = fVar2.f24708e;
        while (fVar3 != null && fVar3 != fVar) {
            f fVar4 = fVar3.f24708e;
            F(fVar3);
            fVar3 = fVar4;
        }
    }

    private void H() {
        this.f24764h = this.f24764h.f24700d;
    }

    private a J(dm.a aVar, char c10) {
        String str;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i10 = this.f24762f;
        boolean z14 = false;
        int i11 = 0;
        while (B() == c10) {
            i11++;
            this.f24762f++;
        }
        if (i11 < aVar.c()) {
            this.f24762f = i10;
            return null;
        }
        String str2 = "\n";
        if (i10 == 0) {
            str = str2;
        } else {
            str = this.f24761e.substring(i10 - 1, i10);
        }
        char B = B();
        if (B != 0) {
            str2 = String.valueOf(B);
        }
        Pattern pattern = f24745i;
        boolean matches = pattern.matcher(str).matches();
        Pattern pattern2 = f24754r;
        boolean matches2 = pattern2.matcher(str).matches();
        boolean matches3 = pattern.matcher(str2).matches();
        boolean matches4 = pattern2.matcher(str2).matches();
        if (matches4 || (matches3 && !matches2 && !matches)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (matches2 || (matches && !matches4 && !matches3)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (c10 == '_') {
            if (!z10 || (z11 && !matches)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z11 && (!z10 || matches3)) {
                z14 = true;
            }
        } else {
            if (!z10 || c10 != aVar.d()) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z11 && c10 == aVar.b()) {
                z14 = true;
            }
            z12 = z13;
        }
        this.f24762f = i10;
        return new a(i11, z12, z14);
    }

    private void K() {
        h(f24753q);
    }

    private w L(String str) {
        return new w(str);
    }

    private w M(String str, int i10, int i11) {
        return new w(str.substring(i10, i11));
    }

    private void b(e eVar) {
        e eVar2 = this.f24764h;
        if (eVar2 != null) {
            eVar2.f24703g = true;
        }
        this.f24764h = eVar;
    }

    private static void c(char c10, dm.a aVar, Map<Character, dm.a> map) {
        if (map.put(Character.valueOf(c10), aVar) != null) {
            throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c10 + "'");
        }
    }

    private static void d(Iterable<dm.a> iterable, Map<Character, dm.a> map) {
        q qVar;
        for (dm.a next : iterable) {
            char d10 = next.d();
            char b10 = next.b();
            if (d10 == b10) {
                dm.a aVar = map.get(Character.valueOf(d10));
                if (aVar == null || aVar.d() != aVar.b()) {
                    c(d10, next, map);
                } else {
                    if (aVar instanceof q) {
                        qVar = (q) aVar;
                    } else {
                        q qVar2 = new q(d10);
                        qVar2.f(aVar);
                        qVar = qVar2;
                    }
                    qVar.f(next);
                    map.put(Character.valueOf(d10), qVar);
                }
            } else {
                c(d10, next, map);
                c(b10, next, map);
            }
        }
    }

    public static BitSet e(Set<Character> set) {
        BitSet bitSet = new BitSet();
        for (Character charValue : set) {
            bitSet.set(charValue.charValue());
        }
        return bitSet;
    }

    public static Map<Character, dm.a> f(List<dm.a> list) {
        HashMap hashMap = new HashMap();
        d(Arrays.asList(new dm.a[]{new yl.a(), new c()}), hashMap);
        d(list, hashMap);
        return hashMap;
    }

    public static BitSet g(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    private String h(Pattern pattern) {
        if (this.f24762f >= this.f24761e.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.f24761e);
        matcher.region(this.f24762f, this.f24761e.length());
        if (!matcher.find()) {
            return null;
        }
        this.f24762f = matcher.end();
        return matcher.group();
    }

    private void i(r rVar) {
        if (rVar.c() != rVar.d()) {
            l(rVar.c(), rVar.d());
        }
    }

    private void j(w wVar, w wVar2, int i10) {
        if (wVar != null && wVar2 != null && wVar != wVar2) {
            StringBuilder sb2 = new StringBuilder(i10);
            sb2.append(wVar.m());
            r e10 = wVar.e();
            r e11 = wVar2.e();
            while (e10 != e11) {
                sb2.append(((w) e10).m());
                r e12 = e10.e();
                e10.l();
                e10 = e12;
            }
            wVar.n(sb2.toString());
        }
    }

    private void k(r rVar, r rVar2) {
        if (rVar != rVar2 && rVar.e() != rVar2) {
            l(rVar.e(), rVar2.g());
        }
    }

    private void l(r rVar, r rVar2) {
        int i10 = 0;
        w wVar = null;
        w wVar2 = null;
        while (rVar != null) {
            if (rVar instanceof w) {
                wVar2 = (w) rVar;
                if (wVar == null) {
                    wVar = wVar2;
                }
                i10 += wVar2.m().length();
            } else {
                j(wVar, wVar2, i10);
                i10 = 0;
                wVar = null;
                wVar2 = null;
            }
            if (rVar == rVar2) {
                break;
            }
            rVar = rVar.e();
        }
        j(wVar, wVar2, i10);
    }

    private r m() {
        String h10 = h(f24751o);
        if (h10 != null) {
            String substring = h10.substring(1, h10.length() - 1);
            am.n nVar = new am.n("mailto:" + substring, (String) null);
            nVar.b(new w(substring));
            return nVar;
        }
        String h11 = h(f24752p);
        if (h11 == null) {
            return null;
        }
        String substring2 = h11.substring(1, h11.length() - 1);
        am.n nVar2 = new am.n(substring2, (String) null);
        nVar2.b(new w(substring2));
        return nVar2;
    }

    private r n() {
        this.f24762f++;
        if (B() == 10) {
            h hVar = new h();
            this.f24762f++;
            return hVar;
        }
        if (this.f24762f < this.f24761e.length()) {
            Pattern pattern = f24747k;
            String str = this.f24761e;
            int i10 = this.f24762f;
            if (pattern.matcher(str.substring(i10, i10 + 1)).matches()) {
                String str2 = this.f24761e;
                int i11 = this.f24762f;
                w M = M(str2, i11, i11 + 1);
                this.f24762f++;
                return M;
            }
        }
        return L("\\");
    }

    private r o() {
        String h10;
        String h11 = h(f24750n);
        if (h11 == null) {
            return null;
        }
        int i10 = this.f24762f;
        do {
            h10 = h(f24749m);
            if (h10 == null) {
                this.f24762f = i10;
                return L(h11);
            }
        } while (!h10.equals(h11));
        d dVar = new d();
        String replace = this.f24761e.substring(i10, this.f24762f - h11.length()).replace(10, ' ');
        if (replace.length() >= 3 && replace.charAt(0) == ' ' && replace.charAt(replace.length() - 1) == ' ' && zl.d.e(replace)) {
            replace = replace.substring(1, replace.length() - 1);
        }
        dVar.n(replace);
        return dVar;
    }

    private r p() {
        int i10 = this.f24762f;
        this.f24762f = i10 + 1;
        if (B() != '[') {
            return L("!");
        }
        this.f24762f++;
        w L = L("![");
        b(e.a(L, i10 + 1, this.f24764h, this.f24763g));
        return L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private am.r q() {
        /*
            r12 = this;
            int r0 = r12.f24762f
            r1 = 1
            int r0 = r0 + r1
            r12.f24762f = r0
            xl.e r2 = r12.f24764h
            java.lang.String r3 = "]"
            if (r2 != 0) goto L_0x0011
            am.w r0 = r12.L(r3)
            return r0
        L_0x0011:
            boolean r4 = r2.f24702f
            if (r4 != 0) goto L_0x001d
            r12.H()
            am.w r0 = r12.L(r3)
            return r0
        L_0x001d:
            char r4 = r12.B()
            r5 = 40
            r6 = 0
            r7 = 0
            if (r4 != r5) goto L_0x006d
            int r4 = r12.f24762f
            int r4 = r4 + r1
            r12.f24762f = r4
            r12.K()
            java.lang.String r4 = r12.v()
            if (r4 == 0) goto L_0x006a
            r12.K()
            java.util.regex.Pattern r5 = f24755s
            java.lang.String r8 = r12.f24761e
            int r9 = r12.f24762f
            int r10 = r9 + -1
            java.lang.String r8 = r8.substring(r10, r9)
            java.util.regex.Matcher r5 = r5.matcher(r8)
            boolean r5 = r5.matches()
            if (r5 == 0) goto L_0x0056
            java.lang.String r5 = r12.x()
            r12.K()
            goto L_0x0057
        L_0x0056:
            r5 = r7
        L_0x0057:
            char r8 = r12.B()
            r9 = 41
            if (r8 != r9) goto L_0x0066
            int r8 = r12.f24762f
            int r8 = r8 + r1
            r12.f24762f = r8
            r8 = r1
            goto L_0x0070
        L_0x0066:
            r12.f24762f = r0
            r8 = r6
            goto L_0x0070
        L_0x006a:
            r8 = r6
            r5 = r7
            goto L_0x0070
        L_0x006d:
            r8 = r6
            r4 = r7
            r5 = r4
        L_0x0070:
            if (r8 != 0) goto L_0x00a8
            int r9 = r12.f24762f
            r12.w()
            int r10 = r12.f24762f
            int r10 = r10 - r9
            r11 = 2
            if (r10 <= r11) goto L_0x0085
            java.lang.String r7 = r12.f24761e
            int r10 = r10 + r9
            java.lang.String r7 = r7.substring(r9, r10)
            goto L_0x0091
        L_0x0085:
            boolean r9 = r2.f24703g
            if (r9 != 0) goto L_0x0091
            java.lang.String r7 = r12.f24761e
            int r9 = r2.f24698b
            java.lang.String r7 = r7.substring(r9, r0)
        L_0x0091:
            if (r7 == 0) goto L_0x00a8
            java.lang.String r7 = zl.a.c(r7)
            bm.b r9 = r12.f24760d
            am.o r7 = r9.a(r7)
            if (r7 == 0) goto L_0x00a8
            java.lang.String r4 = r7.m()
            java.lang.String r5 = r7.o()
            goto L_0x00a9
        L_0x00a8:
            r1 = r8
        L_0x00a9:
            if (r1 == 0) goto L_0x00ed
            boolean r0 = r2.f24699c
            if (r0 == 0) goto L_0x00b5
            am.l r0 = new am.l
            r0.<init>(r4, r5)
            goto L_0x00ba
        L_0x00b5:
            am.n r0 = new am.n
            r0.<init>(r4, r5)
        L_0x00ba:
            am.w r1 = r2.f24697a
            am.r r1 = r1.e()
        L_0x00c0:
            if (r1 == 0) goto L_0x00cb
            am.r r3 = r1.e()
            r0.b(r1)
            r1 = r3
            goto L_0x00c0
        L_0x00cb:
            xl.f r1 = r2.f24701e
            r12.C(r1)
            r12.i(r0)
            am.w r1 = r2.f24697a
            r1.l()
            r12.H()
            boolean r1 = r2.f24699c
            if (r1 != 0) goto L_0x00ec
            xl.e r1 = r12.f24764h
        L_0x00e1:
            if (r1 == 0) goto L_0x00ec
            boolean r2 = r1.f24699c
            if (r2 != 0) goto L_0x00e9
            r1.f24702f = r6
        L_0x00e9:
            xl.e r1 = r1.f24700d
            goto L_0x00e1
        L_0x00ec:
            return r0
        L_0x00ed:
            r12.f24762f = r0
            r12.H()
            am.w r0 = r12.L(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: xl.n.q():am.r");
    }

    private r r(dm.a aVar, char c10) {
        a J = J(aVar, c10);
        if (J == null) {
            return null;
        }
        int i10 = J.f24765a;
        int i11 = this.f24762f;
        int i12 = i11 + i10;
        this.f24762f = i12;
        w M = M(this.f24761e, i11, i12);
        f fVar = new f(M, c10, J.f24767c, J.f24766b, this.f24763g);
        this.f24763g = fVar;
        fVar.f24710g = i10;
        fVar.f24711h = i10;
        f fVar2 = fVar.f24708e;
        if (fVar2 != null) {
            fVar2.f24709f = fVar;
        }
        return M;
    }

    private r s() {
        String h10 = h(f24748l);
        if (h10 != null) {
            return L(zl.b.a(h10));
        }
        return null;
    }

    private r t() {
        String h10 = h(f24746j);
        if (h10 == null) {
            return null;
        }
        k kVar = new k();
        kVar.m(h10);
        return kVar;
    }

    private r u(r rVar) {
        r rVar2;
        char B = B();
        if (B == 0) {
            return null;
        }
        if (B == 10) {
            rVar2 = y(rVar);
        } else if (B == '!') {
            rVar2 = p();
        } else if (B == '&') {
            rVar2 = s();
        } else if (B == '<') {
            rVar2 = m();
            if (rVar2 == null) {
                rVar2 = t();
            }
        } else if (B != '`') {
            switch (B) {
                case '[':
                    rVar2 = z();
                    break;
                case '\\':
                    rVar2 = n();
                    break;
                case ']':
                    rVar2 = q();
                    break;
                default:
                    if (!this.f24758b.get(B)) {
                        rVar2 = A();
                        break;
                    } else {
                        rVar2 = r(this.f24759c.get(Character.valueOf(B)), B);
                        break;
                    }
            }
        } else {
            rVar2 = o();
        }
        if (rVar2 != null) {
            return rVar2;
        }
        this.f24762f++;
        return L(String.valueOf(B));
    }

    private String v() {
        String str;
        int a10 = zl.c.a(this.f24761e, this.f24762f);
        if (a10 == -1) {
            return null;
        }
        if (B() == '<') {
            str = this.f24761e.substring(this.f24762f + 1, a10 - 1);
        } else {
            str = this.f24761e.substring(this.f24762f, a10);
        }
        this.f24762f = a10;
        return zl.a.e(str);
    }

    private String x() {
        int d10 = zl.c.d(this.f24761e, this.f24762f);
        if (d10 == -1) {
            return null;
        }
        String substring = this.f24761e.substring(this.f24762f + 1, d10 - 1);
        this.f24762f = d10;
        return zl.a.e(substring);
    }

    private r y(r rVar) {
        int i10;
        this.f24762f++;
        if (rVar instanceof w) {
            w wVar = (w) rVar;
            if (wVar.m().endsWith(" ")) {
                String m10 = wVar.m();
                Matcher matcher = f24756t.matcher(m10);
                if (matcher.find()) {
                    i10 = matcher.end() - matcher.start();
                } else {
                    i10 = 0;
                }
                if (i10 > 0) {
                    wVar.n(m10.substring(0, m10.length() - i10));
                }
                if (i10 >= 2) {
                    return new h();
                }
                return new u();
            }
        }
        return new u();
    }

    private r z() {
        int i10 = this.f24762f;
        this.f24762f = i10 + 1;
        w L = L("[");
        b(e.b(L, i10, this.f24764h, this.f24763g));
        return L;
    }

    /* access modifiers changed from: package-private */
    public void I(String str) {
        this.f24761e = str;
        this.f24762f = 0;
        this.f24763g = null;
        this.f24764h = null;
    }

    public void a(String str, r rVar) {
        I(str.trim());
        r rVar2 = null;
        while (true) {
            rVar2 = u(rVar2);
            if (rVar2 != null) {
                rVar.b(rVar2);
            } else {
                C((f) null);
                i(rVar);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int w() {
        if (this.f24762f < this.f24761e.length() && this.f24761e.charAt(this.f24762f) == '[') {
            int i10 = this.f24762f + 1;
            int c10 = zl.c.c(this.f24761e, i10);
            int i11 = c10 - i10;
            if (c10 != -1 && i11 <= 999 && c10 < this.f24761e.length() && this.f24761e.charAt(c10) == ']') {
                this.f24762f = c10 + 1;
                return i11 + 2;
            }
        }
        return 0;
    }
}
