package org.apache.commons.collections.bag;

import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.functors.InstanceofPredicate;

public class TypedSortedBag {
    protected TypedSortedBag() {
    }

    public static SortedBag decorate(SortedBag sortedBag, Class cls) {
        return new PredicatedSortedBag(sortedBag, InstanceofPredicate.getInstance(cls));
    }
}
