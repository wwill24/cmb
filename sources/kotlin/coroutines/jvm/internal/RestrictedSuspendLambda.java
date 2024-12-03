package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.l;

public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements g<Object> {
    private final int arity;

    public RestrictedSuspendLambda(int i10, c<Object> cVar) {
        super(cVar);
        this.arity = i10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String i10 = l.i(this);
        j.f(i10, "renderLambdaToString(this)");
        return i10;
    }
}
