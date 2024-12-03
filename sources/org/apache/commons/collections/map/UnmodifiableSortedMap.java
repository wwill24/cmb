package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableSortedMap extends AbstractSortedMapDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = 5805344239827376360L;

    private UnmodifiableSortedMap(SortedMap sortedMap) {
        super(sortedMap);
    }

    public static SortedMap decorate(SortedMap sortedMap) {
        if (sortedMap instanceof Unmodifiable) {
            return sortedMap;
        }
        return new UnmodifiableSortedMap(sortedMap);
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
        throw new UnsupportedOperationException();
    }

    public Comparator comparator() {
        return getSortedMap().comparator();
    }

    public Set entrySet() {
        return UnmodifiableEntrySet.decorate(super.entrySet());
    }

    public Object firstKey() {
        return getSortedMap().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new UnmodifiableSortedMap(getSortedMap().headMap(obj));
    }

    public Set keySet() {
        return UnmodifiableSet.decorate(super.keySet());
    }

    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new UnmodifiableSortedMap(getSortedMap().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new UnmodifiableSortedMap(getSortedMap().tailMap(obj));
    }

    public Collection values() {
        return UnmodifiableCollection.decorate(super.values());
    }
}
