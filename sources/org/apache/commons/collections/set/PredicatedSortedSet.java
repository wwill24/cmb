package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections.Predicate;

public class PredicatedSortedSet extends PredicatedSet implements SortedSet {
    private static final long serialVersionUID = -9110948148132275052L;

    protected PredicatedSortedSet(SortedSet sortedSet, Predicate predicate) {
        super(sortedSet, predicate);
    }

    public static SortedSet decorate(SortedSet sortedSet, Predicate predicate) {
        return new PredicatedSortedSet(sortedSet, predicate);
    }

    private SortedSet getSortedSet() {
        return (SortedSet) getCollection();
    }

    public Comparator comparator() {
        return getSortedSet().comparator();
    }

    public Object first() {
        return getSortedSet().first();
    }

    public SortedSet headSet(Object obj) {
        return new PredicatedSortedSet(getSortedSet().headSet(obj), this.predicate);
    }

    public Object last() {
        return getSortedSet().last();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new PredicatedSortedSet(getSortedSet().subSet(obj, obj2), this.predicate);
    }

    public SortedSet tailSet(Object obj) {
        return new PredicatedSortedSet(getSortedSet().tailSet(obj), this.predicate);
    }
}
