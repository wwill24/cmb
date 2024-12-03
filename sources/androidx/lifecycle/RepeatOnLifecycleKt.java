package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;

public final class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle lifecycle, Lifecycle.State state, Function2<? super k0, ? super c<? super Unit>, ? extends Object> function2, c<? super Unit> cVar) {
        boolean z10;
        if (state != Lifecycle.State.INITIALIZED) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        } else if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return Unit.f32013a;
        } else {
            Object g10 = l0.g(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, function2, (c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3>) null), cVar);
            if (g10 == b.d()) {
                return g10;
            }
            return Unit.f32013a;
        }
    }
}
