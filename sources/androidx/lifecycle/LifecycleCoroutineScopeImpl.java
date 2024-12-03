package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class LifecycleCoroutineScopeImpl extends g implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Lifecycle f5931a;

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f5932b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        j.g(lifecycle, "lifecycle");
        j.g(coroutineContext, "coroutineContext");
        this.f5931a = lifecycle;
        this.f5932b = coroutineContext;
        if (a().b() == Lifecycle.State.DESTROYED) {
            x1.d(G(), (CancellationException) null, 1, (Object) null);
        }
    }

    public CoroutineContext G() {
        return this.f5932b;
    }

    public Lifecycle a() {
        return this.f5931a;
    }

    public final void b() {
        s1 unused = j.d(this, x0.c().Y(), (CoroutineStart) null, new LifecycleCoroutineScopeImpl$register$1(this, (c<? super LifecycleCoroutineScopeImpl$register$1>) null), 2, (Object) null);
    }

    public void e(l lVar, Lifecycle.Event event) {
        j.g(lVar, "source");
        j.g(event, "event");
        if (a().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().d(this);
            x1.d(G(), (CancellationException) null, 1, (Object) null);
        }
    }
}
