package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class NullComparator implements Comparator, Serializable {
    private static final long serialVersionUID = -5820772575483504339L;
    private Comparator nonNullComparator;
    private boolean nullsAreHigh;

    public NullComparator() {
        this(ComparableComparator.getInstance(), true);
    }

    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            if (this.nullsAreHigh) {
                return 1;
            }
            return -1;
        } else if (obj2 != null) {
            return this.nonNullComparator.compare(obj, obj2);
        } else {
            if (this.nullsAreHigh) {
                return -1;
            }
            return 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        NullComparator nullComparator = (NullComparator) obj;
        if (this.nullsAreHigh != nullComparator.nullsAreHigh || !this.nonNullComparator.equals(nullComparator.nonNullComparator)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.nullsAreHigh ? -1 : 1) * this.nonNullComparator.hashCode();
    }

    public NullComparator(Comparator comparator) {
        this(comparator, true);
    }

    public NullComparator(boolean z10) {
        this(ComparableComparator.getInstance(), z10);
    }

    public NullComparator(Comparator comparator, boolean z10) {
        this.nonNullComparator = comparator;
        this.nullsAreHigh = z10;
        if (comparator == null) {
            throw new NullPointerException("null nonNullComparator");
        }
    }
}
