package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.SortedBag;

public class SynchronizedSortedBag extends SynchronizedBag implements SortedBag {
    private static final long serialVersionUID = 722374056718497858L;

    protected SynchronizedSortedBag(SortedBag sortedBag) {
        super(sortedBag);
    }

    public static SortedBag decorate(SortedBag sortedBag) {
        return new SynchronizedSortedBag(sortedBag);
    }

    public synchronized Comparator comparator() {
        Comparator comparator;
        synchronized (this.lock) {
            comparator = getSortedBag().comparator();
        }
        return comparator;
    }

    public synchronized Object first() {
        Object first;
        synchronized (this.lock) {
            first = getSortedBag().first();
        }
        return first;
    }

    /* access modifiers changed from: protected */
    public SortedBag getSortedBag() {
        return (SortedBag) this.collection;
    }

    public synchronized Object last() {
        Object last;
        synchronized (this.lock) {
            last = getSortedBag().last();
        }
        return last;
    }

    protected SynchronizedSortedBag(Bag bag, Object obj) {
        super(bag, obj);
    }
}
