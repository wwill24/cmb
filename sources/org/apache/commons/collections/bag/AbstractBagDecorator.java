package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

public abstract class AbstractBagDecorator extends AbstractCollectionDecorator implements Bag {
    protected AbstractBagDecorator() {
    }

    public boolean add(Object obj, int i10) {
        return getBag().add(obj, i10);
    }

    /* access modifiers changed from: protected */
    public Bag getBag() {
        return (Bag) getCollection();
    }

    public int getCount(Object obj) {
        return getBag().getCount(obj);
    }

    public boolean remove(Object obj, int i10) {
        return getBag().remove(obj, i10);
    }

    public Set uniqueSet() {
        return getBag().uniqueSet();
    }

    protected AbstractBagDecorator(Bag bag) {
        super(bag);
    }
}
