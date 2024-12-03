package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "a", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext;"}, k = 3, mv = {1, 6, 0})
final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext> {
    final /* synthetic */ boolean $isNewCoroutine;
    final /* synthetic */ Ref$ObjectRef<CoroutineContext> $leftoverContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineContextKt$foldCopies$folded$1(Ref$ObjectRef<CoroutineContext> ref$ObjectRef, boolean z10) {
        super(2);
        this.$leftoverContext = ref$ObjectRef;
        this.$isNewCoroutine = z10;
    }

    /* renamed from: a */
    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        if (!(element instanceof f0)) {
            return coroutineContext.e0(element);
        }
        CoroutineContext.Element c10 = ((CoroutineContext) this.$leftoverContext.element).c(element.getKey());
        if (c10 == null) {
            f0 f0Var = (f0) element;
            if (this.$isNewCoroutine) {
                f0Var = f0Var.C();
            }
            return coroutineContext.e0(f0Var);
        }
        Ref$ObjectRef<CoroutineContext> ref$ObjectRef = this.$leftoverContext;
        ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).u0(element.getKey());
        return coroutineContext.e0(((f0) element).h(c10));
    }
}
