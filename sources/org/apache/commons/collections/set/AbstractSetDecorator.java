package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

public abstract class AbstractSetDecorator extends AbstractCollectionDecorator implements Set {
    protected AbstractSetDecorator() {
    }

    /* access modifiers changed from: protected */
    public Set getSet() {
        return (Set) getCollection();
    }

    protected AbstractSetDecorator(Set set) {
        super(set);
    }
}
