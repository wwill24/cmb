package org.apache.commons.collections.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public abstract class AbstractSerializableSetDecorator extends AbstractSetDecorator implements Serializable {
    private static final long serialVersionUID = 1229469966212206107L;

    protected AbstractSerializableSetDecorator(Set set) {
        super(set);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.collection = (Collection) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.collection);
    }
}
