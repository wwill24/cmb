package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;

public class IfClosure implements Closure, Serializable {
    private static final long serialVersionUID = 3518477308466486130L;
    private final Closure iFalseClosure;
    private final Predicate iPredicate;
    private final Closure iTrueClosure;

    public IfClosure(Predicate predicate, Closure closure) {
        this(predicate, closure, NOPClosure.INSTANCE);
    }

    public static Closure getInstance(Predicate predicate, Closure closure) {
        return getInstance(predicate, closure, NOPClosure.INSTANCE);
    }

    public void execute(Object obj) {
        if (this.iPredicate.evaluate(obj)) {
            this.iTrueClosure.execute(obj);
        } else {
            this.iFalseClosure.execute(obj);
        }
    }

    public Closure getFalseClosure() {
        return this.iFalseClosure;
    }

    public Predicate getPredicate() {
        return this.iPredicate;
    }

    public Closure getTrueClosure() {
        return this.iTrueClosure;
    }

    public IfClosure(Predicate predicate, Closure closure, Closure closure2) {
        this.iPredicate = predicate;
        this.iTrueClosure = closure;
        this.iFalseClosure = closure2;
    }

    public static Closure getInstance(Predicate predicate, Closure closure, Closure closure2) {
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        } else if (closure != null && closure2 != null) {
            return new IfClosure(predicate, closure, closure2);
        } else {
            throw new IllegalArgumentException("Closures must not be null");
        }
    }
}
