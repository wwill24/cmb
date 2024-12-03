package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReferenceMap extends AbstractReferenceMap implements Serializable {
    private static final long serialVersionUID = 1555089888138299607L;

    public ReferenceMap() {
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

    public ReferenceMap(int i10, int i11) {
        super(i10, i11, 16, 0.75f, false);
    }

    public ReferenceMap(int i10, int i11, boolean z10) {
        super(i10, i11, 16, 0.75f, z10);
    }

    public ReferenceMap(int i10, int i11, int i12, float f10) {
        super(i10, i11, i12, f10, false);
    }

    public ReferenceMap(int i10, int i11, int i12, float f10, boolean z10) {
        super(i10, i11, i12, f10, z10);
    }
}
