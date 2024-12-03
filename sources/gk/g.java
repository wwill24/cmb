package gk;

import kotlin.Result;
import kotlin.jvm.internal.j;

public final class g {
    public static final Object a(Throwable th2) {
        j.g(th2, "exception");
        return new Result.Failure(th2);
    }

    public static final void b(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
