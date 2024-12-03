package androidx.lifecycle;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class g0 {
    public static final k0 a(f0 f0Var) {
        j.g(f0Var, "<this>");
        k0 k0Var = (k0) f0Var.c("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (k0Var != null) {
            return k0Var;
        }
        Object e10 = f0Var.e("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new c(o2.b((s1) null, 1, (Object) null).e0(x0.c().Y())));
        j.f(e10, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (k0) e10;
    }
}
