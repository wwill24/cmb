package org.apache.commons.collections.bag;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.functors.InstanceofPredicate;

public class TypedBag {
    protected TypedBag() {
    }

    public static Bag decorate(Bag bag, Class cls) {
        return new PredicatedBag(bag, InstanceofPredicate.getInstance(cls));
    }
}
