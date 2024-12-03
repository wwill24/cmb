package kotlinx.coroutines.flow.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@"}, d2 = {"T", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class UndispatchedContextCollector$emitRef$1 extends SuspendLambda implements Function2<T, c<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.c<T> $downstream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UndispatchedContextCollector$emitRef$1(kotlinx.coroutines.flow.c<? super T> cVar, c<? super UndispatchedContextCollector$emitRef$1> cVar2) {
        super(2, cVar2);
        this.$downstream = cVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        UndispatchedContextCollector$emitRef$1 undispatchedContextCollector$emitRef$1 = new UndispatchedContextCollector$emitRef$1(this.$downstream, cVar);
        undispatchedContextCollector$emitRef$1.L$0 = obj;
        return undispatchedContextCollector$emitRef$1;
    }

    /* renamed from: i */
    public final Object invoke(T t10, c<? super Unit> cVar) {
        return ((UndispatchedContextCollector$emitRef$1) create(t10, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Object obj2 = this.L$0;
            kotlinx.coroutines.flow.c<T> cVar = this.$downstream;
            this.label = 1;
            if (cVar.c(obj2, this) == d10) {
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
