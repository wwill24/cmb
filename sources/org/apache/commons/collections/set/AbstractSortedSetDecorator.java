package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

public abstract class AbstractSortedSetDecorator extends AbstractSetDecorator implements SortedSet {
    protected AbstractSortedSetDecorator() {
    }

    public Comparator comparator() {
        return getSortedSet().comparator();
    }

    public Object first() {
        return getSortedSet().first();
    }

    /* access modifiers changed from: protected */
    public SortedSet getSortedSet() {
        return (SortedSet) getCollection();
    }

    public SortedSet headSet(Object obj) {
        return getSortedSet().headSet(obj);
    }

    public Object last() {
        return getSortedSet().last();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return getSortedSet().subSet(obj, obj2);
    }

    public SortedSet tailSet(Object obj) {
        return getSortedSet().tailSet(obj);
    }

    protected AbstractSortedSetDecorator(Set set) {
        super(set);
    }
}
