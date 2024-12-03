package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.FunctorException;

public final class ExceptionClosure implements Closure, Serializable {
    public static final Closure INSTANCE = new ExceptionClosure();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionClosure() {
    }

    public static Closure getInstance() {
        return INSTANCE;
    }

    public void execute(Object obj) {
        throw new FunctorException("ExceptionClosure invoked");
    }
}
