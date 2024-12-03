package io.noties.markwon.core;

import am.r;
import am.t;
import am.u;
import am.v;
import am.w;
import am.x;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.annotation.NonNull;
import ij.j;
import ij.l;
import ij.q;
import ij.s;
import io.noties.markwon.core.CoreProps;
import java.util.ArrayList;
import java.util.List;

public class a extends ij.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List<p> f30063a = new ArrayList(0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f30064b;

    /* renamed from: io.noties.markwon.core.a$a  reason: collision with other inner class name */
    class C0352a implements l.c<x> {
        C0352a() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull x xVar) {
            lVar.k(xVar);
            int length = lVar.length();
            lVar.builder().append(160);
            lVar.i(xVar, length);
            lVar.q(xVar);
        }
    }

    class b implements l.c<am.i> {
        b() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.i iVar) {
            lVar.k(iVar);
            int length = lVar.length();
            lVar.d(iVar);
            CoreProps.f30056d.d(lVar.j(), Integer.valueOf(iVar.n()));
            lVar.i(iVar, length);
            lVar.q(iVar);
        }
    }

    class c implements l.c<u> {
        c() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull u uVar) {
            lVar.builder().append(' ');
        }
    }

    class d implements l.c<am.h> {
        d() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.h hVar) {
            lVar.z();
        }
    }

    class e implements l.c<t> {
        e() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull t tVar) {
            boolean n10 = a.y(tVar);
            if (!n10) {
                lVar.k(tVar);
            }
            int length = lVar.length();
            lVar.d(tVar);
            CoreProps.f30058f.d(lVar.j(), Boolean.valueOf(n10));
            lVar.i(tVar, length);
            if (!n10) {
                lVar.q(tVar);
            }
        }
    }

    class f implements l.c<am.n> {
        f() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.n nVar) {
            int length = lVar.length();
            lVar.d(nVar);
            CoreProps.f30057e.d(lVar.j(), nVar.m());
            lVar.i(nVar, length);
        }
    }

    class g implements l.c<w> {
        g() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull w wVar) {
            String m10 = wVar.m();
            lVar.builder().d(m10);
            if (!a.this.f30063a.isEmpty()) {
                int length = lVar.length() - m10.length();
                for (p a10 : a.this.f30063a) {
                    a10.a(lVar, m10, length);
                }
            }
        }
    }

    class h implements l.c<v> {
        h() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull v vVar) {
            int length = lVar.length();
            lVar.d(vVar);
            lVar.i(vVar, length);
        }
    }

    class i implements l.c<am.f> {
        i() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.f fVar) {
            int length = lVar.length();
            lVar.d(fVar);
            lVar.i(fVar, length);
        }
    }

    class j implements l.c<am.b> {
        j() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.b bVar) {
            lVar.k(bVar);
            int length = lVar.length();
            lVar.d(bVar);
            lVar.i(bVar, length);
            lVar.q(bVar);
        }
    }

    class k implements l.c<am.d> {
        k() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.d dVar) {
            int length = lVar.length();
            lVar.builder().append(160).d(dVar.m()).append(160);
            lVar.i(dVar, length);
        }
    }

    class l implements l.c<am.g> {
        l() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.g gVar) {
            a.I(lVar, gVar.q(), gVar.r(), gVar);
        }
    }

    class m implements l.c<am.m> {
        m() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.m mVar) {
            a.I(lVar, (String) null, mVar.n(), mVar);
        }
    }

    class n implements l.c<am.l> {
        n() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.l lVar2) {
            s sVar = lVar.r().c().get(am.l.class);
            if (sVar == null) {
                lVar.d(lVar2);
                return;
            }
            int length = lVar.length();
            lVar.d(lVar2);
            if (length == lVar.length()) {
                lVar.builder().append(65532);
            }
            ij.g r10 = lVar.r();
            String b10 = r10.a().b(lVar2.m());
            q j10 = lVar.j();
            mj.c.f32797a.d(j10, b10);
            mj.c.f32798b.d(j10, Boolean.valueOf(lVar2.f() instanceof am.n));
            mj.c.f32799c.d(j10, null);
            lVar.b(length, sVar.a(r10, j10));
        }
    }

    class o implements l.c<am.q> {
        o() {
        }

        /* renamed from: b */
        public void a(@NonNull ij.l lVar, @NonNull am.q qVar) {
            int length = lVar.length();
            lVar.d(qVar);
            am.a m10 = qVar.f();
            if (m10 instanceof am.s) {
                am.s sVar = (am.s) m10;
                int q10 = sVar.q();
                CoreProps.f30053a.d(lVar.j(), CoreProps.ListItemType.ORDERED);
                CoreProps.f30055c.d(lVar.j(), Integer.valueOf(q10));
                sVar.s(sVar.q() + 1);
            } else {
                CoreProps.f30053a.d(lVar.j(), CoreProps.ListItemType.BULLET);
                CoreProps.f30054b.d(lVar.j(), Integer.valueOf(a.B(qVar)));
            }
            lVar.i(qVar, length);
            if (lVar.v(qVar)) {
                lVar.z();
            }
        }
    }

    public interface p {
        void a(@NonNull ij.l lVar, @NonNull String str, int i10);
    }

    protected a() {
    }

    private static void A(@NonNull l.b bVar) {
        bVar.b(am.q.class, new o());
    }

    /* access modifiers changed from: private */
    public static int B(@NonNull r rVar) {
        int i10 = 0;
        for (r f10 = rVar.f(); f10 != null; f10 = f10.f()) {
            if (f10 instanceof am.q) {
                i10++;
            }
        }
        return i10;
    }

    private static void C(@NonNull l.b bVar) {
        bVar.b(am.s.class, new jj.b());
    }

    private static void D(@NonNull l.b bVar) {
        bVar.b(t.class, new e());
    }

    private static void E(@NonNull l.b bVar) {
        bVar.b(u.class, new c());
    }

    private static void F(@NonNull l.b bVar) {
        bVar.b(v.class, new h());
    }

    private void G(@NonNull l.b bVar) {
        bVar.b(w.class, new g());
    }

    private static void H(@NonNull l.b bVar) {
        bVar.b(x.class, new C0352a());
    }

    static void I(@NonNull ij.l lVar, String str, @NonNull String str2, @NonNull r rVar) {
        lVar.k(rVar);
        int length = lVar.length();
        lVar.builder().append(160).append(10).append(lVar.r().d().a(str, str2));
        lVar.z();
        lVar.builder().append(160);
        CoreProps.f30059g.d(lVar.j(), str);
        lVar.i(rVar, length);
        lVar.q(rVar);
    }

    private static void o(@NonNull l.b bVar) {
        bVar.b(am.b.class, new j());
    }

    private static void p(@NonNull l.b bVar) {
        bVar.b(am.c.class, new jj.b());
    }

    private static void q(@NonNull l.b bVar) {
        bVar.b(am.d.class, new k());
    }

    @NonNull
    public static a r() {
        return new a();
    }

    private static void s(@NonNull l.b bVar) {
        bVar.b(am.f.class, new i());
    }

    private static void t(@NonNull l.b bVar) {
        bVar.b(am.g.class, new l());
    }

    private static void u(@NonNull l.b bVar) {
        bVar.b(am.h.class, new d());
    }

    private static void v(@NonNull l.b bVar) {
        bVar.b(am.i.class, new b());
    }

    private static void w(l.b bVar) {
        bVar.b(am.l.class, new n());
    }

    private static void x(@NonNull l.b bVar) {
        bVar.b(am.m.class, new m());
    }

    /* access modifiers changed from: private */
    public static boolean y(@NonNull t tVar) {
        am.a m10 = tVar.f();
        if (m10 == null) {
            return false;
        }
        r f10 = m10.f();
        if (f10 instanceof am.p) {
            return ((am.p) f10).n();
        }
        return false;
    }

    private static void z(@NonNull l.b bVar) {
        bVar.b(am.n.class, new f());
    }

    public void b(@NonNull TextView textView) {
        if (!this.f30064b && textView.getMovementMethod() == null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void c(@NonNull j.a aVar) {
        kj.b bVar = new kj.b();
        aVar.a(v.class, new kj.h()).a(am.f.class, new kj.d()).a(am.b.class, new kj.a()).a(am.d.class, new kj.c()).a(am.g.class, bVar).a(am.m.class, bVar).a(am.q.class, new kj.g()).a(am.i.class, new kj.e()).a(am.n.class, new kj.f()).a(x.class, new kj.i());
    }

    public void j(@NonNull l.b bVar) {
        G(bVar);
        F(bVar);
        s(bVar);
        o(bVar);
        q(bVar);
        t(bVar);
        x(bVar);
        w(bVar);
        p(bVar);
        C(bVar);
        A(bVar);
        H(bVar);
        v(bVar);
        E(bVar);
        u(bVar);
        D(bVar);
        z(bVar);
    }

    public void k(@NonNull TextView textView, @NonNull Spanned spanned) {
        lj.h.a(textView, spanned);
        if (spanned instanceof Spannable) {
            lj.j.a((Spannable) spanned, textView);
        }
    }
}
