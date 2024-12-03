package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections.Predicate;

public class PredicatedSortedMap extends PredicatedMap implements SortedMap {
    private static final long serialVersionUID = 3359846175935304332L;

    protected PredicatedSortedMap(SortedMap sortedMap, Predicate predicate, Predicate predicate2) {
        super(sortedMap, predicate, predicate2);
    }

    public static SortedMap decorate(SortedMap sortedMap, Predicate predicate, Predicate predicate2) {
        return new PredicatedSortedMap(sortedMap, predicate, predicate2);
    }

    public Comparator comparator() {
        return getSortedMap().comparator();
    }

    public Object firstKey() {
        return getSortedMap().firstKey();
    }

    /* access modifiers changed from: protected */
    public SortedMap getSortedMap() {
        return (SortedMap) this.map;
    }

    public SortedMap headMap(Object obj) {
        return new PredicatedSortedMap(getSortedMap().headMap(obj), this.keyPredicate, this.valuePredicate);
    }

    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new PredicatedSortedMap(getSortedMap().subMap(obj, obj2), this.keyPredicate, this.valuePredicate);
    }

    public SortedMap tailMap(Object obj) {
        return new PredicatedSortedMap(getSortedMap().tailMap(obj), this.keyPredicate, this.valuePredicate);
    }
}
