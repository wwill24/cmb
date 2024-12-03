package coil;

import coil.decode.e;
import coil.fetch.i;
import coil.fetch.l;
import coil.request.k;
import coil.util.c;
import gk.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import m2.b;
import n2.d;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B«\u0001\b\u0002\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00120\u0010 \u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001d0\f0\u0015\u0012(\u0010#\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001d0\f0\u0015\u0012(\u0010%\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001d0\f0\u0015\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0015¢\u0006\u0004\b(\u0010)B\t\b\u0016¢\u0006\u0004\b(\u0010*J\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003J8\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J8\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J\u0006\u0010\u0014\u001a\u00020\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aRA\u0010 \u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001d0\f0\u00158\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR9\u0010#\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001d0\f0\u00158\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\"\u0010\u001aR9\u0010%\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010$\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001d0\f0\u00158\u0006¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00158\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\u0017\u0010\u001a¨\u0006+"}, d2 = {"Lcoil/a;", "", "data", "Lcoil/request/k;", "options", "g", "", "f", "Lcoil/ImageLoader;", "imageLoader", "", "startIndex", "Lkotlin/Pair;", "Lcoil/fetch/i;", "j", "Lcoil/fetch/l;", "result", "Lcoil/decode/e;", "i", "Lcoil/a$a;", "h", "", "Lcoil/intercept/a;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "interceptors", "Ln2/d;", "Ljava/lang/Class;", "b", "e", "mappers", "Lm2/b;", "d", "keyers", "Lcoil/fetch/i$a;", "fetcherFactories", "Lcoil/decode/e$a;", "decoderFactories", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<coil.intercept.a> f8050a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Pair<d<? extends Object, ? extends Object>, Class<? extends Object>>> f8051b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Pair<b<? extends Object>, Class<? extends Object>>> f8052c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Pair<i.a<? extends Object>, Class<? extends Object>>> f8053d;

    /* renamed from: e  reason: collision with root package name */
    private final List<e.a> f8054e;

    private a(List<? extends coil.intercept.a> list, List<? extends Pair<? extends d<? extends Object, ? extends Object>, ? extends Class<? extends Object>>> list2, List<? extends Pair<? extends b<? extends Object>, ? extends Class<? extends Object>>> list3, List<? extends Pair<? extends i.a<? extends Object>, ? extends Class<? extends Object>>> list4, List<? extends e.a> list5) {
        this.f8050a = list;
        this.f8051b = list2;
        this.f8052c = list3;
        this.f8053d = list4;
        this.f8054e = list5;
    }

    public /* synthetic */ a(List list, List list2, List list3, List list4, List list5, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, list3, list4, list5);
    }

    public final List<e.a> a() {
        return this.f8054e;
    }

    public final List<Pair<i.a<? extends Object>, Class<? extends Object>>> b() {
        return this.f8053d;
    }

    public final List<coil.intercept.a> c() {
        return this.f8050a;
    }

    public final List<Pair<b<? extends Object>, Class<? extends Object>>> d() {
        return this.f8052c;
    }

    public final List<Pair<d<? extends Object, ? extends Object>, Class<? extends Object>>> e() {
        return this.f8051b;
    }

    public final String f(Object obj, k kVar) {
        List<Pair<b<? extends Object>, Class<? extends Object>>> list = this.f8052c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Pair pair = list.get(i10);
            b bVar = (b) pair.a();
            if (((Class) pair.b()).isAssignableFrom(obj.getClass())) {
                j.e(bVar, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
                String a10 = bVar.a(obj, kVar);
                if (a10 != null) {
                    return a10;
                }
            }
        }
        return null;
    }

    public final Object g(Object obj, k kVar) {
        List<Pair<d<? extends Object, ? extends Object>, Class<? extends Object>>> list = this.f8051b;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Pair pair = list.get(i10);
            d dVar = (d) pair.a();
            if (((Class) pair.b()).isAssignableFrom(obj.getClass())) {
                j.e(dVar, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
                Object a10 = dVar.a(obj, kVar);
                if (a10 != null) {
                    obj = a10;
                }
            }
        }
        return obj;
    }

    public final C0098a h() {
        return new C0098a(this);
    }

    public final Pair<e, Integer> i(l lVar, k kVar, ImageLoader imageLoader, int i10) {
        int size = this.f8054e.size();
        while (i10 < size) {
            e a10 = this.f8054e.get(i10).a(lVar, kVar, imageLoader);
            if (a10 != null) {
                return h.a(a10, Integer.valueOf(i10));
            }
            i10++;
        }
        return null;
    }

    public final Pair<i, Integer> j(Object obj, k kVar, ImageLoader imageLoader, int i10) {
        int size = this.f8053d.size();
        while (i10 < size) {
            Pair pair = this.f8053d.get(i10);
            i.a aVar = (i.a) pair.a();
            if (((Class) pair.b()).isAssignableFrom(obj.getClass())) {
                j.e(aVar, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
                i a10 = aVar.a(obj, kVar, imageLoader);
                if (a10 != null) {
                    return h.a(a10, Integer.valueOf(i10));
                }
            }
            i10++;
        }
        return null;
    }

    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\u0010¢\u0006\u0004\b!\u0010$J0\u0010\u0007\u001a\u00020\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J,\u0010\n\u001a\u00020\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J,\u0010\r\u001a\u00020\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R@\u0010\u001a\u001a(\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\u0003\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\u00180\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R<\u0010\u001c\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\u00180\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016R<\u0010\u001e\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\u00180\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R \u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u00128\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016¨\u0006%"}, d2 = {"Lcoil/a$a;", "", "T", "Ln2/d;", "mapper", "Ljava/lang/Class;", "type", "d", "Lm2/b;", "keyer", "c", "Lcoil/fetch/i$a;", "factory", "b", "Lcoil/decode/e$a;", "a", "Lcoil/a;", "e", "", "Lcoil/intercept/a;", "Ljava/util/List;", "getInterceptors$coil_base_release", "()Ljava/util/List;", "interceptors", "Lkotlin/Pair;", "getMappers$coil_base_release", "mappers", "getKeyers$coil_base_release", "keyers", "g", "fetcherFactories", "f", "decoderFactories", "<init>", "()V", "registry", "(Lcoil/a;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: coil.a$a  reason: collision with other inner class name */
    public static final class C0098a {

        /* renamed from: a  reason: collision with root package name */
        private final List<coil.intercept.a> f8055a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Pair<d<? extends Object, ?>, Class<? extends Object>>> f8056b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Pair<b<? extends Object>, Class<? extends Object>>> f8057c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Pair<i.a<? extends Object>, Class<? extends Object>>> f8058d;

        /* renamed from: e  reason: collision with root package name */
        private final List<e.a> f8059e;

        public C0098a() {
            this.f8055a = new ArrayList();
            this.f8056b = new ArrayList();
            this.f8057c = new ArrayList();
            this.f8058d = new ArrayList();
            this.f8059e = new ArrayList();
        }

        public final C0098a a(e.a aVar) {
            this.f8059e.add(aVar);
            return this;
        }

        public final <T> C0098a b(i.a<T> aVar, Class<T> cls) {
            this.f8058d.add(h.a(aVar, cls));
            return this;
        }

        public final <T> C0098a c(b<T> bVar, Class<T> cls) {
            this.f8057c.add(h.a(bVar, cls));
            return this;
        }

        public final <T> C0098a d(d<T, ?> dVar, Class<T> cls) {
            this.f8056b.add(h.a(dVar, cls));
            return this;
        }

        public final a e() {
            return new a(c.a(this.f8055a), c.a(this.f8056b), c.a(this.f8057c), c.a(this.f8058d), c.a(this.f8059e), (DefaultConstructorMarker) null);
        }

        public final List<e.a> f() {
            return this.f8059e;
        }

        public final List<Pair<i.a<? extends Object>, Class<? extends Object>>> g() {
            return this.f8058d;
        }

        public C0098a(a aVar) {
            this.f8055a = CollectionsKt___CollectionsKt.z0(aVar.c());
            this.f8056b = CollectionsKt___CollectionsKt.z0(aVar.e());
            this.f8057c = CollectionsKt___CollectionsKt.z0(aVar.d());
            this.f8058d = CollectionsKt___CollectionsKt.z0(aVar.b());
            this.f8059e = CollectionsKt___CollectionsKt.z0(aVar.a());
        }
    }

    public a() {
        this(q.j(), q.j(), q.j(), q.j(), q.j());
    }
}
