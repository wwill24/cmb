package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.p2;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/internal/l0;", "state", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "a", "(Lkotlinx/coroutines/internal/l0;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlinx/coroutines/internal/l0;"}, k = 3, mv = {1, 6, 0})
final class ThreadContextKt$updateState$1 extends Lambda implements Function2<l0, CoroutineContext.Element, l0> {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadContextKt$updateState$1 f32513a = new ThreadContextKt$updateState$1();

    ThreadContextKt$updateState$1() {
        super(2);
    }

    /* renamed from: a */
    public final l0 invoke(l0 l0Var, CoroutineContext.Element element) {
        if (element instanceof p2) {
            p2 p2Var = (p2) element;
            l0Var.a(p2Var, p2Var.x0(l0Var.f32544a));
        }
        return l0Var;
    }
}
