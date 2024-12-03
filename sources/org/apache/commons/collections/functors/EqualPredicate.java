package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;

public final class EqualPredicate implements Predicate, Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Object iValue;

    public EqualPredicate(Object obj) {
        this.iValue = obj;
    }

    public static Predicate getInstance(Object obj) {
        if (obj == null) {
            return NullPredicate.INSTANCE;
        }
        return new EqualPredicate(obj);
    }

    public boolean evaluate(Object obj) {
        return this.iValue.equals(obj);
    }

    public Object getValue() {
        return this.iValue;
    }
}
