package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.keyvalue.DefaultMapEntry;

public class ReferenceMap extends AbstractMap {
    public static final int HARD = 0;
    public static final int SOFT = 1;
    public static final int WEAK = 2;
    private static final long serialVersionUID = -3370601314380922368L;
    private transient Set entrySet;
    private transient Set keySet;
    /* access modifiers changed from: private */
    public int keyType;
    private float loadFactor;
    /* access modifiers changed from: private */
    public volatile transient int modCount;
    /* access modifiers changed from: private */
    public boolean purgeValues;
    private transient ReferenceQueue queue;
    private transient int size;
    /* access modifiers changed from: private */
    public transient Entry[] table;
    private transient int threshold;
    /* access modifiers changed from: private */
    public int valueType;
    private transient Collection values;

    private class Entry implements Map.Entry, KeyValue {
        int hash;
        Object key;
        Entry next;
        Object value;

        public Entry(Object obj, int i10, Object obj2, Entry entry) {
            this.key = obj;
            this.hash = i10;
            this.value = obj2;
            this.next = entry;
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
            Object key2 = entry.getKey();
            Object value2 = entry.getValue();
            if (key2 == null || value2 == null || !key2.equals(getKey()) || !value2.equals(getValue())) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            return ReferenceMap.this.keyType > 0 ? ((Reference) this.key).get() : this.key;
        }

        public Object getValue() {
            return ReferenceMap.this.valueType > 0 ? ((Reference) this.value).get() : this.value;
        }

        public int hashCode() {
            int i10;
            Object value2 = getValue();
            int i11 = this.hash;
            if (value2 == null) {
                i10 = 0;
            } else {
                i10 = value2.hashCode();
            }
            return i10 ^ i11;
        }

        /* access modifiers changed from: package-private */
        public boolean purge(Reference reference) {
            boolean z10;
            boolean z11 = true;
            if (ReferenceMap.this.keyType <= 0 || this.key != reference) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10 && (ReferenceMap.this.valueType <= 0 || this.value != reference)) {
                z11 = false;
            }
            if (z11) {
                if (ReferenceMap.this.keyType > 0) {
                    ((Reference) this.key).clear();
                }
                if (ReferenceMap.this.valueType > 0) {
                    ((Reference) this.value).clear();
                } else if (ReferenceMap.this.purgeValues) {
                    this.value = null;
                }
            }
            return z11;
        }

