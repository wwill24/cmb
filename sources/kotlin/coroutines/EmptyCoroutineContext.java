package kotlin.coroutines;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;

public final class EmptyCoroutineContext implements CoroutineContext, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptyCoroutineContext f32070a = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return f32070a;
    }

    public <E extends CoroutineContext.Element> E c(CoroutineContext.a<E> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        return null;
    }

    public CoroutineContext e0(CoroutineContext coroutineContext) {
        j.g(coroutineContext, IdentityHttpResponse.CONTEXT);
        return coroutineContext;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }

    public CoroutineContext u0(CoroutineContext.a<?> aVar) {
        j.g(aVar, SDKConstants.PARAM_KEY);
        return this;
    }

    public <R> R v0(R r10, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        j.g(function2, "operation");
        return r10;
    }
}
