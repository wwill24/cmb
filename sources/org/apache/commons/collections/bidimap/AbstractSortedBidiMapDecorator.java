package org.apache.commons.collections.bidimap;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections.SortedBidiMap;

public abstract class AbstractSortedBidiMapDecorator extends AbstractOrderedBidiMapDecorator implements SortedBidiMap {
    public AbstractSortedBidiMapDecorator(SortedBidiMap sortedBidiMap) {
        super(sortedBidiMap);
    }

    public Comparator comparator() {
        return getSortedBidiMap().comparator();
    }

    /* access modifiers changed from: protected */
    public SortedBidiMap getSortedBidiMap() {
        return (SortedBidiMap) this.map;
    }

    public SortedMap headMap(Object obj) {
        return getSortedBidiMap().headMap(obj);
    }

    public SortedBidiMap inverseSortedBidiMap() {
        return getSortedBidiMap().inverseSortedBidiMap();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return getSortedBidiMap().subMap(obj, obj2);
    }

    public SortedMap tailMap(Object obj) {
        return getSortedBidiMap().tailMap(obj);
    }
}
