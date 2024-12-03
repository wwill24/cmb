package kotlinx.coroutines;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@d(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/k0;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class InterruptibleKt$runInterruptible$2 extends SuspendLambda implements Function2<k0, c<? super T>, Object> {
    final /* synthetic */ Function0<T> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InterruptibleKt$runInterruptible$2(Function0<? extends T> function0, c<? super InterruptibleKt$runInterruptible$2> cVar) {
        super(2, cVar);
        this.$block = function0;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        InterruptibleKt$runInterruptible$2 interruptibleKt$runInterruptible$2 = new InterruptibleKt$runInterruptible$2(this.$block, cVar);
        interruptibleKt$runInterruptible$2.L$0 = obj;
        return interruptibleKt$runInterruptible$2;
    }

    public final Object invoke(k0 k0Var, c<? super T> cVar) {
        return ((InterruptibleKt$runInterruptible$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            return InterruptibleKt.d(((k0) this.L$0).G(), this.$block);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
