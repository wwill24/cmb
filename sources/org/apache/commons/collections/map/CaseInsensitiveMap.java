package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

public class CaseInsensitiveMap extends AbstractHashedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = -7074655917369299456L;

    public CaseInsensitiveMap() {
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

    /* access modifiers changed from: protected */
    public Object convertKey(Object obj) {
        if (obj == null) {
            return AbstractHashedMap.NULL;
        }
        char[] charArray = obj.toString().toCharArray();
        for (int length = charArray.length - 1; length >= 0; length--) {
            charArray[length] = Character.toLowerCase(Character.toUpperCase(charArray[length]));
        }
        return new String(charArray);
    }

    public CaseInsensitiveMap(int i10) {
        super(i10);
    }

    public CaseInsensitiveMap(int i10, float f10) {
        super(i10, f10);
    }

    public CaseInsensitiveMap(Map map) {
        super(map);
    }
}
