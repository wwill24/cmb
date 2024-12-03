package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;

public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(c<Object> cVar) {
        super(cVar);
        boolean z10;
        if (cVar != null) {
            if (cVar.getContext() == EmptyCoroutineContext.f32070a) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f32070a;
    }
}
