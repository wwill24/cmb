package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

public final class BooleanComparator implements Comparator, Serializable {
    private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);
    private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);
    private static final long serialVersionUID = 1830042991606340609L;
    private boolean trueFirst;

    public BooleanComparator() {
        this(false);
    }

    public static BooleanComparator getBooleanComparator(boolean z10) {
        return z10 ? TRUE_FIRST : FALSE_FIRST;
    }

    public static BooleanComparator getFalseFirstComparator() {
        return FALSE_FIRST;
    }

    public static BooleanComparator getTrueFirstComparator() {
        return TRUE_FIRST;
    }

    public int compare(Object obj, Object obj2) {
        return compare((Boolean) obj, (Boolean) obj2);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof BooleanComparator) && this.trueFirst == ((BooleanComparator) obj).trueFirst);
    }

    public int hashCode() {
        return this.trueFirst ? -478003966 : 478003966;
    }

    public boolean sortsTrueFirst() {
        return this.trueFirst;
    }

    public BooleanComparator(boolean z10) {
        this.trueFirst = z10;
    }

    public int compare(Boolean bool, Boolean bool2) {
        boolean booleanValue = bool.booleanValue();
        if (bool2.booleanValue() ^ booleanValue) {
            return booleanValue ^ this.trueFirst ? 1 : -1;
        }
        return 0;
    }
}
