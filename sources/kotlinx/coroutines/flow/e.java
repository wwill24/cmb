package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.o;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aH\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002*\b\u0001\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/c;", "Lkotlin/coroutines/c;", "", "", "block", "Lkotlinx/coroutines/flow/b;", "b", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/b;", "value", "c", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/channels/o;", "a", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class e {

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/e$a", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f32433a;

        public a(Object obj) {
            this.f32433a = obj;
        }

        public Object a(c<? super T> cVar, c<? super Unit> cVar2) {
            Object c10 = cVar.c(this.f32433a, cVar2);
            if (c10 == b.d()) {
                return c10;
            }
            return Unit.f32013a;
        }
    }

    public static final <T> b<T> a(Function2<? super o<? super T>, ? super c<? super Unit>, ? extends Object> function2) {
        return new CallbackFlowBuilder(function2, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null);
    }

    public static final <T> b<T> b(Function2<? super c<? super T>, ? super c<? super Unit>, ? extends Object> function2) {
        return new k(function2);
    }

    public static final <T> b<T> c(T t10) {
        return new a(t10);
    }
}
