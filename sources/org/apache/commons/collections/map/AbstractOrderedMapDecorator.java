package org.apache.commons.collections.map;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;

public abstract class AbstractOrderedMapDecorator extends AbstractMapDecorator implements OrderedMap {
    protected AbstractOrderedMapDecorator() {
    }

    public Object firstKey() {
        return getOrderedMap().firstKey();
    }

    /* access modifiers changed from: protected */
    public OrderedMap getOrderedMap() {
        return (OrderedMap) this.map;
    }

    public Object lastKey() {
        return getOrderedMap().lastKey();
    }

    public MapIterator mapIterator() {
        return getOrderedMap().mapIterator();
    }

    public Object nextKey(Object obj) {
        return getOrderedMap().nextKey(obj);
    }

    public OrderedMapIterator orderedMapIterator() {
        return getOrderedMap().orderedMapIterator();
    }

    public Object previousKey(Object obj) {
        return getOrderedMap().previousKey(obj);
    }

    public AbstractOrderedMapDecorator(OrderedMap orderedMap) {
        super(orderedMap);
    }
}
