package kotlin.coroutines.jvm.internal;

import gk.g;
import java.io.Serializable;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;

public abstract class BaseContinuationImpl implements c<Object>, c, Serializable {
    private final c<Object> completion;

    public BaseContinuationImpl(c<Object> cVar) {
        this.completion = cVar;
    }

    public c<Unit> create(c<?> cVar) {
        j.g(cVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (cVar instanceof c) {
            return (c) cVar;
        }
        return null;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return e.d(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object invokeSuspend(Object obj);

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public final void resumeWith(Object obj) {
        c cVar = this;
        while (true) {
            f.b(cVar);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) cVar;
            c cVar2 = baseContinuationImpl.completion;
            j.d(cVar2);
            try {
                Object invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                if (invokeSuspend != b.d()) {
                    obj = Result.b(invokeSuspend);
                    baseContinuationImpl.releaseIntercepted();
                    if (cVar2 instanceof BaseContinuationImpl) {
                        cVar = cVar2;
                    } else {
                        cVar2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th2) {
                Result.a aVar = Result.f32010a;
                obj = Result.b(g.a(th2));
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public c<Unit> create(Object obj, c<?> cVar) {
        j.g(cVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
