package gi;

import java.util.concurrent.atomic.AtomicBoolean;
import sj.a;
import tj.b;

public abstract class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f23441a = new AtomicBoolean();

    /* access modifiers changed from: protected */
    public abstract void a();

    public final boolean c() {
        return this.f23441a.get();
    }

    public final void dispose() {
        if (!this.f23441a.compareAndSet(false, true)) {
            return;
        }
        if (b.b()) {
            a();
        } else {
            a.a().c(new c(this));
        }
    }
}
