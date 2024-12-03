package org.apache.commons.collections.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.BidiMap;

public class DualHashBidiMap extends AbstractDualBidiMap implements Serializable {
    private static final long serialVersionUID = 721969328361808L;

    public DualHashBidiMap() {
        super(new HashMap(), new HashMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.maps[0] = new HashMap();
        this.maps[1] = new HashMap();
        putAll((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.maps[0]);
    }

    /* access modifiers changed from: protected */
    public BidiMap createBidiMap(Map map, Map map2, BidiMap bidiMap) {
        return new DualHashBidiMap(map, map2, bidiMap);
    }

    public DualHashBidiMap(Map map) {
        super(new HashMap(), new HashMap());
        putAll(map);
    }

    protected DualHashBidiMap(Map map, Map map2, BidiMap bidiMap) {
        super(map, map2, bidiMap);
    }
}
