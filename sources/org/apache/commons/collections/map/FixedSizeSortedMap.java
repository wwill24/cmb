package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.set.UnmodifiableSet;

public class FixedSizeSortedMap extends AbstractSortedMapDecorator implements BoundedMap, Serializable {
    private static final long serialVersionUID = 3126019624511683653L;

    protected FixedSizeSortedMap(SortedMap sortedMap) {
        super(sortedMap);
    }

    public static SortedMap decorate(SortedMap sortedMap) {
        return new FixedSizeSortedMap(sortedMap);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public void clear() {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    public Set entrySet() {
        return UnmodifiableSet.decorate(this.map.entrySet());
    }

    /* access modifiers changed from: protected */
    public SortedMap getSortedMap() {
        return (SortedMap) this.map;
    }

    public SortedMap headMap(Object obj) {
        return new FixedSizeSortedMap(getSortedMap().headMap(obj));
    }

    public boolean isFull() {
        return true;
    }

    public Set keySet() {
        return UnmodifiableSet.decorate(this.map.keySet());
    }

    public int maxSize() {
        return size();
    }

    public Object put(Object obj, Object obj2) {
        if (this.map.containsKey(obj)) {
            return this.map.put(obj, obj2);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
    }

    public void putAll(Map map) {
        for (Object containsKey : map.keySet()) {
            if (!map.containsKey(containsKey)) {
                throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
            }
        }
        this.map.putAll(map);
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new FixedSizeSortedMap(getSortedMap().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new FixedSizeSortedMap(getSortedMap().tailMap(obj));
    }

    public Collection values() {
        return UnmodifiableCollection.decorate(this.map.values());
    }
}
