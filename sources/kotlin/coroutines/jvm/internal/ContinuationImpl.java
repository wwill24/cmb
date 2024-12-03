package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.j;

public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient c<Object> intercepted;

    public ContinuationImpl(c<Object> cVar, CoroutineContext coroutineContext) {
        super(cVar);
        this._context = coroutineContext;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        j.d(coroutineContext);
        return coroutineContext;
    }

    public final c<Object> intercepted() {
        c<Object> cVar = this.intercepted;
        if (cVar == null) {
            d dVar = (d) getContext().c(d.f32074s);
            if (dVar == null || (cVar = dVar.g(this)) == null) {
                cVar = this;
            }
            this.intercepted = cVar;
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
        c<Object> cVar = this.intercepted;
        if (!(cVar == null || cVar == this)) {
            CoroutineContext.Element c10 = getContext().c(d.f32074s);
            j.d(c10);
            ((d) c10).e(cVar);
        }
        this.intercepted = b.f32083a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ContinuationImpl(c<Object> cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }
}
