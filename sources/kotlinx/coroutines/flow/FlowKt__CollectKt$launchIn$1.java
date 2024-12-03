package kotlinx.coroutines.flow;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", l = {50}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class FlowKt__CollectKt$launchIn$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ b<T> $this_launchIn;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__CollectKt$launchIn$1(b<? extends T> bVar, c<? super FlowKt__CollectKt$launchIn$1> cVar) {
        super(2, cVar);
        this.$this_launchIn = bVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new FlowKt__CollectKt$launchIn$1(this.$this_launchIn, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((FlowKt__CollectKt$launchIn$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            b<T> bVar = this.$this_launchIn;
            this.label = 1;
            if (d.g(bVar, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
