package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.Predicate;

public final class OnePredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = -8125389089924745785L;
    private final Predicate[] iPredicates;

    public OnePredicate(Predicate[] predicateArr) {
        this.iPredicates = predicateArr;
    }

    public static Predicate getInstance(Predicate[] predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.INSTANCE;
        }
        if (predicateArr.length == 1) {
            return predicateArr[0];
        }
        return new OnePredicate(FunctorUtils.copy(predicateArr));
    }

    public boolean evaluate(Object obj) {
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i10 >= predicateArr.length) {
                return z10;
            }
            if (predicateArr[i10].evaluate(obj)) {
                if (z10) {
                    return false;
                }
                z10 = true;
            }
            i10++;
        }
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public static Predicate getInstance(Collection collection) {
        return new OnePredicate(FunctorUtils.validate(collection));
    }
}
