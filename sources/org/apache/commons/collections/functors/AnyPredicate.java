package org.apache.commons.collections.functors;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.collections.Predicate;

public final class AnyPredicate implements Predicate, PredicateDecorator, Serializable {
    private static final long serialVersionUID = 7429999530934647542L;
    private final Predicate[] iPredicates;

    public AnyPredicate(Predicate[] predicateArr) {
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
        return new AnyPredicate(FunctorUtils.copy(predicateArr));
    }

    public boolean evaluate(Object obj) {
        int i10 = 0;
        while (true) {
            Predicate[] predicateArr = this.iPredicates;
            if (i10 >= predicateArr.length) {
                return false;
            }
            if (predicateArr[i10].evaluate(obj)) {
                return true;
            }
            i10++;
        }
    }

    public Predicate[] getPredicates() {
        return this.iPredicates;
    }

    public static Predicate getInstance(Collection collection) {
        Predicate[] validate = FunctorUtils.validate(collection);
        if (validate.length == 0) {
            return FalsePredicate.INSTANCE;
        }
        if (validate.length == 1) {
            return validate[0];
        }
        return new AnyPredicate(validate);
    }
}
