package org.apache.commons.collections;

public interface OrderedMap extends IterableMap {
    Object firstKey();

    Object lastKey();

    Object nextKey(Object obj);

    OrderedMapIterator orderedMapIterator();

    Object previousKey(Object obj);
}
