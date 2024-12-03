package org.apache.commons.collections;

import java.util.Map;

public class DefaultMapEntry implements Map.Entry, KeyValue {
    private Object key;
    private Object value;

    public DefaultMapEntry() {
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

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int i10 = 0;
        int hashCode = getKey() == null ? 0 : getKey().hashCode();
        if (getValue() != null) {
            i10 = getValue().hashCode();
        }
        return hashCode ^ i10;
    }

    public void setKey(Object obj) {
        this.key = obj;
    }

    public Object setValue(Object obj) {
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("");
        stringBuffer.append(getKey());
        stringBuffer.append("=");
        stringBuffer.append(getValue());
        return stringBuffer.toString();
    }

    public DefaultMapEntry(Map.Entry entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public DefaultMapEntry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }
}
