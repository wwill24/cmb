package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.EmptyMapIterator;

public class AbstractHashedMap extends AbstractMap implements IterableMap {
    protected static final int DEFAULT_CAPACITY = 16;
    protected static final float DEFAULT_LOAD_FACTOR = 0.75f;
    protected static final int DEFAULT_THRESHOLD = 12;
    protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";
    protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";
    protected static final int MAXIMUM_CAPACITY = 1073741824;
    protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";
    protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";
    protected static final Object NULL = new Object();
    protected static final String REMOVE_INVALID = "remove() can only be called once after next()";
    protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";
    protected transient HashEntry[] data;
    protected transient EntrySet entrySet;
    protected transient KeySet keySet;
    protected transient float loadFactor;
    protected transient int modCount;
    protected transient int size;
    protected transient int threshold;
    protected transient Values values;

    protected static class EntrySet extends AbstractSet {
        protected final AbstractHashedMap parent;

        protected EntrySet(AbstractHashedMap abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            HashEntry entry2 = this.parent.getEntry(entry.getKey());
            if (entry2 == null || !entry2.equals(entry)) {
                return false;
            }
            return true;
        }

        public Iterator iterator() {
            return this.parent.createEntrySetIterator();
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            this.parent.remove(((Map.Entry) obj).getKey());
            return true;
        }

        public int size() {
            return this.parent.size();
        }
    }

    protected static class EntrySetIterator extends HashIterator {
        protected EntrySetIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object next() {
            return super.nextEntry();
        }
    }

    protected static class HashEntry implements Map.Entry, KeyValue {
        protected int hashCode;
        protected Object key;
        protected HashEntry next;
        protected Object value;

