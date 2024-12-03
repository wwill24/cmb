package kotlinx.coroutines.flow;

import gk.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.flow.internal.l;

@d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", l = {243}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/h;", "", "value", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<h<? extends Object>, c<? super Unit>, Object> {
    final /* synthetic */ c<T> $downstream;
    final /* synthetic */ Ref$ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1$3$2(Ref$ObjectRef<Object> ref$ObjectRef, c<? super T> cVar, c<? super FlowKt__DelayKt$debounceInternal$1$3$2> cVar2) {
        super(2, cVar2);
        this.$lastValue = ref$ObjectRef;
        this.$downstream = cVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, cVar);
        flowKt__DelayKt$debounceInternal$1$3$2.L$0 = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    public final Object i(Object obj, c<? super Unit> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(h.b(obj), cVar)).invokeSuspend(Unit.f32013a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return i(((h) obj).l(), (c) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        Ref$ObjectRef<Object> ref$ObjectRef;
        Ref$ObjectRef<Object> ref$ObjectRef2;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            T l10 = ((h) this.L$0).l();
            ref$ObjectRef = this.$lastValue;
            boolean z10 = l10 instanceof h.c;
            if (!z10) {
                ref$ObjectRef.element = l10;
            }
            c<T> cVar = this.$downstream;
            if (z10) {
                Throwable e10 = h.e(l10);
                if (e10 == null) {
                    T t10 = ref$ObjectRef.element;
                    if (t10 != null) {
                        if (t10 == l.f32464a) {
                            t10 = null;
                        }
                        this.L$0 = l10;
                        this.L$1 = ref$ObjectRef;
                        this.label = 1;
                        if (cVar.c(t10, this) == d10) {
                            return d10;
                        }
                        ref$ObjectRef2 = ref$ObjectRef;
                    }
                    ref$ObjectRef.element = l.f32466c;
                } else {
                    throw e10;
                }
            }
            return Unit.f32013a;
        } else if (i10 == 1) {
            ref$ObjectRef2 = (Ref$ObjectRef) this.L$1;
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ref$ObjectRef = ref$ObjectRef2;
        ref$ObjectRef.element = l.f32466c;
        return Unit.f32013a;
    }
}
