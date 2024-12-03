package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.SortedBag;

public abstract class AbstractSortedBagDecorator extends AbstractBagDecorator implements SortedBag {
    protected AbstractSortedBagDecorator() {
    }

    public Comparator comparator() {
        return getSortedBag().comparator();
    }

    public Object first() {
        return getSortedBag().first();
    }

    /* access modifiers changed from: protected */
    public SortedBag getSortedBag() {
        return (SortedBag) getCollection();
    }

    public Object last() {
        return getSortedBag().last();
    }

    protected AbstractSortedBagDecorator(SortedBag sortedBag) {
        super(sortedBag);
    }
}
