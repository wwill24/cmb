package org.apache.commons.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class ProxyMap implements Map {
    protected Map map;

    public ProxyMap(Map map2) {
        this.map = map2;
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
        return this.map.equals(obj);
    }

    public Object get(Object obj) {
        return this.map.get(obj);
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

    public Collection values() {
        return this.map.values();
    }
}
