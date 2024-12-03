package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a9\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"T", "Lkotlinx/coroutines/flow/b;", "", "timeoutMillis", "a", "Lkotlin/Function1;", "timeoutMillisSelector", "b", "(Lkotlinx/coroutines/flow/b;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/b;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__DelayKt {
    public static final <T> b<T> a(b<? extends T> bVar, long j10) {
        boolean z10;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
        } else if (i10 == 0) {
            return bVar;
        } else {
            return b(bVar, new FlowKt__DelayKt$debounce$2(j10));
        }
    }

    private static final <T> b<T> b(b<? extends T> bVar, Function1<? super T, Long> function1) {
        return FlowCoroutineKt.b(new FlowKt__DelayKt$debounceInternal$1(function1, bVar, (c<? super FlowKt__DelayKt$debounceInternal$1>) null));
    }
}
