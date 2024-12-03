package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import gk.g;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
final class LifecycleCoroutineScopeImpl$register$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, c<? super LifecycleCoroutineScopeImpl$register$1> cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScopeImpl;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.this$0, cVar);
        lifecycleCoroutineScopeImpl$register$1.L$0 = obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            k0 k0Var = (k0) this.L$0;
            if (this.this$0.a().b().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                this.this$0.a().a(this.this$0);
            } else {
                x1.d(k0Var.G(), (CancellationException) null, 1, (Object) null);
            }
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
