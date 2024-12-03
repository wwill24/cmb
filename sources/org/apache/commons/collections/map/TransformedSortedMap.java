package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.apache.commons.collections.Transformer;

public class TransformedSortedMap extends TransformedMap implements SortedMap {
    private static final long serialVersionUID = -8751771676410385778L;

    protected TransformedSortedMap(SortedMap sortedMap, Transformer transformer, Transformer transformer2) {
        super(sortedMap, transformer, transformer2);
    }

    public static SortedMap decorate(SortedMap sortedMap, Transformer transformer, Transformer transformer2) {
        return new TransformedSortedMap(sortedMap, transformer, transformer2);
    }

    public static SortedMap decorateTransform(SortedMap sortedMap, Transformer transformer, Transformer transformer2) {
        TransformedSortedMap transformedSortedMap = new TransformedSortedMap(sortedMap, transformer, transformer2);
        if (sortedMap.size() > 0) {
            Map transformMap = transformedSortedMap.transformMap(sortedMap);
            transformedSortedMap.clear();
            transformedSortedMap.getMap().putAll(transformMap);
        }
        return transformedSortedMap;
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
        return new TransformedSortedMap(getSortedMap().headMap(obj), this.keyTransformer, this.valueTransformer);
    }

    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new TransformedSortedMap(getSortedMap().subMap(obj, obj2), this.keyTransformer, this.valueTransformer);
    }

    public SortedMap tailMap(Object obj) {
        return new TransformedSortedMap(getSortedMap().tailMap(obj), this.keyTransformer, this.valueTransformer);
    }
}
