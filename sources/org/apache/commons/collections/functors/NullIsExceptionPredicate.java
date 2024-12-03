package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Predicate;

public final class NullIsExceptionPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = 3243449850504576071L;
    private final Predicate iPredicate;

    public NullIsExceptionPredicate(Predicate predicate) {
        this.iPredicate = predicate;
    }

    public static Predicate getInstance(Predicate predicate) {
        if (predicate != null) {
            return new NullIsExceptionPredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public boolean evaluate(Object obj) {
        if (obj != null) {
            return this.iPredicate.evaluate(obj);
        }
        throw new FunctorException("Input Object must not be null");
    }

    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
