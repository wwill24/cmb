package xl;

import am.b;
import am.i;
import am.j;
import am.m;
import am.o;
import am.p;
import am.t;
import am.x;
import bm.c;
import cm.d;
import cm.e;
import cm.f;
import cm.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xl.c;
import xl.i;
import xl.j;
import xl.k;
import xl.l;
import xl.o;
import xl.r;

public class h implements cm.h {

    /* renamed from: p  reason: collision with root package name */
    private static final Set<Class<? extends am.a>> f24713p;

    /* renamed from: q  reason: collision with root package name */
    private static final Map<Class<? extends am.a>, e> f24714q;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f24715a;

    /* renamed from: b  reason: collision with root package name */
    private int f24716b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f24717c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24718d;

    /* renamed from: e  reason: collision with root package name */
    private int f24719e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f24720f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f24721g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24722h;

    /* renamed from: i  reason: collision with root package name */
    private final List<e> f24723i;

    /* renamed from: j  reason: collision with root package name */
    private final c f24724j;

    /* renamed from: k  reason: collision with root package name */
    private final List<dm.a> f24725k;

    /* renamed from: l  reason: collision with root package name */
    private final g f24726l;

    /* renamed from: m  reason: collision with root package name */
    private final Map<String, o> f24727m = new LinkedHashMap();

    /* renamed from: n  reason: collision with root package name */
    private List<d> f24728n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private Set<d> f24729o = new LinkedHashSet();

    private static class a implements g {

        /* renamed from: a  reason: collision with root package name */
        private final d f24730a;

        public a(d dVar) {
            this.f24730a = dVar;
        }

        public CharSequence a() {
            d dVar = this.f24730a;
            if (!(dVar instanceof org.commonmark.internal.a)) {
                return null;
            }
            CharSequence i10 = ((org.commonmark.internal.a) dVar).i();
            if (i10.length() == 0) {
                return null;
            }
            return i10;
        }

        public d b() {
            return this.f24730a;
        }
    }

    static {
        Class<m> cls = m.class;
        Class<p> cls2 = p.class;
        Class<x> cls3 = x.class;
        Class<j> cls4 = j.class;
        Class<am.g> cls5 = am.g.class;
        Class<i> cls6 = i.class;
        Class<b> cls7 = b.class;
        f24713p = new LinkedHashSet(Arrays.asList(new Class[]{cls7, cls6, cls5, cls4, cls3, cls2, cls}));
        HashMap hashMap = new HashMap();
        hashMap.put(cls7, new c.a());
        hashMap.put(cls6, new j.a());
        hashMap.put(cls5, new i.a());
        hashMap.put(cls4, new k.b());
        hashMap.put(cls3, new r.a());
        hashMap.put(cls2, new o.a());
        hashMap.put(cls, new l.a());
        f24714q = Collections.unmodifiableMap(hashMap);
    }

    public h(List<e> list, bm.c cVar, List<dm.a> list2) {
        this.f24723i = list;
        this.f24724j = cVar;
        this.f24725k = list2;
        g gVar = new g();
        this.f24726l = gVar;
        g(gVar);
    }

    private void g(d dVar) {
        this.f24728n.add(dVar);
        this.f24729o.add(dVar);
    }

    private <T extends d> T h(T t10) {
        while (!f().b(t10.e())) {
            n(f());
        }
        f().e().b(t10.e());
        g(t10);
        return t10;
    }

    private void i(org.commonmark.internal.a aVar) {
        for (am.o next : aVar.j()) {
            aVar.e().i(next);
            String n10 = next.n();
            if (!this.f24727m.containsKey(n10)) {
                this.f24727m.put(n10, next);
            }
        }
    }

    private void j() {
        CharSequence charSequence;
        if (this.f24718d) {
            CharSequence charSequence2 = this.f24715a;
            CharSequence subSequence = charSequence2.subSequence(this.f24716b + 1, charSequence2.length());
            int a10 = zl.d.a(this.f24717c);
            StringBuilder sb2 = new StringBuilder(subSequence.length() + a10);
            for (int i10 = 0; i10 < a10; i10++) {
                sb2.append(' ');
            }
            sb2.append(subSequence);
            charSequence = sb2.toString();
        } else {
            CharSequence charSequence3 = this.f24715a;
            charSequence = charSequence3.subSequence(this.f24716b, charSequence3.length());
        }
        f().f(charSequence);
    }

    private void k() {
        if (this.f24715a.charAt(this.f24716b) == 9) {
            this.f24716b++;
            int i10 = this.f24717c;
            this.f24717c = i10 + zl.d.a(i10);
            return;
        }
        this.f24716b++;
        this.f24717c++;
    }

    public static List<e> l(List<e> list, Set<Class<? extends am.a>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        for (Class<? extends am.a> cls : set) {
            arrayList.add(f24714q.get(cls));
        }
        return arrayList;
    }

    private void m() {
        List<d> list = this.f24728n;
        list.remove(list.size() - 1);
    }

    private void n(d dVar) {
        if (f() == dVar) {
            m();
        }
        if (dVar instanceof org.commonmark.internal.a) {
            i((org.commonmark.internal.a) dVar);
        }
        dVar.g();
    }

    private am.e o() {
        p(this.f24728n);
        w();
        return this.f24726l.e();
    }

