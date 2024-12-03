package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class HashedMap extends AbstractHashedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public HashedMap() {
        super(16, 0.75f, 12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public Object clone() {
        return super.clone();
    }

    public HashedMap(int i10) {
        super(i10);
    }

    public HashedMap(int i10, float f10) {
        super(i10, f10);
    }

    public HashedMap(Map map) {
        super(map);
    }
}
