package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.iterators.UnmodifiableOrderedMapIterator;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableOrderedMap extends AbstractOrderedMapDecorator implements Unmodifiable, Serializable {
    private static final long serialVersionUID = 8136428161720526266L;

    private UnmodifiableOrderedMap(OrderedMap orderedMap) {
        super(orderedMap);
    }

    public static OrderedMap decorate(OrderedMap orderedMap) {
        if (orderedMap instanceof Unmodifiable) {
            return orderedMap;
        }
        return new UnmodifiableOrderedMap(orderedMap);
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

    public Set entrySet() {
        return UnmodifiableEntrySet.decorate(super.entrySet());
    }

    public Set keySet() {
        return UnmodifiableSet.decorate(super.keySet());
    }

    public MapIterator mapIterator() {
        return UnmodifiableMapIterator.decorate(getOrderedMap().mapIterator());
    }

    public OrderedMapIterator orderedMapIterator() {
        return UnmodifiableOrderedMapIterator.decorate(getOrderedMap().orderedMapIterator());
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

    public Collection values() {
        return UnmodifiableCollection.decorate(super.values());
    }
}
