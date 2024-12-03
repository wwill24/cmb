package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class LRUMap extends SequencedHashMap {
    private static final long serialVersionUID = 2197433140769957051L;
    private int maximumSize;

    public LRUMap() {
        this(100);
    }

    public Object get(Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        Object remove = remove(obj);
        super.put(obj, remove);
        return remove;
    }

    public int getMaximumSize() {
        return this.maximumSize;
    }

    /* access modifiers changed from: protected */
    public void processRemovedLRU(Object obj, Object obj2) {
    }

    public Object put(Object obj, Object obj2) {
        if (size() >= this.maximumSize && !containsKey(obj)) {
            removeLRU();
        }
        return super.put(obj, obj2);
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.maximumSize = objectInput.readInt();
        int readInt = objectInput.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            put(objectInput.readObject(), objectInput.readObject());
        }
    }

    /* access modifiers changed from: protected */
    public void removeLRU() {
        Object firstKey = getFirstKey();
        Object obj = super.get(firstKey);
        remove(firstKey);
        processRemovedLRU(firstKey, obj);
    }

    public void setMaximumSize(int i10) {
        this.maximumSize = i10;
        while (size() > i10) {
            removeLRU();
        }
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.maximumSize);
        objectOutput.writeInt(size());
        for (Object next : keySet()) {
            objectOutput.writeObject(next);
            objectOutput.writeObject(super.get(next));
        }
    }

    public LRUMap(int i10) {
        super(i10);
        this.maximumSize = i10;
    }
}
