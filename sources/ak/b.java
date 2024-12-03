package ak;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.d;
import java.util.concurrent.atomic.AtomicReference;
import qj.u;

public abstract class b<T> implements u<T>, tj.b {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<tj.b> f24893a = new AtomicReference<>();

    public final void a(tj.b bVar) {
        if (d.c(this.f24893a, bVar, getClass())) {
            e();
        }
    }

    public final boolean c() {
        return this.f24893a.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.a(this.f24893a);
    }

    /* access modifiers changed from: protected */
    public void e() {
    }
}
