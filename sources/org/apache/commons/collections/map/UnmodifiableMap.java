package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.set.UnmodifiableSet;

public final class UnmodifiableMap extends AbstractMapDecorator implements IterableMap, Unmodifiable, Serializable {
    private static final long serialVersionUID = 2737023427269031941L;

    private UnmodifiableMap(Map map) {
        super(map);
    }

    public static Map decorate(Map map) {
        if (map instanceof Unmodifiable) {
            return map;
        }
        return new UnmodifiableMap(map);
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
        Map map = this.map;
        if (map instanceof IterableMap) {
            return UnmodifiableMapIterator.decorate(((IterableMap) map).mapIterator());
        }
        return UnmodifiableMapIterator.decorate(new EntrySetMapIterator(map));
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
