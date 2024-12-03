package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import org.apache.commons.collections.comparators.BooleanComparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.collections.comparators.TransformingComparator;

public class ComparatorUtils {
    public static final Comparator NATURAL_COMPARATOR = ComparableComparator.getInstance();

    public static Comparator booleanComparator(boolean z10) {
        return BooleanComparator.getBooleanComparator(z10);
    }

    public static Comparator chainedComparator(Comparator comparator, Comparator comparator2) {
        return chainedComparator(new Comparator[]{comparator, comparator2});
    }

    public static Object max(Object obj, Object obj2, Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        if (comparator.compare(obj, obj2) > 0) {
            return obj;
        }
        return obj2;
    }

    public static Object min(Object obj, Object obj2, Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        if (comparator.compare(obj, obj2) < 0) {
            return obj;
        }
        return obj2;
    }

    public static Comparator naturalComparator() {
        return NATURAL_COMPARATOR;
    }

    public static Comparator nullHighComparator(Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, true);
    }

    public static Comparator nullLowComparator(Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, false);
    }

    public static Comparator reversedComparator(Comparator comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new ReverseComparator(comparator);
    }

    public static Comparator transformedComparator(Comparator comparator, Transformer transformer) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new TransformingComparator(transformer, comparator);
    }

    public static Comparator chainedComparator(Comparator[] comparatorArr) {
        ComparatorChain comparatorChain = new ComparatorChain();
        int i10 = 0;
        while (i10 < comparatorArr.length) {
            Comparator comparator = comparatorArr[i10];
            if (comparator != null) {
                comparatorChain.addComparator(comparator);
                i10++;
            } else {
                throw new NullPointerException("Comparator cannot be null");
            }
        }
        return comparatorChain;
    }

    public static Comparator chainedComparator(Collection collection) {
        return chainedComparator((Comparator[]) collection.toArray(new Comparator[collection.size()]));
    }
}
