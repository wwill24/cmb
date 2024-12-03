package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.Transformer;

public class TransformedSortedBag extends TransformedBag implements SortedBag {
    private static final long serialVersionUID = -251737742649401930L;

    protected TransformedSortedBag(SortedBag sortedBag, Transformer transformer) {
        super(sortedBag, transformer);
    }

    public static SortedBag decorate(SortedBag sortedBag, Transformer transformer) {
        return new TransformedSortedBag(sortedBag, transformer);
    }

    public Comparator comparator() {
        return getSortedBag().comparator();
    }

    public Object first() {
        return getSortedBag().first();
    }

    /* access modifiers changed from: protected */
    public SortedBag getSortedBag() {
        return (SortedBag) this.collection;
    }

    public Object last() {
        return getSortedBag().last();
    }
}
