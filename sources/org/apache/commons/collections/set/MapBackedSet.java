package org.apache.commons.collections.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MapBackedSet implements Set, Serializable {
    private static final long serialVersionUID = 6723912213766056587L;
    protected final Object dummyValue;
    protected final Map map;

    private MapBackedSet(Map map2, Object obj) {
        this.map = map2;
        this.dummyValue = obj;
    }

    public static Set decorate(Map map2) {
        return decorate(map2, (Object) null);
    }

    public boolean add(Object obj) {
        int size = this.map.size();
        this.map.put(obj, this.dummyValue);
        if (this.map.size() != size) {
            return true;
        }
        return false;
    }

    public boolean addAll(Collection collection) {
        int size = this.map.size();
        for (Object put : collection) {
            this.map.put(put, this.dummyValue);
        }
        if (this.map.size() != size) {
            return true;
        }
        return false;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsAll(Collection collection) {
        return this.map.keySet().containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.map.keySet().equals(obj);
    }

    public int hashCode() {
        return this.map.keySet().hashCode();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    public boolean remove(Object obj) {
        int size = this.map.size();
        this.map.remove(obj);
        if (this.map.size() != size) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        return this.map.keySet().removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return this.map.keySet().retainAll(collection);
    }

    public int size() {
        return this.map.size();
    }

    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

    public static Set decorate(Map map2, Object obj) {
        if (map2 != null) {
            return new MapBackedSet(map2, obj);
        }
        throw new IllegalArgumentException("The map must not be null");
    }

    public Object[] toArray(Object[] objArr) {
        return this.map.keySet().toArray(objArr);
    }
}
