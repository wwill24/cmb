package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.collection.UnmodifiableCollection;
import org.apache.commons.collections.set.UnmodifiableSet;

public class FixedSizeMap extends AbstractMapDecorator implements BoundedMap, Serializable {
    private static final long serialVersionUID = 7450927208116179316L;

    protected FixedSizeMap(Map map) {
        super(map);
    }

    public static Map decorate(Map map) {
        return new FixedSizeMap(map);
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

    public Collection values() {
        return UnmodifiableCollection.decorate(this.map.values());
    }
}