        public Object setValue(Object obj) {
            Object value2 = getValue();
            if (ReferenceMap.this.valueType > 0) {
                ((Reference) this.value).clear();
            }
            ReferenceMap referenceMap = ReferenceMap.this;
            this.value = referenceMap.toReference(referenceMap.valueType, obj, this.hash);
            return value2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getKey());
            stringBuffer.append("=");
            stringBuffer.append(getValue());
            return stringBuffer.toString();
        }
    }

    private class EntryIterator implements Iterator {
        Object currentKey;
        Object currentValue;
        Entry entry;
        int expectedModCount;
        int index;
        Object nextKey;
        Object nextValue;
        Entry previous;

        public EntryIterator() {
            int i10;
            if (ReferenceMap.this.size() != 0) {
                i10 = ReferenceMap.this.table.length;
            } else {
                i10 = 0;
            }
            this.index = i10;
            this.expectedModCount = ReferenceMap.this.modCount;
        }

        private void checkMod() {
            if (ReferenceMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean nextNull() {
            return this.nextKey == null || this.nextValue == null;
        }

        public boolean hasNext() {
            checkMod();
            while (nextNull()) {
                Entry entry2 = this.entry;
                int i10 = this.index;
                while (entry2 == null && i10 > 0) {
                    i10--;
                    entry2 = ReferenceMap.this.table[i10];
                }
                this.entry = entry2;
                this.index = i10;
                if (entry2 == null) {
                    this.currentKey = null;
                    this.currentValue = null;
                    return false;
                }
                this.nextKey = entry2.getKey();
                this.nextValue = entry2.getValue();
                if (nextNull()) {
                    this.entry = this.entry.next;
                }
            }
            return true;
        }

        public Object next() {
            return nextEntry();
        }

        /* access modifiers changed from: protected */
        public Entry nextEntry() {
            checkMod();
            if (!nextNull() || hasNext()) {
                Entry entry2 = this.entry;
                this.previous = entry2;
                this.entry = entry2.next;
                this.currentKey = this.nextKey;
                this.currentValue = this.nextValue;
                this.nextKey = null;
                this.nextValue = null;
                return entry2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkMod();
            if (this.previous != null) {
                ReferenceMap.this.remove(this.currentKey);
                this.previous = null;
                this.currentKey = null;
                this.currentValue = null;
                this.expectedModCount = ReferenceMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    private class KeyIterator extends EntryIterator {
        private final /* synthetic */ ReferenceMap this$0;

        private KeyIterator(ReferenceMap referenceMap) {
            super();
            this.this$0 = referenceMap;
        }

        public Object next() {
            return nextEntry().getKey();
        }
    }

    private static class SoftRef extends SoftReference {
        private int hash;

        public SoftRef(int i10, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i10;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    private class ValueIterator extends EntryIterator {
        private final /* synthetic */ ReferenceMap this$0;

        private ValueIterator(ReferenceMap referenceMap) {
            super();
            this.this$0 = referenceMap;
        }

        public Object next() {
            return nextEntry().getValue();
        }
    }

    private static class WeakRef extends WeakReference {
        private int hash;

        public WeakRef(int i10, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i10;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    public ReferenceMap() {
        this(0, 1);
    }

    /* access modifiers changed from: private */
    public Entry getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int hashCode = obj.hashCode();
        for (Entry entry = this.table[indexFor(hashCode)]; entry != null; entry = entry.next) {
            if (entry.hash == hashCode && obj.equals(entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    private int indexFor(int i10) {
        int i11 = i10 + (~(i10 << 15));
        int i12 = i11 ^ (i11 >>> 10);
        int i13 = i12 + (i12 << 3);
        int i14 = i13 ^ (i13 >>> 6);
        int i15 = i14 + (~(i14 << 11));
        return (i15 ^ (i15 >>> 16)) & (this.table.length - 1);
    }

    private void purge() {
        Reference poll = this.queue.poll();
        while (poll != null) {
            purge(poll);
            poll = this.queue.poll();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Entry[] entryArr = new Entry[objectInputStream.readInt()];
        this.table = entryArr;
        this.threshold = (int) (((float) entryArr.length) * this.loadFactor);
        this.queue = new ReferenceQueue();
        Object readObject = objectInputStream.readObject();
        while (readObject != null) {
            put(readObject, objectInputStream.readObject());
            readObject = objectInputStream.readObject();
        }
    }

    private void resize() {
        Entry[] entryArr = this.table;
        this.table = new Entry[(entryArr.length * 2)];
        for (int i10 = 0; i10 < entryArr.length; i10++) {
            Entry entry = entryArr[i10];
            while (entry != null) {
                Entry entry2 = entry.next;
                int indexFor = indexFor(entry.hash);
                Entry[] entryArr2 = this.table;
                entry.next = entryArr2[indexFor];
                entryArr2[indexFor] = entry;
                entry = entry2;
            }
            entryArr[i10] = null;
        }
        this.threshold = (int) (((float) this.table.length) * this.loadFactor);
    }

    /* access modifiers changed from: private */
    public Object toReference(int i10, Object obj, int i11) {
        if (i10 == 0) {
            return obj;
        }
        if (i10 == 1) {
            return new SoftRef(i11, obj, this.queue);
        }
        if (i10 == 2) {
            return new WeakRef(i11, obj, this.queue);
        }
        throw new Error();
    }

    private static void verify(String str, int i10) {
        if (i10 < 0 || i10 > 2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" must be HARD, SOFT, WEAK.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        for (Map.Entry entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject((Object) null);
    }

    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        do {
        } while (this.queue.poll() != null);
    }

    public boolean containsKey(Object obj) {
        purge();
        Entry entry = getEntry(obj);
        if (entry == null || entry.getValue() == null) {
            return false;
        }
        return true;
    }

    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        AnonymousClass1 r02 = new AbstractSet() {
            public void clear() {
                ReferenceMap.this.clear();
            }

            public boolean contains(Object obj) {
                if (obj == null || !(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Entry access$000 = ReferenceMap.this.getEntry(entry.getKey());
                if (access$000 == null || !entry.equals(access$000)) {
                    return false;
                }
                return true;
            }

            public Iterator iterator() {
                return new EntryIterator();
            }

            public boolean remove(Object obj) {
                boolean contains = contains(obj);
                if (contains) {
                    ReferenceMap.this.remove(((Map.Entry) obj).getKey());
                }
                return contains;
            }

            public int size() {
                return ReferenceMap.this.size();
            }

            public Object[] toArray() {
                return toArray(new Object[0]);
            }

            public Object[] toArray(Object[] objArr) {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    arrayList.add(new DefaultMapEntry(entry.getKey(), entry.getValue()));
                }
                return arrayList.toArray(objArr);
            }
        };
        this.entrySet = r02;
        return r02;
    }

    public Object get(Object obj) {
        purge();
        Entry entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public boolean isEmpty() {
        purge();
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public Set keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        AnonymousClass2 r02 = new AbstractSet() {
            public void clear() {
                ReferenceMap.this.clear();
            }

            public boolean contains(Object obj) {
                return ReferenceMap.this.containsKey(obj);
            }

            public Iterator iterator() {
                return new KeyIterator();
            }

            public boolean remove(Object obj) {
                return ReferenceMap.this.remove(obj) != null;
            }

            public int size() {
                return ReferenceMap.this.size();
            }

            public Object[] toArray() {
                return toArray(new Object[0]);
            }

            public Object[] toArray(Object[] objArr) {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                return arrayList.toArray(objArr);
            }
        };
        this.keySet = r02;
        return r02;
    }

    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null keys not allowed");
        } else if (obj2 != null) {
            purge();
            if (this.size + 1 > this.threshold) {
                resize();
            }
            int hashCode = obj.hashCode();
            int indexFor = indexFor(hashCode);
            Entry entry = this.table[indexFor];
            while (entry != null) {
                if (hashCode != entry.hash || !obj.equals(entry.getKey())) {
                    entry = entry.next;
                } else {
                    Object value = entry.getValue();
                    entry.setValue(obj2);
                    return value;
                }
            }
            this.size++;
            this.modCount++;
            Object reference = toReference(this.keyType, obj, hashCode);
            Object reference2 = toReference(this.valueType, obj2, hashCode);
            Entry[] entryArr = this.table;
            entryArr[indexFor] = new Entry(reference, hashCode, reference2, entryArr[indexFor]);
            return null;
        } else {
            throw new NullPointerException("null values not allowed");
        }
    }

    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        purge();
        int hashCode = obj.hashCode();
        int indexFor = indexFor(hashCode);
        Entry entry = this.table[indexFor];
        Entry entry2 = null;
        while (entry != null) {
            if (hashCode != entry.hash || !obj.equals(entry.getKey())) {
                entry2 = entry;
                entry = entry.next;
            } else {
                if (entry2 == null) {
                    this.table[indexFor] = entry.next;
                } else {
                    entry2.next = entry.next;
                }
                this.size--;
                this.modCount++;
                return entry.getValue();
            }
        }
        return null;
    }

    public int size() {
        purge();
        return this.size;
    }

    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        AnonymousClass3 r02 = new AbstractCollection() {
            public void clear() {
                ReferenceMap.this.clear();
            }

            public Iterator iterator() {
                return new ValueIterator();
            }

            public int size() {
                return ReferenceMap.this.size();
            }

            public Object[] toArray() {
                return toArray(new Object[0]);
            }

            public Object[] toArray(Object[] objArr) {
                ArrayList arrayList = new ArrayList(size());
                Iterator it = iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                return arrayList.toArray(objArr);
            }
        };
        this.values = r02;
        return r02;
    }

    public ReferenceMap(int i10, int i11, boolean z10) {
        this(i10, i11);
        this.purgeValues = z10;
    }

    public ReferenceMap(int i10, int i11) {
        this(i10, i11, 16, 0.75f);
    }

    private void purge(Reference reference) {
        int indexFor = indexFor(reference.hashCode());
        Entry entry = null;
        for (Entry entry2 = this.table[indexFor]; entry2 != null; entry2 = entry2.next) {
            if (entry2.purge(reference)) {
                if (entry == null) {
                    this.table[indexFor] = entry2.next;
                } else {
                    entry.next = entry2.next;
                }
                this.size--;
                return;
            }
            entry = entry2;
        }
    }

    public ReferenceMap(int i10, int i11, int i12, float f10, boolean z10) {
        this(i10, i11, i12, f10);
        this.purgeValues = z10;
    }

    public ReferenceMap(int i10, int i11, int i12, float f10) {
        this.purgeValues = false;
        this.queue = new ReferenceQueue();
        verify("keyType", i10);
        verify("valueType", i11);
        if (i12 <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        } else if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and less than 1.");
        } else {
            this.keyType = i10;
            this.valueType = i11;
            int i13 = 1;
            while (i13 < i12) {
                i13 *= 2;
            }
            this.table = new Entry[i13];
            this.loadFactor = f10;
            this.threshold = (int) (((float) i13) * f10);
        }
    }
}
