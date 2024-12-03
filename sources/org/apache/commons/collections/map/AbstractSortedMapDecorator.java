package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.SortedMap;

public abstract class AbstractSortedMapDecorator extends AbstractMapDecorator implements SortedMap {
    protected AbstractSortedMapDecorator() {
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
        return getSortedMap().headMap(obj);
    }

    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return getSortedMap().subMap(obj, obj2);
    }

    public SortedMap tailMap(Object obj) {
        return getSortedMap().tailMap(obj);
    }

    public AbstractSortedMapDecorator(SortedMap sortedMap) {
        super(sortedMap);
    }
}
