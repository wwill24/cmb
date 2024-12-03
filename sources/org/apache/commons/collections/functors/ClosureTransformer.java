package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Transformer;

public class ClosureTransformer implements Transformer, Serializable {
    private static final long serialVersionUID = 478466901448617286L;
    private final Closure iClosure;

    public ClosureTransformer(Closure closure) {
        this.iClosure = closure;
    }

    public static Transformer getInstance(Closure closure) {
        if (closure != null) {
            return new ClosureTransformer(closure);
        }
        throw new IllegalArgumentException("Closure must not be null");
    }

    public Closure getClosure() {
        return this.iClosure;
    }

    public Object transform(Object obj) {
        this.iClosure.execute(obj);
        return obj;
    }
}
