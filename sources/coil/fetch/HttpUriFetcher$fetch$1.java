package coil.fetch;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {76, 105}, m = "fetch")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final class HttpUriFetcher$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpUriFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpUriFetcher$fetch$1(HttpUriFetcher httpUriFetcher, c<? super HttpUriFetcher$fetch$1> cVar) {
        super(cVar);
        this.this$0 = httpUriFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
