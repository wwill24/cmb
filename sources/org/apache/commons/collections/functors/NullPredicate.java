package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

public final class NullPredicate implements Predicate, Serializable {
    public static final Predicate INSTANCE = new NullPredicate();
    private static final long serialVersionUID = 7533784454832764388L;

    private NullPredicate() {
    }

    public static Predicate getInstance() {
        return INSTANCE;
    }

    public boolean evaluate(Object obj) {
        return obj == null;
    }
}
