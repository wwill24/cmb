package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

public class ComparableComparator implements Comparator, Serializable {
    private static final ComparableComparator instance = new ComparableComparator();
    private static final long serialVersionUID = -291439688585137865L;

    public static ComparableComparator getInstance() {
        return instance;
    }

    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo(obj2);
    }

    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass().equals(getClass()));
    }

    public int hashCode() {
        return 1769708912;
    }
}
