package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

public final class AndPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = 4189014213763186912L;
    private final Predicate iPredicate1;
    private final Predicate iPredicate2;

    public AndPredicate(Predicate predicate, Predicate predicate2) {
        this.iPredicate1 = predicate;
        this.iPredicate2 = predicate2;
    }

    public static Predicate getInstance(Predicate predicate, Predicate predicate2) {
        if (predicate != null && predicate2 != null) {
            return new AndPredicate(predicate, predicate2);
        }
        throw new IllegalArgumentException("Predicate must not be null");
    }

    public boolean evaluate(Object obj) {
        return this.iPredicate1.evaluate(obj) && this.iPredicate2.evaluate(obj);
    }

    public Predicate[] getPredicates() {
        return new Predicate[]{this.iPredicate1, this.iPredicate2};
    }
}
