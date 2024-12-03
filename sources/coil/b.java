package coil;

import android.graphics.Bitmap;
import coil.decode.e;
import coil.fetch.h;
import coil.fetch.i;
import coil.request.g;
import coil.request.k;
import coil.request.n;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 &2\u00020\u0001:\u0002\u0005*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0017J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0017J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0017J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0017J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0017J*\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H\u0017J*\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u001dH\u0017J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u001fH\u0017J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u001fH\u0017J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0017J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0017J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020'H\u0017J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020)H\u0017¨\u0006+"}, d2 = {"Lcoil/b;", "Lcoil/request/g$b;", "Lcoil/request/g;", "request", "", "b", "p", "Lcoil/size/g;", "size", "l", "", "input", "i", "output", "g", "m", "", "e", "Lcoil/fetch/i;", "fetcher", "Lcoil/request/k;", "options", "h", "Lcoil/fetch/h;", "result", "f", "Lcoil/decode/e;", "decoder", "o", "Lcoil/decode/c;", "j", "Landroid/graphics/Bitmap;", "k", "n", "Lr2/c;", "transition", "q", "r", "a", "Lcoil/request/d;", "c", "Lcoil/request/n;", "d", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public interface b extends g.b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0099b f8060a = C0099b.f8062a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f8061b = new a();

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil/b$a", "Lcoil/b;", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class a implements b {
        a() {
        }

        public void a(g gVar) {
            c.i(this, gVar);
        }

        public void b(g gVar) {
            c.k(this, gVar);
        }

        public void c(g gVar, coil.request.d dVar) {
            c.j(this, gVar, dVar);
        }

        public void d(g gVar, n nVar) {
            c.l(this, gVar, nVar);
        }

        public void e(g gVar, String str) {
            c.e(this, gVar, str);
        }

        public void f(g gVar, i iVar, k kVar, h hVar) {
            c.c(this, gVar, iVar, kVar, hVar);
        }

        public void g(g gVar, Object obj) {
            c.g(this, gVar, obj);
        }

        public void h(g gVar, i iVar, k kVar) {
            c.d(this, gVar, iVar, kVar);
        }

        public void i(g gVar, Object obj) {
            c.h(this, gVar, obj);
        }

        public void j(g gVar, e eVar, k kVar, coil.decode.c cVar) {
            c.a(this, gVar, eVar, kVar, cVar);
        }

        public void k(g gVar, Bitmap bitmap) {
            c.p(this, gVar, bitmap);
        }

        public void l(g gVar, coil.size.g gVar2) {
            c.m(this, gVar, gVar2);
        }

        public void m(g gVar, Object obj) {
            c.f(this, gVar, obj);
        }

        public void n(g gVar, Bitmap bitmap) {
            c.o(this, gVar, bitmap);
        }

        public void o(g gVar, e eVar, k kVar) {
            c.b(this, gVar, eVar, kVar);
        }

        public void p(g gVar) {
            c.n(this, gVar);
        }

        public void q(g gVar, r2.c cVar) {
            c.r(this, gVar, cVar);
        }

        public void r(g gVar, r2.c cVar) {
            c.q(this, gVar, cVar);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lcoil/b$b;", "", "Lcoil/b;", "NONE", "Lcoil/b;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: coil.b$b  reason: collision with other inner class name */
    public static final class C0099b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ C0099b f8062a = new C0099b();

        private C0099b() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c {
        public static void a(b bVar, g gVar, e eVar, k kVar, coil.decode.c cVar) {
        }

        public static void b(b bVar, g gVar, e eVar, k kVar) {
        }

        public static void c(b bVar, g gVar, i iVar, k kVar, h hVar) {
        }

        public static void d(b bVar, g gVar, i iVar, k kVar) {
        }

        public static void e(b bVar, g gVar, String str) {
        }

        public static void f(b bVar, g gVar, Object obj) {
        }

        public static void g(b bVar, g gVar, Object obj) {
        }

        public static void h(b bVar, g gVar, Object obj) {
        }

        public static void i(b bVar, g gVar) {
        }

        public static void j(b bVar, g gVar, coil.request.d dVar) {
        }

        public static void k(b bVar, g gVar) {
        }

        public static void l(b bVar, g gVar, n nVar) {
        }

        public static void m(b bVar, g gVar, coil.size.g gVar2) {
        }

        public static void n(b bVar, g gVar) {
        }

        public static void o(b bVar, g gVar, Bitmap bitmap) {
        }

        public static void p(b bVar, g gVar, Bitmap bitmap) {
        }

        public static void q(b bVar, g gVar, r2.c cVar) {
        }

        public static void r(b bVar, g gVar, r2.c cVar) {
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcoil/b$d;", "", "Lcoil/request/g;", "request", "Lcoil/b;", "a", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    public interface d {

        /* renamed from: a  reason: collision with root package name */
        public static final a f8063a = a.f8065a;

        /* renamed from: b  reason: collision with root package name */
        public static final d f8064b = new c();

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lcoil/b$d$a;", "", "Lcoil/b$d;", "NONE", "Lcoil/b$d;", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ a f8065a = new a();

            private a() {
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: coil.b$d$b  reason: collision with other inner class name */
        public static final class C0100b {
            /* access modifiers changed from: private */
            public static b a(g gVar) {
                return b.f8061b;
            }
        }

        b a(g gVar);
    }

    void a(g gVar);

    void b(g gVar);

    void c(g gVar, coil.request.d dVar);

    void d(g gVar, n nVar);

    void e(g gVar, String str);

    void f(g gVar, i iVar, k kVar, h hVar);

    void g(g gVar, Object obj);

    void h(g gVar, i iVar, k kVar);

    void i(g gVar, Object obj);

    void j(g gVar, e eVar, k kVar, coil.decode.c cVar);

    void k(g gVar, Bitmap bitmap);

    void l(g gVar, coil.size.g gVar2);

    void m(g gVar, Object obj);

    void n(g gVar, Bitmap bitmap);

    void o(g gVar, e eVar, k kVar);

    void p(g gVar);

    void q(g gVar, r2.c cVar);

    void r(g gVar, r2.c cVar);
}
