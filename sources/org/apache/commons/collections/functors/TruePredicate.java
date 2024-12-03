package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

public final class TruePredicate implements Predicate, Serializable {
    public static final Predicate INSTANCE = new TruePredicate();
    private static final long serialVersionUID = 3374767158756189740L;

    private TruePredicate() {
    }

    public static Predicate getInstance() {
        return INSTANCE;
    }

    public boolean evaluate(Object obj) {
        return true;
    }
}
