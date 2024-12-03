package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a]\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rH@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"T", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "b", "Lkotlinx/coroutines/flow/c;", "Lkotlin/coroutines/CoroutineContext;", "emitContext", "e", "V", "newContext", "value", "", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "c", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class d {
    public static final <T> ChannelFlow<T> b(b<? extends T> bVar) {
        ChannelFlow<T> channelFlow = bVar instanceof ChannelFlow ? (ChannelFlow) bVar : null;
        return channelFlow == null ? new e(bVar, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (DefaultConstructorMarker) null) : channelFlow;
    }

    /* JADX INFO: finally extract failed */
    public static final <T, V> Object c(CoroutineContext coroutineContext, V v10, Object obj, Function2<? super V, ? super c<? super T>, ? extends Object> function2, c<? super T> cVar) {
        Object c10 = ThreadContextKt.c(coroutineContext, obj);
        try {
            Object invoke = ((Function2) p.d(function2, 2)).invoke(v10, new n(cVar, coroutineContext));
            ThreadContextKt.a(coroutineContext, c10);
            if (invoke == b.d()) {
                f.c(cVar);
            }
            return invoke;
        } catch (Throwable th2) {
            ThreadContextKt.a(coroutineContext, c10);
            throw th2;
        }
    }

    public static /* synthetic */ Object d(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, c cVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = ThreadContextKt.b(coroutineContext);
        }
        return c(coroutineContext, obj, obj2, function2, cVar);
    }

    /* access modifiers changed from: private */
    public static final <T> kotlinx.coroutines.flow.c<T> e(kotlinx.coroutines.flow.c<? super T> cVar, CoroutineContext coroutineContext) {
        boolean z10;
        if (cVar instanceof m) {
            z10 = true;
        } else {
            z10 = cVar instanceof k;
        }
        if (z10) {
            return cVar;
        }
        return new UndispatchedContextCollector(cVar, coroutineContext);
    }
}
