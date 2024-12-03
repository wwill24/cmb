package org.apache.commons.collections.map;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.SingletonIterator;
import org.apache.commons.collections.keyvalue.TiedMapEntry;

public class SingletonMap implements OrderedMap, BoundedMap, KeyValue, Serializable, Cloneable {
    private static final long serialVersionUID = -8931271118676803261L;
    private final Object key;
    private Object value;

    static class SingletonMapIterator implements OrderedMapIterator, ResettableIterator {
        private boolean canGetSet = false;
        private boolean hasNext = true;
        private final SingletonMap parent;

        SingletonMapIterator(SingletonMap singletonMap) {
            this.parent = singletonMap;
        }

        public Object getKey() {
            if (this.canGetSet) {
                return this.parent.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            if (this.canGetSet) {
                return this.parent.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public boolean hasNext() {
            return this.hasNext;
        }

        public boolean hasPrevious() {
            return !this.hasNext;
        }

        public Object next() {
            if (this.hasNext) {
                this.hasNext = false;
                this.canGetSet = true;
                return this.parent.getKey();
            }
            throw new NoSuchElementException("No next() entry in the iteration");
        }

        public Object previous() {
            if (!this.hasNext) {
                this.hasNext = true;
                return this.parent.getKey();
            }
            throw new NoSuchElementException("No previous() entry in the iteration");
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void reset() {
            this.hasNext = true;
        }

        public Object setValue(Object obj) {
            if (this.canGetSet) {
                return this.parent.setValue(obj);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (this.hasNext) {
                return "Iterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Iterator[");
            stringBuffer.append(getKey());
            stringBuffer.append("=");
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    static class SingletonValues extends AbstractSet implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;
        private final SingletonMap parent;

        SingletonValues(SingletonMap singletonMap) {
            this.parent = singletonMap;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator iterator() {
            return new SingletonIterator(this.parent.getValue(), false);
        }

        public int size() {
            return 1;
        }
    }

    public SingletonMap() {
        this.key = null;
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Object clone() {
        try {
            return (SingletonMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean containsKey(Object obj) {
        return isEqualKey(obj);
    }

    public boolean containsValue(Object obj) {
        return isEqualValue(obj);
    }

    public Set entrySet() {
        return Collections.singleton(new TiedMapEntry(this, getKey()));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != 1) {
            return false;
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        if (!isEqualKey(entry.getKey()) || !isEqualValue(entry.getValue())) {
            return false;
        }
        return true;
    }

    public Object firstKey() {
        return getKey();
    }

    public Object get(Object obj) {
        if (isEqualKey(obj)) {
            return this.value;
        }
        return null;
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

    public boolean isEmpty() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj) {
        return obj == null ? getKey() == null : obj.equals(getKey());
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj) {
        return obj == null ? getValue() == null : obj.equals(getValue());
    }

    public boolean isFull() {
        return true;
    }

    public Set keySet() {
        return Collections.singleton(this.key);
    }

    public Object lastKey() {
        return getKey();
    }

    public MapIterator mapIterator() {
        return new SingletonMapIterator(this);
    }

    public int maxSize() {
        return 1;
    }

    public Object nextKey(Object obj) {
        return null;
    }

    public OrderedMapIterator orderedMapIterator() {
        return new SingletonMapIterator(this);
    }

    public Object previousKey(Object obj) {
        return null;
    }

    public Object put(Object obj, Object obj2) {
        if (isEqualKey(obj)) {
            return setValue(obj2);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    public void putAll(Map map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
            put(entry.getKey(), entry.getValue());
            return;
        }
        throw new IllegalArgumentException("The map size must be 0 or 1");
    }

    public Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public Object setValue(Object obj) {
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append('{');
        Object obj = "(this Map)";
        stringBuffer.append(getKey() == this ? obj : getKey());
        stringBuffer.append(SignatureVisitor.INSTANCEOF);
        if (getValue() != this) {
            obj = getValue();
        }
        stringBuffer.append(obj);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public Collection values() {
        return new SingletonValues(this);
    }

    public SingletonMap(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    public SingletonMap(KeyValue keyValue) {
        this.key = keyValue.getKey();
        this.value = keyValue.getValue();
    }

    public SingletonMap(Map.Entry entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public SingletonMap(Map map) {
        if (map.size() == 1) {
            Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
            this.key = entry.getKey();
            this.value = entry.getValue();
            return;
        }
        throw new IllegalArgumentException("The map size must be 1");
    }
}
