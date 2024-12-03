package ak;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import qj.d;
import tj.b;

public abstract class a implements d, b {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<b> f24892a = new AtomicReference<>();

    public final void a(b bVar) {
        if (io.reactivex.internal.util.d.c(this.f24892a, bVar, getClass())) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final boolean c() {
        return this.f24892a.get() == DisposableHelper.DISPOSED;
    }

    public final void dispose() {
        DisposableHelper.a(this.f24892a);
    }
}
