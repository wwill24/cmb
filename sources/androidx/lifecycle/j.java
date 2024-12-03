package androidx.lifecycle;

import androidx.camera.view.h;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class j {
    public static final g a(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        kotlin.jvm.internal.j.g(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.c().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, o2.b((s1) null, 1, (Object) null).e0(x0.c().Y()));
        } while (!h.a(lifecycle.c(), (Object) null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.b();
        return lifecycleCoroutineScopeImpl;
    }
}
