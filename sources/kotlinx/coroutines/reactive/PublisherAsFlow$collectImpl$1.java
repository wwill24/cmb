package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.reactive.PublisherAsFlow", f = "ReactiveFlow.kt", l = {98, 100}, m = "collectImpl")
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final class PublisherAsFlow$collectImpl$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PublisherAsFlow<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PublisherAsFlow$collectImpl$1(PublisherAsFlow<T> publisherAsFlow, c<? super PublisherAsFlow$collectImpl$1> cVar) {
        super(cVar);
        this.this$0 = publisherAsFlow;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p((CoroutineContext) null, (kotlinx.coroutines.flow.c) null, this);
    }
}
