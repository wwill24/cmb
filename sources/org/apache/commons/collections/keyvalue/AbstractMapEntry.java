package org.apache.commons.collections.keyvalue;

import java.util.Map;

public abstract class AbstractMapEntry extends AbstractKeyValue implements Map.Entry {
    protected AbstractMapEntry(Object obj, Object obj2) {
        super(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
            if (getValue() == null) {
                if (entry.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10 = 0;
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (getValue() != null) {
            i10 = getValue().hashCode();
        }
        return hashCode ^ i10;
    }

    public Object setValue(Object obj) {
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }
}
