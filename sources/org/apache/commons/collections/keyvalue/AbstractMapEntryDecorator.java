package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;

public abstract class AbstractMapEntryDecorator implements Map.Entry, KeyValue {
    protected final Map.Entry entry;

    public AbstractMapEntryDecorator(Map.Entry entry2) {
        if (entry2 != null) {
            this.entry = entry2;
            return;
        }
        throw new IllegalArgumentException("Map Entry must not be null");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.entry.equals(obj);
    }

    public Object getKey() {
        return this.entry.getKey();
    }

    /* access modifiers changed from: protected */
    public Map.Entry getMapEntry() {
        return this.entry;
    }

    public Object getValue() {
        return this.entry.getValue();
    }

    public int hashCode() {
        return this.entry.hashCode();
    }

    public Object setValue(Object obj) {
        return this.entry.setValue(obj);
    }

    public String toString() {
        return this.entry.toString();
    }
}
