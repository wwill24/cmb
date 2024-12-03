package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;

public class LazySortedMap extends LazyMap implements SortedMap {
    private static final long serialVersionUID = 2715322183617658933L;

    protected LazySortedMap(SortedMap sortedMap, Factory factory) {
        super((Map) sortedMap, factory);
    }

    public static SortedMap decorate(SortedMap sortedMap, Factory factory) {
        return new LazySortedMap(sortedMap, factory);
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
        return new LazySortedMap(getSortedMap().headMap(obj), this.factory);
    }

    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new LazySortedMap(getSortedMap().subMap(obj, obj2), this.factory);
    }

    public SortedMap tailMap(Object obj) {
        return new LazySortedMap(getSortedMap().tailMap(obj), this.factory);
    }

    protected LazySortedMap(SortedMap sortedMap, Transformer transformer) {
        super((Map) sortedMap, transformer);
    }

    public static SortedMap decorate(SortedMap sortedMap, Transformer transformer) {
        return new LazySortedMap(sortedMap, transformer);
    }
}
