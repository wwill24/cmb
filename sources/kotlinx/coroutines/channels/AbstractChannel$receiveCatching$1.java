package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {633}, m = "receiveCatching-JP2dKIU")
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final class AbstractChannel$receiveCatching$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbstractChannel<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractChannel$receiveCatching$1(AbstractChannel<E> abstractChannel, c<? super AbstractChannel$receiveCatching$1> cVar) {
        super(cVar);
        this.this$0 = abstractChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object A = this.this$0.A(this);
        return A == b.d() ? A : h.b(A);
    }
}
