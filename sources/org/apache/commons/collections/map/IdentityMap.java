package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.map.AbstractHashedMap;

public class IdentityMap extends AbstractHashedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 2028493495224302329L;

    protected static class IdentityEntry extends AbstractHashedMap.HashEntry {
        protected IdentityEntry(AbstractHashedMap.HashEntry hashEntry, int i10, Object obj, Object obj2) {
            super(hashEntry, i10, obj, obj2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == entry.getKey() && getValue() == entry.getValue()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return System.identityHashCode(getKey()) ^ System.identityHashCode(getValue());
        }
    }

    public IdentityMap() {
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
    public AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i10, Object obj, Object obj2) {
        return new IdentityEntry(hashEntry, i10, obj, obj2);
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj, Object obj2) {
        return obj == obj2;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public IdentityMap(int i10) {
        super(i10);
    }

    public IdentityMap(int i10, float f10) {
        super(i10, f10);
    }

    public IdentityMap(Map map) {
        super(map);
    }
}
