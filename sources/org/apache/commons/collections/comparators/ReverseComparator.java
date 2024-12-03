package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class ReverseComparator implements Comparator, Serializable {
    private static final long serialVersionUID = 2858887242028539265L;
    private Comparator comparator;

    public ReverseComparator() {
        this((Comparator) null);
    }

    public int compare(Object obj, Object obj2) {
        return this.comparator.compare(obj2, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            return this.comparator.equals(((ReverseComparator) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode() ^ 175311160;
    }

    public ReverseComparator(Comparator comparator2) {
        if (comparator2 != null) {
            this.comparator = comparator2;
        } else {
            this.comparator = ComparableComparator.getInstance();
        }
    }
}
