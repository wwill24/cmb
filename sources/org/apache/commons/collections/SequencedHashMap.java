package org.apache.commons.collections;

import com.google.android.gms.common.api.a;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.list.UnmodifiableList;

public class SequencedHashMap implements Map, Cloneable, Externalizable {
    private static final int ENTRY = 2;
    private static final int KEY = 0;
    private static final int REMOVED_MASK = Integer.MIN_VALUE;
    private static final int VALUE = 1;
    private static final long serialVersionUID = 3380552487888102930L;
    /* access modifiers changed from: private */
    public HashMap entries;
    /* access modifiers changed from: private */
    public transient long modCount;
    /* access modifiers changed from: private */
    public Entry sentinel;

    private static class Entry implements Map.Entry, KeyValue {
        private final Object key;
        Entry next = null;
        Entry prev = null;
        private Object value;

        public Entry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (getKey() == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!getKey().equals(entry.getKey())) {
                return false;
            }
            if (getValue() == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
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

        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            stringBuffer.append(getKey());
            stringBuffer.append("=");
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    private class OrderedIterator implements Iterator {
        private transient long expectedModCount;
        private Entry pos;
        private int returnType;

        public OrderedIterator(int i10) {
            this.pos = SequencedHashMap.this.sentinel;
            this.expectedModCount = SequencedHashMap.this.modCount;
            this.returnType = SequencedHashMap.REMOVED_MASK | i10;
        }

        public boolean hasNext() {
            return this.pos.next != SequencedHashMap.this.sentinel;
        }

        public Object next() {
            if (SequencedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else if (this.pos.next != SequencedHashMap.this.sentinel) {
                int i10 = this.returnType & a.e.API_PRIORITY_OTHER;
                this.returnType = i10;
                Entry entry = this.pos.next;
                this.pos = entry;
                if (i10 == 0) {
                    return entry.getKey();
                }
                if (i10 == 1) {
                    return entry.getValue();
                }
                if (i10 == 2) {
                    return entry;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("bad iterator type: ");
                stringBuffer.append(this.returnType);
                throw new Error(stringBuffer.toString());
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if ((this.returnType & SequencedHashMap.REMOVED_MASK) != 0) {
                throw new IllegalStateException("remove() must follow next()");
            } else if (SequencedHashMap.this.modCount == this.expectedModCount) {
                Entry unused = SequencedHashMap.this.removeImpl(this.pos.getKey());
                this.expectedModCount++;
                this.returnType |= SequencedHashMap.REMOVED_MASK;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    public SequencedHashMap() {
        this.modCount = 0;
        this.sentinel = createSentinel();
        this.entries = new HashMap();
    }

    private static final Entry createSentinel() {
        Entry entry = new Entry((Object) null, (Object) null);
        entry.prev = entry;
        entry.next = entry;
        return entry;
    }

    private Map.Entry getEntry(int i10) {
        Entry entry;
        Entry entry2 = this.sentinel;
        if (i10 >= 0) {
            int i11 = -1;
            while (i11 < i10 - 1 && (entry = entry2.next) != this.sentinel) {
                i11++;
                entry2 = entry;
            }
            Entry entry3 = entry2.next;
            if (entry3 != this.sentinel) {
                return entry3;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i10);
            stringBuffer.append(" >= ");
            stringBuffer.append(i11 + 1);
            throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(i10);
        stringBuffer2.append(" < 0");
        throw new ArrayIndexOutOfBoundsException(stringBuffer2.toString());
    }

    private void insertEntry(Entry entry) {
        Entry entry2 = this.sentinel;
        entry.next = entry2;
        entry.prev = entry2.prev;
        entry2.prev.next = entry;
        entry2.prev = entry;
    }

    private void removeEntry(Entry entry) {
        Entry entry2 = entry.next;
        entry2.prev = entry.prev;
        entry.prev.next = entry2;
    }

    /* access modifiers changed from: private */
    public Entry removeImpl(Object obj) {
        Entry entry = (Entry) this.entries.remove(obj);
        if (entry == null) {
            return null;
        }
        this.modCount++;
        removeEntry(entry);
        return entry;
    }

    public void clear() {
        this.modCount++;
        this.entries.clear();
        Entry entry = this.sentinel;
        entry.next = entry;
        entry.prev = entry;
    }

    public Object clone() throws CloneNotSupportedException {
        SequencedHashMap sequencedHashMap = (SequencedHashMap) super.clone();
        sequencedHashMap.sentinel = createSentinel();
        sequencedHashMap.entries = new HashMap();
        sequencedHashMap.putAll(this);
        return sequencedHashMap;
    }

    public boolean containsKey(Object obj) {
        return this.entries.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            Entry entry = this.sentinel;
            do {
                entry = entry.next;
                if (entry == this.sentinel) {
                    return false;
                }
            } while (entry.getValue() != null);
            return true;
        }
        Entry entry2 = this.sentinel;
        do {
            entry2 = entry2.next;
            if (entry2 == this.sentinel) {
                return false;
            }
        } while (!obj.equals(entry2.getValue()));
        return true;
    }

    public Set entrySet() {
        return new AbstractSet() {
            private Entry findEntry(Object obj) {
                if (obj == null || !(obj instanceof Map.Entry)) {
                    return null;
                }
                Map.Entry entry = (Map.Entry) obj;
                Entry entry2 = (Entry) SequencedHashMap.this.entries.get(entry.getKey());
                if (entry2 == null || !entry2.equals(entry)) {
                    return null;
                }
                return entry2;
            }

            public void clear() {
                SequencedHashMap.this.clear();
            }

            public boolean contains(Object obj) {
                return findEntry(obj) != null;
            }

            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            public Iterator iterator() {
                return new OrderedIterator(2);
            }

            public boolean remove(Object obj) {
                Entry findEntry = findEntry(obj);
                if (findEntry == null || SequencedHashMap.this.removeImpl(findEntry.getKey()) == null) {
                    return false;
                }
                return true;
            }

            public int size() {
                return SequencedHashMap.this.size();
            }
        };
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public Object get(Object obj) {
        Entry entry = (Entry) this.entries.get(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public Map.Entry getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.sentinel.next;
    }

    public Object getFirstKey() {
        return this.sentinel.next.getKey();
    }

    public Object getFirstValue() {
        return this.sentinel.next.getValue();
    }

    public Map.Entry getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.sentinel.prev;
    }

    public Object getLastKey() {
        return this.sentinel.prev.getKey();
    }

    public Object getLastValue() {
        return this.sentinel.prev.getValue();
    }

    public Object getValue(int i10) {
        return getEntry(i10).getValue();
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public int indexOf(Object obj) {
        Entry entry = (Entry) this.entries.get(obj);
        if (entry == null) {
            return -1;
        }
        int i10 = 0;
        while (true) {
            entry = entry.prev;
            if (entry == this.sentinel) {
                return i10;
            }
            i10++;
        }
    }

    public boolean isEmpty() {
        Entry entry = this.sentinel;
        return entry.next == entry;
    }

    public Iterator iterator() {
        return keySet().iterator();
    }

    public Set keySet() {
        return new AbstractSet() {
            public void clear() {
                SequencedHashMap.this.clear();
            }

            public boolean contains(Object obj) {
                return SequencedHashMap.this.containsKey(obj);
            }

            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            public Iterator iterator() {
                return new OrderedIterator(0);
            }

            public boolean remove(Object obj) {
                return SequencedHashMap.this.removeImpl(obj) != null;
            }

            public int size() {
                return SequencedHashMap.this.size();
            }
        };
    }

    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    public Object put(Object obj, Object obj2) {
        Object obj3;
        this.modCount++;
        Entry entry = (Entry) this.entries.get(obj);
        if (entry != null) {
            removeEntry(entry);
            obj3 = entry.setValue(obj2);
        } else {
            entry = new Entry(obj, obj2);
            this.entries.put(obj, entry);
            obj3 = null;
        }
        insertEntry(entry);
        return obj3;
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        int readInt = objectInput.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            put(objectInput.readObject(), objectInput.readObject());
        }
    }

    public Object remove(Object obj) {
        Entry removeImpl = removeImpl(obj);
        if (removeImpl == null) {
            return null;
        }
        return removeImpl.getValue();
    }

    public List sequence() {
        ArrayList arrayList = new ArrayList(size());
        for (Object add : keySet()) {
            arrayList.add(add);
        }
        return UnmodifiableList.decorate(arrayList);
    }

    public int size() {
        return this.entries.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        Entry entry = this.sentinel;
        while (true) {
            entry = entry.next;
            if (entry != this.sentinel) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append(SignatureVisitor.INSTANCEOF);
                stringBuffer.append(entry.getValue());
                if (entry.next != this.sentinel) {
                    stringBuffer.append(',');
                }
            } else {
                stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
                return stringBuffer.toString();
            }
        }
    }

    public Collection values() {
        return new AbstractCollection() {
            public void clear() {
                SequencedHashMap.this.clear();
            }

            public boolean contains(Object obj) {
                return SequencedHashMap.this.containsValue(obj);
            }

            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            public Iterator iterator() {
                return new OrderedIterator(1);
            }

            public boolean remove(Object obj) {
                if (obj == null) {
                    Entry access$100 = SequencedHashMap.this.sentinel;
                    do {
                        access$100 = access$100.next;
                        if (access$100 == SequencedHashMap.this.sentinel) {
                            return false;
                        }
                    } while (access$100.getValue() != null);
                    Entry unused = SequencedHashMap.this.removeImpl(access$100.getKey());
                    return true;
                }
                Entry access$1002 = SequencedHashMap.this.sentinel;
                do {
                    access$1002 = access$1002.next;
                    if (access$1002 == SequencedHashMap.this.sentinel) {
                        return false;
                    }
                } while (!obj.equals(access$1002.getValue()));
                Entry unused2 = SequencedHashMap.this.removeImpl(access$1002.getKey());
                return true;
            }

            public int size() {
                return SequencedHashMap.this.size();
            }
        };
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(size());
        Entry entry = this.sentinel;
        while (true) {
            entry = entry.next;
            if (entry != this.sentinel) {
                objectOutput.writeObject(entry.getKey());
                objectOutput.writeObject(entry.getValue());
            } else {
                return;
            }
        }
    }

    public Object get(int i10) {
        return getEntry(i10).getKey();
    }

    public Object remove(int i10) {
        return remove(get(i10));
    }

    public SequencedHashMap(int i10) {
        this.modCount = 0;
        this.sentinel = createSentinel();
        this.entries = new HashMap(i10);
    }

    public SequencedHashMap(int i10, float f10) {
        this.modCount = 0;
        this.sentinel = createSentinel();
        this.entries = new HashMap(i10, f10);
    }

    public SequencedHashMap(Map map) {
        this();
        putAll(map);
    }
}