        protected HashEntry(HashEntry hashEntry, int i10, Object obj, Object obj2) {
            this.next = hashEntry;
            this.hashCode = i10;
            this.key = obj;
            this.value = obj2;
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
            Object obj = this.key;
            if (obj == AbstractHashedMap.NULL) {
                return null;
            }
            return obj;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            int i10 = 0;
            int hashCode2 = getKey() == null ? 0 : getKey().hashCode();
            if (getValue() != null) {
                i10 = getValue().hashCode();
            }
            return hashCode2 ^ i10;
        }

        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getKey());
            stringBuffer.append(SignatureVisitor.INSTANCEOF);
            stringBuffer.append(getValue());
            return stringBuffer.toString();
        }
    }

    protected static abstract class HashIterator implements Iterator {
        protected int expectedModCount;
        protected int hashIndex;
        protected HashEntry last;
        protected HashEntry next;
        protected final AbstractHashedMap parent;

        protected HashIterator(AbstractHashedMap abstractHashedMap) {
            this.parent = abstractHashedMap;
            HashEntry[] hashEntryArr = abstractHashedMap.data;
            int length = hashEntryArr.length;
            HashEntry hashEntry = null;
            while (length > 0 && hashEntry == null) {
                length--;
                hashEntry = hashEntryArr[length];
            }
            this.next = hashEntry;
            this.hashIndex = length;
            this.expectedModCount = abstractHashedMap.modCount;
        }

        /* access modifiers changed from: protected */
        public HashEntry currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        /* access modifiers changed from: protected */
        public HashEntry nextEntry() {
            AbstractHashedMap abstractHashedMap = this.parent;
            if (abstractHashedMap.modCount == this.expectedModCount) {
                HashEntry hashEntry = this.next;
                if (hashEntry != null) {
                    HashEntry[] hashEntryArr = abstractHashedMap.data;
                    int i10 = this.hashIndex;
                    HashEntry hashEntry2 = hashEntry.next;
                    while (hashEntry2 == null && i10 > 0) {
                        i10--;
                        hashEntry2 = hashEntryArr[i10];
                    }
                    this.next = hashEntry2;
                    this.hashIndex = i10;
                    this.last = hashEntry;
                    return hashEntry;
                }
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            HashEntry hashEntry = this.last;
            if (hashEntry != null) {
                AbstractHashedMap abstractHashedMap = this.parent;
                if (abstractHashedMap.modCount == this.expectedModCount) {
                    abstractHashedMap.remove(hashEntry.getKey());
                    this.last = null;
                    this.expectedModCount = this.parent.modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Iterator[");
            stringBuffer.append(this.last.getKey());
            stringBuffer.append("=");
            stringBuffer.append(this.last.getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    protected static class HashMapIterator extends HashIterator implements MapIterator {
        protected HashMapIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object getKey() {
            HashEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getKey();
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        public Object getValue() {
            HashEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getValue();
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        public Object next() {
            return super.nextEntry().getKey();
        }

        public Object setValue(Object obj) {
            HashEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.setValue(obj);
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }
    }

    protected static class KeySet extends AbstractSet {
        protected final AbstractHashedMap parent;

        protected KeySet(AbstractHashedMap abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        public Iterator iterator() {
            return this.parent.createKeySetIterator();
        }

        public boolean remove(Object obj) {
            boolean containsKey = this.parent.containsKey(obj);
            this.parent.remove(obj);
            return containsKey;
        }

        public int size() {
            return this.parent.size();
        }
    }

    protected static class KeySetIterator extends EntrySetIterator {
        protected KeySetIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object next() {
            return super.nextEntry().getKey();
        }
    }

    protected static class Values extends AbstractCollection {
        protected final AbstractHashedMap parent;

        protected Values(AbstractHashedMap abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        public Iterator iterator() {
            return this.parent.createValuesIterator();
        }

        public int size() {
            return this.parent.size();
        }
    }

    protected static class ValuesIterator extends HashIterator {
        protected ValuesIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object next() {
            return super.nextEntry().getValue();
        }
    }

    protected AbstractHashedMap() {
    }

    /* access modifiers changed from: protected */
    public void addEntry(HashEntry hashEntry, int i10) {
        this.data[i10] = hashEntry;
    }

    /* access modifiers changed from: protected */
    public void addMapping(int i10, int i11, Object obj, Object obj2) {
        this.modCount++;
        addEntry(createEntry(this.data[i10], i11, obj, obj2), i10);
        this.size++;
        checkCapacity();
    }

    /* access modifiers changed from: protected */
    public int calculateNewCapacity(int i10) {
        if (i10 > MAXIMUM_CAPACITY) {
            return MAXIMUM_CAPACITY;
        }
        int i11 = 1;
        while (i11 < i10) {
            i11 <<= 1;
        }
        return i11 > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : i11;
    }

    /* access modifiers changed from: protected */
    public int calculateThreshold(int i10, float f10) {
        return (int) (((float) i10) * f10);
    }

    /* access modifiers changed from: protected */
    public void checkCapacity() {
        int length;
        if (this.size >= this.threshold && (length = this.data.length * 2) <= MAXIMUM_CAPACITY) {
            ensureCapacity(length);
        }
    }

    public void clear() {
        this.modCount++;
        HashEntry[] hashEntryArr = this.data;
        for (int length = hashEntryArr.length - 1; length >= 0; length--) {
            hashEntryArr[length] = null;
        }
        this.size = 0;
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            AbstractHashedMap abstractHashedMap = (AbstractHashedMap) super.clone();
            abstractHashedMap.data = new HashEntry[this.data.length];
            abstractHashedMap.entrySet = null;
            abstractHashedMap.keySet = null;
            abstractHashedMap.values = null;
            abstractHashedMap.modCount = 0;
            abstractHashedMap.size = 0;
            abstractHashedMap.init();
            abstractHashedMap.putAll(this);
            return abstractHashedMap;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean containsKey(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        HashEntry[] hashEntryArr = this.data;
        for (HashEntry hashEntry = hashEntryArr[hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(convertKey, hashEntry.key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            for (HashEntry hashEntry : this.data) {
                while (hashEntry != null) {
                    if (hashEntry.getValue() == null) {
                        return true;
                    }
                    hashEntry = hashEntry.next;
                }
            }
        } else {
            for (HashEntry hashEntry2 : this.data) {
                while (hashEntry2 != null) {
                    if (isEqualValue(obj, hashEntry2.getValue())) {
                        return true;
                    }
                    hashEntry2 = hashEntry2.next;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Object convertKey(Object obj) {
        return obj == null ? NULL : obj;
    }

    /* access modifiers changed from: protected */
    public HashEntry createEntry(HashEntry hashEntry, int i10, Object obj, Object obj2) {
        return new HashEntry(hashEntry, i10, obj, obj2);
    }

    /* access modifiers changed from: protected */
    public Iterator createEntrySetIterator() {
        if (size() == 0) {
            return EmptyIterator.INSTANCE;
        }
        return new EntrySetIterator(this);
    }

    /* access modifiers changed from: protected */
    public Iterator createKeySetIterator() {
        if (size() == 0) {
            return EmptyIterator.INSTANCE;
        }
        return new KeySetIterator(this);
    }

    /* access modifiers changed from: protected */
    public Iterator createValuesIterator() {
        if (size() == 0) {
            return EmptyIterator.INSTANCE;
        }
        return new ValuesIterator(this);
    }

    /* access modifiers changed from: protected */
    public void destroyEntry(HashEntry hashEntry) {
        hashEntry.next = null;
        hashEntry.key = null;
        hashEntry.value = null;
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.loadFactor = objectInputStream.readFloat();
        int readInt = objectInputStream.readInt();
        int readInt2 = objectInputStream.readInt();
        init();
        this.threshold = calculateThreshold(readInt, this.loadFactor);
        this.data = new HashEntry[readInt];
        for (int i10 = 0; i10 < readInt2; i10++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeFloat(this.loadFactor);
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.writeInt(this.size);
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    /* access modifiers changed from: protected */
    public void ensureCapacity(int i10) {
        HashEntry[] hashEntryArr = this.data;
        int length = hashEntryArr.length;
        if (i10 > length) {
            if (this.size == 0) {
                this.threshold = calculateThreshold(i10, this.loadFactor);
                this.data = new HashEntry[i10];
                return;
            }
            HashEntry[] hashEntryArr2 = new HashEntry[i10];
            this.modCount++;
            for (int i11 = length - 1; i11 >= 0; i11--) {
                HashEntry hashEntry = hashEntryArr[i11];
                if (hashEntry != null) {
                    hashEntryArr[i11] = null;
                    while (true) {
                        HashEntry hashEntry2 = hashEntry.next;
                        int hashIndex = hashIndex(hashEntry.hashCode, i10);
                        hashEntry.next = hashEntryArr2[hashIndex];
                        hashEntryArr2[hashIndex] = hashEntry;
                        if (hashEntry2 == null) {
                            break;
                        }
                        hashEntry = hashEntry2;
                    }
                }
            }
            this.threshold = calculateThreshold(i10, this.loadFactor);
            this.data = hashEntryArr2;
        }
    }

    /* access modifiers changed from: protected */
    public int entryHashCode(HashEntry hashEntry) {
        return hashEntry.hashCode;
    }

    /* access modifiers changed from: protected */
    public Object entryKey(HashEntry hashEntry) {
        return hashEntry.key;
    }

    /* access modifiers changed from: protected */
    public HashEntry entryNext(HashEntry hashEntry) {
        return hashEntry.next;
    }

    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet(this);
        }
        return this.entrySet;
    }

    /* access modifiers changed from: protected */
    public Object entryValue(HashEntry hashEntry) {
        return hashEntry.value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            try {
                Object next = mapIterator.next();
                Object value = mapIterator.getValue();
                if (value == null) {
                    if (map.get(next) != null || !map.containsKey(next)) {
                        return false;
                    }
                } else if (!value.equals(map.get(next))) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        return true;
    }

    public Object get(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        HashEntry[] hashEntryArr = this.data;
        for (HashEntry hashEntry = hashEntryArr[hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(convertKey, hashEntry.key)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public HashEntry getEntry(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        HashEntry[] hashEntryArr = this.data;
        for (HashEntry hashEntry = hashEntryArr[hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(convertKey, hashEntry.key)) {
                return hashEntry;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj) {
        int hashCode = obj.hashCode();
        int i10 = hashCode + (~(hashCode << 9));
        int i11 = i10 ^ (i10 >>> 14);
        int i12 = i11 + (i11 << 4);
        return i12 ^ (i12 >>> 10);
    }

    public int hashCode() {
        Iterator createEntrySetIterator = createEntrySetIterator();
        int i10 = 0;
        while (createEntrySetIterator.hasNext()) {
            i10 += createEntrySetIterator.next().hashCode();
        }
        return i10;
    }

    /* access modifiers changed from: protected */
    public int hashIndex(int i10, int i11) {
        return i10 & (i11 - 1);
    }

    /* access modifiers changed from: protected */
    public void init() {
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet(this);
        }
        return this.keySet;
    }

    public MapIterator mapIterator() {
        if (this.size == 0) {
            return EmptyMapIterator.INSTANCE;
        }
        return new HashMapIterator(this);
    }

    public Object put(Object obj, Object obj2) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        int hashIndex = hashIndex(hash, this.data.length);
        HashEntry hashEntry = this.data[hashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(convertKey, hashEntry.key)) {
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                updateEntry(hashEntry, obj2);
                return value;
            }
        }
        addMapping(hashIndex, hash, convertKey, obj2);
        return null;
    }

    public void putAll(Map map) {
        int size2 = map.size();
        if (size2 != 0) {
            ensureCapacity(calculateNewCapacity((int) ((((float) (this.size + size2)) / this.loadFactor) + 1.0f)));
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public Object remove(Object obj) {
        Object convertKey = convertKey(obj);
        int hash = hash(convertKey);
        int hashIndex = hashIndex(hash, this.data.length);
        HashEntry hashEntry = this.data[hashIndex];
        HashEntry hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(convertKey, hashEntry.key)) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                removeMapping(hashEntry, hashIndex, hashEntry2);
                return value;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void removeEntry(HashEntry hashEntry, int i10, HashEntry hashEntry2) {
        if (hashEntry2 == null) {
            this.data[i10] = hashEntry.next;
        } else {
            hashEntry2.next = hashEntry.next;
        }
    }

    /* access modifiers changed from: protected */
    public void removeMapping(HashEntry hashEntry, int i10, HashEntry hashEntry2) {
        this.modCount++;
        removeEntry(hashEntry, i10, hashEntry2);
        this.size--;
        destroyEntry(hashEntry);
    }

    /* access modifiers changed from: protected */
    public void reuseEntry(HashEntry hashEntry, int i10, int i11, Object obj, Object obj2) {
        hashEntry.next = this.data[i10];
        hashEntry.hashCode = i11;
        hashEntry.key = obj;
        hashEntry.value = obj2;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (size() == 0) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(size() * 32);
        stringBuffer.append('{');
        MapIterator mapIterator = mapIterator();
        boolean hasNext = mapIterator.hasNext();
        while (hasNext) {
            Object next = mapIterator.next();
            Object value = mapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            stringBuffer.append(next);
            stringBuffer.append(SignatureVisitor.INSTANCEOF);
            if (value == this) {
                value = "(this Map)";
            }
            stringBuffer.append(value);
            hasNext = mapIterator.hasNext();
            if (hasNext) {
                stringBuffer.append(',');
                stringBuffer.append(' ');
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void updateEntry(HashEntry hashEntry, Object obj) {
        hashEntry.setValue(obj);
    }

    public Collection values() {
        if (this.values == null) {
            this.values = new Values(this);
        }
        return this.values;
    }

    protected AbstractHashedMap(int i10, float f10, int i11) {
        this.loadFactor = f10;
        this.data = new HashEntry[i10];
        this.threshold = i11;
        init();
    }

    protected AbstractHashedMap(int i10) {
        this(i10, DEFAULT_LOAD_FACTOR);
    }

    protected AbstractHashedMap(int i10, float f10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        } else if (f10 <= 0.0f || Float.isNaN(f10)) {
            throw new IllegalArgumentException("Load factor must be greater than 0");
        } else {
            this.loadFactor = f10;
            int calculateNewCapacity = calculateNewCapacity(i10);
            this.threshold = calculateThreshold(calculateNewCapacity, f10);
            this.data = new HashEntry[calculateNewCapacity];
            init();
        }
    }

    protected AbstractHashedMap(Map map) {
        this(Math.max(map.size() * 2, 16), DEFAULT_LOAD_FACTOR);
        putAll(map);
    }
}
