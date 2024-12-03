package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.FactoryTransformer;

public class LazyMap extends AbstractMapDecorator implements Serializable {
    private static final long serialVersionUID = 7990956402564206740L;
    protected final Transformer factory;

    protected LazyMap(Map map, Factory factory2) {
        super(map);
        if (factory2 != null) {
            this.factory = FactoryTransformer.getInstance(factory2);
            return;
        }
        throw new IllegalArgumentException("Factory must not be null");
    }

    public static Map decorate(Map map, Factory factory2) {
        return new LazyMap(map, factory2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    public Object get(Object obj) {
        if (this.map.containsKey(obj)) {
            return this.map.get(obj);
        }
        Object transform = this.factory.transform(obj);
        this.map.put(obj, transform);
        return transform;
    }

    public static Map decorate(Map map, Transformer transformer) {
        return new LazyMap(map, transformer);
    }

    protected LazyMap(Map map, Transformer transformer) {
        super(map);
        if (transformer != null) {
            this.factory = transformer;
            return;
        }
        throw new IllegalArgumentException("Factory must not be null");
    }
}
