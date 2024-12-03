package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.SortedBag;

public class PredicatedSortedBag extends PredicatedBag implements SortedBag {
    private static final long serialVersionUID = 3448581314086406616L;

    protected PredicatedSortedBag(SortedBag sortedBag, Predicate predicate) {
        super(sortedBag, predicate);
    }

    public static SortedBag decorate(SortedBag sortedBag, Predicate predicate) {
        return new PredicatedSortedBag(sortedBag, predicate);
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
}
