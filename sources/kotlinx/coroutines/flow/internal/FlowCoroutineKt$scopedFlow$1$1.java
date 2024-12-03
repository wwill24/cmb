package kotlinx.coroutines.flow.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import pk.n;

@d(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", l = {51}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"R", "Lkotlinx/coroutines/k0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    final /* synthetic */ n<k0, kotlinx.coroutines.flow.c<? super R>, c<? super Unit>, Object> $block;
    final /* synthetic */ kotlinx.coroutines.flow.c<R> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowCoroutineKt$scopedFlow$1$1(n<? super k0, ? super kotlinx.coroutines.flow.c<? super R>, ? super c<? super Unit>, ? extends Object> nVar, kotlinx.coroutines.flow.c<? super R> cVar, c<? super FlowCoroutineKt$scopedFlow$1$1> cVar2) {
        super(2, cVar2);
        this.$block = nVar;
        this.$this_unsafeFlow = cVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, cVar);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((FlowCoroutineKt$scopedFlow$1$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            n<k0, kotlinx.coroutines.flow.c<? super R>, c<? super Unit>, Object> nVar = this.$block;
            kotlinx.coroutines.flow.c<R> cVar = this.$this_unsafeFlow;
            this.label = 1;
            if (nVar.l((k0) this.L$0, cVar, this) == d10) {
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
