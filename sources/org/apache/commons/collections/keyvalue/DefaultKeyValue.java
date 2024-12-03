package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;

public class DefaultKeyValue extends AbstractKeyValue {
    public DefaultKeyValue() {
        super((Object) null, (Object) null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultKeyValue)) {
            return false;
        }
        DefaultKeyValue defaultKeyValue = (DefaultKeyValue) obj;
        if (getKey() != null ? getKey().equals(defaultKeyValue.getKey()) : defaultKeyValue.getKey() == null) {
            if (getValue() == null) {
                if (defaultKeyValue.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(defaultKeyValue.getValue())) {
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

    public Object setKey(Object obj) {
        if (obj != this) {
            Object obj2 = this.key;
            this.key = obj;
            return obj2;
        }
        throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
    }

    public Object setValue(Object obj) {
        if (obj != this) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }
        throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
    }

    public Map.Entry toMapEntry() {
        return new DefaultMapEntry((KeyValue) this);
    }

    public DefaultKeyValue(Object obj, Object obj2) {
        super(obj, obj2);
    }

    public DefaultKeyValue(KeyValue keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultKeyValue(Map.Entry entry) {
        super(entry.getKey(), entry.getValue());
    }
}
