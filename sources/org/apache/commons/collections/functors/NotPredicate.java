package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

public final class NotPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -2654603322338049674L;
    private final Predicate iPredicate;

    public NotPredicate(Predicate predicate) {
        this.iPredicate = predicate;
    }

    public static Predicate getInstance(Predicate predicate) {
        if (predicate != null) {
            return new NotPredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public boolean evaluate(Object obj) {
        return !this.iPredicate.evaluate(obj);
    }

    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
