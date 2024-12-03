package coil.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcoil/request/f;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/k;", "observer", "", "a", "d", "Landroidx/lifecycle/Lifecycle$State;", "b", "", "toString", "Landroidx/lifecycle/l;", "c", "Landroidx/lifecycle/l;", "owner", "<init>", "()V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public final class f extends Lifecycle {

    /* renamed from: b  reason: collision with root package name */
    public static final f f8304b = new f();

    /* renamed from: c  reason: collision with root package name */
    private static final l f8305c = new e();

    private f() {
    }

    /* access modifiers changed from: private */
    public static final Lifecycle f() {
        return f8304b;
    }

    public void a(k kVar) {
        if (kVar instanceof DefaultLifecycleObserver) {
            DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) kVar;
            l lVar = f8305c;
            defaultLifecycleObserver.onCreate(lVar);
            defaultLifecycleObserver.onStart(lVar);
            defaultLifecycleObserver.onResume(lVar);
            return;
        }
        throw new IllegalArgumentException((kVar + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
    }

    public Lifecycle.State b() {
        return Lifecycle.State.RESUMED;
    }

    public void d(k kVar) {
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }
}
