package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.g;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00018\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00028\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0014\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0019\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0014\u0010\u001b\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/g;", "N", "", "value", "", "k", "(Lkotlinx/coroutines/internal/g;)Z", "", "b", "()V", "j", "e", "()Ljava/lang/Object;", "nextOrClosed", "c", "()Lkotlinx/coroutines/internal/g;", "leftmostAliveNode", "h", "rightmostAliveNode", "d", "next", "i", "()Z", "isTail", "f", "prev", "g", "removed", "<init>", "(Lkotlinx/coroutines/internal/g;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class g<N extends g<N>> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32530a;

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32531b;
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ Object _prev;

    static {
        Class<Object> cls = Object.class;
        Class<g> cls2 = g.class;
        f32530a = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_next");
        f32531b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_prev");
    }

    public g(N n10) {
        this._prev = n10;
    }

    private final N c() {
        N f10 = f();
        while (f10 != null && f10.g()) {
            f10 = (g) f10._prev;
        }
        return f10;
    }

    /* access modifiers changed from: private */
    public final Object e() {
        return this._next;
    }

    private final N h() {
        N d10 = d();
        j.d(d10);
        while (d10.g()) {
            d10 = d10.d();
            j.d(d10);
        }
        return d10;
    }

    public final void b() {
        f32531b.lazySet(this, (Object) null);
    }

    public final N d() {
        N a10 = e();
        if (a10 == f.f32528a) {
            return null;
        }
        return (g) a10;
    }

    public final N f() {
        return (g) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final void j() {
        while (true) {
            g c10 = c();
            g h10 = h();
            h10._prev = c10;
            if (c10 != null) {
                c10._next = h10;
            }
            if (!h10.g() && (c10 == null || !c10.g())) {
                return;
            }
        }
    }

    public final boolean k(N n10) {
        return a.a(f32530a, this, (Object) null, n10);
    }
}
