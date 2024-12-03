package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class HashBag extends AbstractMapBag implements Serializable {
    private static final long serialVersionUID = -6561115435802554013L;

    public HashBag() {
        super(new HashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        super.doReadObject(new HashMap(), objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        super.doWriteObject(objectOutputStream);
    }

    public HashBag(Collection collection) {
        this();
        addAll(collection);
    }
}
