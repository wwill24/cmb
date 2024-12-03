package ed;

import cd.b;
import cd.c;
import cd.d;
import cd.e;
import cd.g;

final class s<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final p f40754a;

    /* renamed from: b  reason: collision with root package name */
    private final String f40755b;

    /* renamed from: c  reason: collision with root package name */
    private final b f40756c;

    /* renamed from: d  reason: collision with root package name */
    private final d<T, byte[]> f40757d;

    /* renamed from: e  reason: collision with root package name */
    private final t f40758e;

    s(p pVar, String str, b bVar, d<T, byte[]> dVar, t tVar) {
        this.f40754a = pVar;
        this.f40755b = str;
        this.f40756c = bVar;
        this.f40757d = dVar;
        this.f40758e = tVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(Exception exc) {
    }

    public void a(c<T> cVar, g gVar) {
        this.f40758e.a(o.a().e(this.f40754a).c(cVar).f(this.f40755b).d(this.f40757d).b(this.f40756c).a(), gVar);
    }

    public void b(c<T> cVar) {
        a(cVar, new r());
    }

    /* access modifiers changed from: package-private */
    public p d() {
        return this.f40754a;
    }
}
