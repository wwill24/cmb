package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;

public final class ExceptionFactory implements Factory, Serializable {
    public static final Factory INSTANCE = new ExceptionFactory();
    private static final long serialVersionUID = 7179106032121985545L;

    private ExceptionFactory() {
    }

    public static Factory getInstance() {
        return INSTANCE;
    }

    public Object create() {
        throw new FunctorException("ExceptionFactory invoked");
    }
}
