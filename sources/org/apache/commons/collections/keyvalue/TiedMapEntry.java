package org.apache.commons.collections.keyvalue;

import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.KeyValue;

public class TiedMapEntry implements Map.Entry, KeyValue, Serializable {
    private static final long serialVersionUID = -8453869361373831205L;
    private final Object key;
    private final Map map;

    public TiedMapEntry(Map map2, Object obj) {
        this.map = map2;
        this.key = obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object value = getValue();
        Object obj2 = this.key;
        if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
            Object value2 = entry.getValue();
            if (value == null) {
                if (value2 == null) {
                    return true;
                }
            } else if (value.equals(value2)) {
                return true;
            }
        }
        return false;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.map.get(this.key);
    }

    public int hashCode() {
        int i10;
        Object value = getValue();
        int i11 = 0;
        if (getKey() == null) {
            i10 = 0;
        } else {
            i10 = getKey().hashCode();
        }
        if (value != null) {
            i11 = value.hashCode();
        }
        return i10 ^ i11;
    }

    public Object setValue(Object obj) {
        if (obj != this) {
            return this.map.put(this.key, obj);
        }
        throw new IllegalArgumentException("Cannot set value to this map entry");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getKey());
        stringBuffer.append("=");
        stringBuffer.append(getValue());
        return stringBuffer.toString();
    }
}
