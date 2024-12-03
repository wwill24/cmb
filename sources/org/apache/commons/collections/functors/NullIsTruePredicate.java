package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

public final class NullIsTruePredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -7625133768987126273L;
    private final Predicate iPredicate;

    public NullIsTruePredicate(Predicate predicate) {
        this.iPredicate = predicate;
    }

    public static Predicate getInstance(Predicate predicate) {
        if (predicate != null) {
            return new NullIsTruePredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public boolean evaluate(Object obj) {
        if (obj == null) {
            return true;
        }
        return this.iPredicate.evaluate(obj);
    }

    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
