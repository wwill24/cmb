package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.map.AbstractMapDecorator;

public abstract class AbstractBidiMapDecorator extends AbstractMapDecorator implements BidiMap {
    protected AbstractBidiMapDecorator(BidiMap bidiMap) {
        super(bidiMap);
    }

    /* access modifiers changed from: protected */
    public BidiMap getBidiMap() {
        return (BidiMap) this.map;
    }

    public Object getKey(Object obj) {
        return getBidiMap().getKey(obj);
    }

    public BidiMap inverseBidiMap() {
        return getBidiMap().inverseBidiMap();
    }

    public MapIterator mapIterator() {
        return getBidiMap().mapIterator();
    }

    public Object removeValue(Object obj) {
        return getBidiMap().removeValue(obj);
    }
}
