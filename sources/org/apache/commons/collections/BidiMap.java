package org.apache.commons.collections;

public interface BidiMap extends IterableMap {
    Object getKey(Object obj);

    BidiMap inverseBidiMap();

    MapIterator mapIterator();

    Object put(Object obj, Object obj2);

    Object removeValue(Object obj);
}
