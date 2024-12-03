package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMapIterator;

public abstract class AbstractOrderedBidiMapDecorator extends AbstractBidiMapDecorator implements OrderedBidiMap {
    protected AbstractOrderedBidiMapDecorator(OrderedBidiMap orderedBidiMap) {
        super(orderedBidiMap);
    }

    public Object firstKey() {
        return getOrderedBidiMap().firstKey();
    }

    /* access modifiers changed from: protected */
    public OrderedBidiMap getOrderedBidiMap() {
        return (OrderedBidiMap) this.map;
    }

    public OrderedBidiMap inverseOrderedBidiMap() {
        return getOrderedBidiMap().inverseOrderedBidiMap();
    }

    public Object lastKey() {
        return getOrderedBidiMap().lastKey();
    }

    public Object nextKey(Object obj) {
        return getOrderedBidiMap().nextKey(obj);
    }

    public OrderedMapIterator orderedMapIterator() {
        return getOrderedBidiMap().orderedMapIterator();
    }

    public Object previousKey(Object obj) {
        return getOrderedBidiMap().previousKey(obj);
    }
}
