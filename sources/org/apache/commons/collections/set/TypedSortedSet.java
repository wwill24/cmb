package org.apache.commons.collections.set;

import java.util.SortedSet;
import org.apache.commons.collections.functors.InstanceofPredicate;

public class TypedSortedSet {
    protected TypedSortedSet() {
    }

    public static SortedSet decorate(SortedSet sortedSet, Class cls) {
        return new PredicatedSortedSet(sortedSet, InstanceofPredicate.getInstance(cls));
    }
}
