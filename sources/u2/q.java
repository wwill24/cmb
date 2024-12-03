package u2;

import d3.a;
import d3.c;
import java.util.Collections;

public class q<K, A> extends a<K, A> {

    /* renamed from: i  reason: collision with root package name */
    private final A f18011i;

    public q(c<A> cVar) {
        this(cVar, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return 1.0f;
    }

    public A h() {
        c<A> cVar = this.f17953e;
        A a10 = this.f18011i;
        return cVar.b(0.0f, 0.0f, a10, a10, f(), f(), f());
    }

    /* access modifiers changed from: package-private */
    public A i(a<K> aVar, float f10) {
        return h();
    }

    public void k() {
        if (this.f17953e != null) {
            super.k();
        }
    }

    public void m(float f10) {
        this.f17952d = f10;
    }

    public q(c<A> cVar, A a10) {
        super(Collections.emptyList());
        n(cVar);
        this.f18011i = a10;
    }
}
