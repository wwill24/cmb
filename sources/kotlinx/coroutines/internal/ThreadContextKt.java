package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.p2;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\u000b\u001a\u00020\t8\u0000X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n\"*\u0010\u000f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e\"2\u0010\u0011\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0010\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00100\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e\"&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "b", "countOrElement", "c", "oldState", "", "a", "Lkotlinx/coroutines/internal/f0;", "Lkotlinx/coroutines/internal/f0;", "NO_THREAD_ELEMENTS", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/jvm/functions/Function2;", "countAll", "Lkotlinx/coroutines/p2;", "findOne", "Lkotlinx/coroutines/internal/l0;", "d", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ThreadContextKt {

    /* renamed from: a  reason: collision with root package name */
    public static final f0 f32507a = new f0("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    private static final Function2<Object, CoroutineContext.Element, Object> f32508b = ThreadContextKt$countAll$1.f32511a;

    /* renamed from: c  reason: collision with root package name */
    private static final Function2<p2<?>, CoroutineContext.Element, p2<?>> f32509c = ThreadContextKt$findOne$1.f32512a;

    /* renamed from: d  reason: collision with root package name */
    private static final Function2<l0, CoroutineContext.Element, l0> f32510d = ThreadContextKt$updateState$1.f32513a;

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj != f32507a) {
            if (obj instanceof l0) {
                ((l0) obj).b(coroutineContext);
                return;
            }
            Object v02 = coroutineContext.v0(null, f32509c);
            if (v02 != null) {
                ((p2) v02).I(coroutineContext, obj);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object v02 = coroutineContext.v0(0, f32508b);
        j.d(v02);
        return v02;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f32507a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.v0(new l0(coroutineContext, ((Number) obj).intValue()), f32510d);
        }
        return ((p2) obj).x0(coroutineContext);
    }
}
