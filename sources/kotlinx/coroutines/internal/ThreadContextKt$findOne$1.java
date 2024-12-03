package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.p2;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\f\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/p2;", "found", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "a", "(Lkotlinx/coroutines/p2;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlinx/coroutines/p2;"}, k = 3, mv = {1, 6, 0})
final class ThreadContextKt$findOne$1 extends Lambda implements Function2<p2<?>, CoroutineContext.Element, p2<?>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadContextKt$findOne$1 f32512a = new ThreadContextKt$findOne$1();

    ThreadContextKt$findOne$1() {
        super(2);
    }

    /* renamed from: a */
    public final p2<?> invoke(p2<?> p2Var, CoroutineContext.Element element) {
        if (p2Var != null) {
            return p2Var;
        }
        if (element instanceof p2) {
            return (p2) element;
        }
        return null;
    }
}
