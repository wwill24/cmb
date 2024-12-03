package androidx.lifecycle;

import com.mparticle.identity.IdentityHttpResponse;
import java.io.Closeable;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;

public final class c implements Closeable, k0 {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f6009a;

    public c(CoroutineContext coroutineContext) {
        j.g(coroutineContext, IdentityHttpResponse.CONTEXT);
        this.f6009a = coroutineContext;
    }

    public CoroutineContext G() {
        return this.f6009a;
    }

    public void close() {
        x1.d(G(), (CancellationException) null, 1, (Object) null);
    }
}
