package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.reactive.ReactiveSubscriber", f = "ReactiveFlow.kt", l = {129}, m = "takeNextOrNull")
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final class ReactiveSubscriber$takeNextOrNull$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReactiveSubscriber<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReactiveSubscriber$takeNextOrNull$1(ReactiveSubscriber<T> reactiveSubscriber, c<? super ReactiveSubscriber$takeNextOrNull$1> cVar) {
        super(cVar);
        this.this$0 = reactiveSubscriber;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
