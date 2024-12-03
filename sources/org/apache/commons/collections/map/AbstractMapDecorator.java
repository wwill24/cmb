package org.apache.commons.collections.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapDecorator implements Map {
    protected transient Map map;

    protected AbstractMapDecorator() {
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set entrySet() {
        return this.map.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.map.equals(obj);
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    /* access modifiers changed from: protected */
    public Map getMap() {
        return this.map;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set keySet() {
        return this.map.keySet();
    }

    public Object put(Object obj, Object obj2) {
        return this.map.put(obj, obj2);
    }

    public void putAll(Map map2) {
        this.map.putAll(map2);
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public int size() {
        return this.map.size();
    }

    public String toString() {
        return this.map.toString();
    }

    public Collection values() {
        return this.map.values();
    }

    public AbstractMapDecorator(Map map2) {
        if (map2 != null) {
            this.map = map2;
            return;
        }
        throw new IllegalArgumentException("Map must not be null");
    }
}
