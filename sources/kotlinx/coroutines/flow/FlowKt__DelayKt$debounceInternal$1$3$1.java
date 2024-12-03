package kotlinx.coroutines.flow;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.l;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", l = {233}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements Function1<c<? super Unit>, Object> {
    final /* synthetic */ c<T> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$1(c<? super T> cVar, Ref$ObjectRef<Object> ref$ObjectRef, c<? super FlowKt__DelayKt$debounceInternal$1$3$1> cVar2) {
        super(1, cVar2);
        this.$downstream = cVar;
        this.$lastValue = ref$ObjectRef;
    }

    public final c<Unit> create(c<?> cVar) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.$downstream, this.$lastValue, cVar);
    }

    /* renamed from: i */
    public final Object invoke(c<? super Unit> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) create(cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            c<T> cVar = this.$downstream;
            T t10 = l.f32464a;
            T t11 = this.$lastValue.element;
            if (t11 == t10) {
                t11 = null;
            }
            this.label = 1;
            if (cVar.c(t11, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lastValue.element = null;
        return Unit.f32013a;
    }
}
