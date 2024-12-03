package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlinx.coroutines.channels.q;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0001¨\u0006\u0006"}, d2 = {"T", "Lrn/a;", "", "request", "Lkotlinx/coroutines/channels/q;", "a", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 6, 0})
public final class a {
    public static final <T> q<T> a(rn.a<T> aVar, int i10) {
        d dVar = new d(i10);
        aVar.a(dVar);
        return dVar;
    }

    public static /* synthetic */ q b(rn.a aVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return a(aVar, i10);
    }
}
