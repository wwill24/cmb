package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

public final class NullIsFalsePredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -2997501534564735525L;
    private final Predicate iPredicate;

    public NullIsFalsePredicate(Predicate predicate) {
        this.iPredicate = predicate;
    }

    public static Predicate getInstance(Predicate predicate) {
        if (predicate != null) {
            return new NullIsFalsePredicate(predicate);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public boolean evaluate(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.iPredicate.evaluate(obj);
    }

    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
