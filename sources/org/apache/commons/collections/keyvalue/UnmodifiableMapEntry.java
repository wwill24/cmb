package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.Unmodifiable;

public final class UnmodifiableMapEntry extends AbstractMapEntry implements Unmodifiable {
    public UnmodifiableMapEntry(Object obj, Object obj2) {
        super(obj, obj2);
    }

    public Object setValue(Object obj) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    public UnmodifiableMapEntry(KeyValue keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public UnmodifiableMapEntry(Map.Entry entry) {
        super(entry.getKey(), entry.getValue());
    }
}
