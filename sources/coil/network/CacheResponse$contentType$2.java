package coil.network;

import com.facebook.stetho.server.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.v;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lokhttp3/v;", "a", "()Lokhttp3/v;"}, k = 3, mv = {1, 7, 1})
final class CacheResponse$contentType$2 extends Lambda implements Function0<v> {
    final /* synthetic */ CacheResponse this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CacheResponse$contentType$2(CacheResponse cacheResponse) {
        super(0);
        this.this$0 = cacheResponse;
    }

    /* renamed from: a */
    public final v invoke() {
        String b10 = this.this$0.d().b(HttpHeaders.CONTENT_TYPE);
        if (b10 != null) {
            return v.f33190e.b(b10);
        }
        return null;
    }
}
