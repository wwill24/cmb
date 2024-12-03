package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;

public class ReferenceIdentityMap extends AbstractReferenceMap implements Serializable {
    private static final long serialVersionUID = -1266190134568365852L;

    public ReferenceIdentityMap() {
        super(0, 1, 16, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    /* access modifiers changed from: protected */
    public int hashEntry(Object obj, Object obj2) {
        return System.identityHashCode(obj) ^ System.identityHashCode(obj2);
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj, Object obj2) {
        if (this.keyType > 0) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public ReferenceIdentityMap(int i10, int i11) {
        super(i10, i11, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(int i10, int i11, boolean z10) {
        super(i10, i11, 16, 0.75f, z10);
    }

    public ReferenceIdentityMap(int i10, int i11, int i12, float f10) {
        super(i10, i11, i12, f10, false);
    }

    public ReferenceIdentityMap(int i10, int i11, int i12, float f10, boolean z10) {
        super(i10, i11, i12, f10, z10);
    }
}
