package coil.fetch;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import okhttp3.y;

@d(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", l = {223}, m = "executeNetworkRequest")
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
final class HttpUriFetcher$executeNetworkRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpUriFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpUriFetcher$executeNetworkRequest$1(HttpUriFetcher httpUriFetcher, c<? super HttpUriFetcher$executeNetworkRequest$1> cVar) {
        super(cVar);
        this.this$0 = httpUriFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((y) null, this);
    }
}