    private void p(List<d> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            n(list.get(size));
        }
    }

    private d q(d dVar) {
        a aVar = new a(dVar);
        for (e a10 : this.f24723i) {
            f a11 = a10.a(this, aVar);
            if (a11 instanceof d) {
                return (d) a11;
            }
        }
        return null;
    }

    private void r() {
        int i10 = this.f24716b;
        int i11 = this.f24717c;
        this.f24722h = true;
        int length = this.f24715a.length();
        while (true) {
            if (i10 >= length) {
                break;
            }
            char charAt = this.f24715a.charAt(i10);
            if (charAt == 9) {
                i10++;
                i11 += 4 - (i11 % 4);
            } else if (charAt != ' ') {
                this.f24722h = false;
                break;
            } else {
                i10++;
                i11++;
            }
        }
        this.f24719e = i10;
        this.f24720f = i11;
        this.f24721g = i11 - this.f24717c;
    }

    public static Set<Class<? extends am.a>> s() {
        return f24713p;
    }

    private void t(CharSequence charSequence) {
        boolean z10;
        this.f24715a = zl.d.j(charSequence);
        this.f24716b = 0;
        this.f24717c = 0;
        this.f24718d = false;
        List<d> list = this.f24728n;
        int i10 = 1;
        for (d next : list.subList(1, list.size())) {
            r();
            cm.c c10 = next.c(this);
            if (!(c10 instanceof b)) {
                break;
            }
            b bVar = (b) c10;
            if (bVar.g()) {
                n(next);
                return;
            }
            if (bVar.f() != -1) {
                y(bVar.f());
            } else if (bVar.e() != -1) {
                x(bVar.e());
            }
            i10++;
        }
        List<d> list2 = this.f24728n;
        ArrayList arrayList = new ArrayList(list2.subList(i10, list2.size()));
        d dVar = this.f24728n.get(i10 - 1);
        boolean isEmpty = arrayList.isEmpty();
        if ((dVar.e() instanceof t) || dVar.a()) {
            z10 = true;
        } else {
            z10 = false;
        }
        while (true) {
            if (!z10) {
                break;
            }
            r();
            if (a() || (this.f24721g < zl.d.f24828a && zl.d.h(this.f24715a, this.f24719e))) {
                y(this.f24719e);
            } else {
                d q10 = q(dVar);
                if (q10 == null) {
                    y(this.f24719e);
                    break;
                }
                if (!isEmpty) {
                    p(arrayList);
                    isEmpty = true;
                }
                if (q10.h() != -1) {
                    y(q10.h());
                } else if (q10.g() != -1) {
                    x(q10.g());
                }
                if (q10.i()) {
                    v();
                }
                d[] f10 = q10.f();
                int length = f10.length;
                int i11 = 0;
                while (i11 < length) {
                    d dVar2 = f10[i11];
                    i11++;
                    d h10 = h(dVar2);
                    z10 = dVar2.a();
                    dVar = h10;
                }
            }
        }
        if (isEmpty || a() || !f().d()) {
            if (!isEmpty) {
                p(arrayList);
            }
            if (!dVar.a()) {
                j();
            } else if (!a()) {
                h(new org.commonmark.internal.a());
                j();
            }
        } else {
            j();
        }
    }

    private void v() {
        d f10 = f();
        m();
        this.f24729o.remove(f10);
        if (f10 instanceof org.commonmark.internal.a) {
            i((org.commonmark.internal.a) f10);
        }
        f10.e().l();
    }

    private void w() {
        bm.a a10 = this.f24724j.a(new m(this.f24725k, this.f24727m));
        for (d h10 : this.f24729o) {
            h10.h(a10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x(int r4) {
        /*
            r3 = this;
            int r0 = r3.f24720f
            if (r4 < r0) goto L_0x000a
            int r1 = r3.f24719e
            r3.f24716b = r1
            r3.f24717c = r0
        L_0x000a:
            java.lang.CharSequence r0 = r3.f24715a
            int r0 = r0.length()
        L_0x0010:
            int r1 = r3.f24717c
            if (r1 >= r4) goto L_0x001c
            int r2 = r3.f24716b
            if (r2 == r0) goto L_0x001c
            r3.k()
            goto L_0x0010
        L_0x001c:
            if (r1 <= r4) goto L_0x0029
            int r0 = r3.f24716b
            r1 = 1
            int r0 = r0 - r1
            r3.f24716b = r0
            r3.f24717c = r4
            r3.f24718d = r1
            goto L_0x002c
        L_0x0029:
            r4 = 0
            r3.f24718d = r4
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xl.h.x(int):void");
    }

    private void y(int i10) {
        int i11 = this.f24719e;
        if (i10 >= i11) {
            this.f24716b = i11;
            this.f24717c = this.f24720f;
        }
        int length = this.f24715a.length();
        while (true) {
            int i12 = this.f24716b;
            if (i12 >= i10 || i12 == length) {
                this.f24718d = false;
            } else {
                k();
            }
        }
        this.f24718d = false;
    }

    public boolean a() {
        return this.f24722h;
    }

    public CharSequence b() {
        return this.f24715a;
    }

    public int c() {
        return this.f24717c;
    }

    public int d() {
        return this.f24721g;
    }

    public int e() {
        return this.f24719e;
    }

    public d f() {
        List<d> list = this.f24728n;
        return list.get(list.size() - 1);
    }

    public int getIndex() {
        return this.f24716b;
    }

    public am.e u(String str) {
        int i10 = 0;
        while (true) {
            int c10 = zl.d.c(str, i10);
            if (c10 == -1) {
                break;
            }
            t(str.substring(i10, c10));
            i10 = c10 + 1;
            if (i10 < str.length() && str.charAt(c10) == 13 && str.charAt(i10) == 10) {
                i10 = c10 + 2;
            }
        }
        if (str.length() > 0 && (i10 == 0 || i10 < str.length())) {
            t(str.substring(i10));
        }
        return o();
    }
}
