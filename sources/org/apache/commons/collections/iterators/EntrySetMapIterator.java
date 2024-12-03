package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;

public class EntrySetMapIterator implements MapIterator, ResettableIterator {
    private boolean canRemove = false;
    private Iterator iterator;
    private Map.Entry last;
    private final Map map;

    public EntrySetMapIterator(Map map2) {
        this.map = map2;
        this.iterator = map2.entrySet().iterator();
    }

    public Object getKey() {
        Map.Entry entry = this.last;
        if (entry != null) {
            return entry.getKey();
        }
        throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
    }

    public Object getValue() {
        Map.Entry entry = this.last;
        if (entry != null) {
            return entry.getValue();
        }
        throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public Object next() {
        Map.Entry entry = (Map.Entry) this.iterator.next();
        this.last = entry;
        this.canRemove = true;
        return entry.getKey();
    }

    public void remove() {
        if (this.canRemove) {
            this.iterator.remove();
            this.last = null;
            this.canRemove = false;
            return;
        }
        throw new IllegalStateException("Iterator remove() can only be called once after next()");
    }

    public void reset() {
        this.iterator = this.map.entrySet().iterator();
        this.last = null;
        this.canRemove = false;
    }

    public Object setValue(Object obj) {
        Map.Entry entry = this.last;
        if (entry != null) {
            return entry.setValue(obj);
        }
        throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
    }

    public String toString() {
        if (this.last == null) {
            return "MapIterator[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapIterator[");
        stringBuffer.append(getKey());
        stringBuffer.append("=");
        stringBuffer.append(getValue());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
