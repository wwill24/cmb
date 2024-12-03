package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections.collection.SynchronizedCollection;

public class SynchronizedSortedSet extends SynchronizedCollection implements SortedSet {
    private static final long serialVersionUID = 2775582861954500111L;

    protected SynchronizedSortedSet(SortedSet sortedSet) {
        super(sortedSet);
    }

    public static SortedSet decorate(SortedSet sortedSet) {
        return new SynchronizedSortedSet(sortedSet);
    }

    public Comparator comparator() {
        Comparator comparator;
        synchronized (this.lock) {
            comparator = getSortedSet().comparator();
        }
        return comparator;
    }

    public Object first() {
        Object first;
        synchronized (this.lock) {
            first = getSortedSet().first();
        }
        return first;
    }

    /* access modifiers changed from: protected */
    public SortedSet getSortedSet() {
        return (SortedSet) this.collection;
    }

    public SortedSet headSet(Object obj) {
        SynchronizedSortedSet synchronizedSortedSet;
        synchronized (this.lock) {
            synchronizedSortedSet = new SynchronizedSortedSet(getSortedSet().headSet(obj), this.lock);
        }
        return synchronizedSortedSet;
    }

    public Object last() {
        Object last;
        synchronized (this.lock) {
            last = getSortedSet().last();
        }
        return last;
    }

    public SortedSet subSet(Object obj, Object obj2) {
        SynchronizedSortedSet synchronizedSortedSet;
        synchronized (this.lock) {
            synchronizedSortedSet = new SynchronizedSortedSet(getSortedSet().subSet(obj, obj2), this.lock);
        }
        return synchronizedSortedSet;
    }

    public SortedSet tailSet(Object obj) {
        SynchronizedSortedSet synchronizedSortedSet;
        synchronized (this.lock) {
            synchronizedSortedSet = new SynchronizedSortedSet(getSortedSet().tailSet(obj), this.lock);
        }
        return synchronizedSortedSet;
    }

    protected SynchronizedSortedSet(SortedSet sortedSet, Object obj) {
        super(sortedSet, obj);
    }
}
