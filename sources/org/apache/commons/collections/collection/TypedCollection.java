package org.apache.commons.collections.collection;

import java.util.Collection;
import org.apache.commons.collections.functors.InstanceofPredicate;

public class TypedCollection {
    protected TypedCollection() {
    }

    public static Collection decorate(Collection collection, Class cls) {
        return new PredicatedCollection(collection, InstanceofPredicate.getInstance(cls));
    }
}
