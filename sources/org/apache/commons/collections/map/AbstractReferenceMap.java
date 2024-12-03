package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.keyvalue.DefaultMapEntry;
import org.apache.commons.collections.map.AbstractHashedMap;

public abstract class AbstractReferenceMap extends AbstractHashedMap {
    public static final int HARD = 0;
    public static final int SOFT = 1;
    public static final int WEAK = 2;
    protected int keyType;
    protected boolean purgeValues;
    /* access modifiers changed from: private */
    public transient ReferenceQueue queue;
    protected int valueType;

    protected static class ReferenceEntry extends AbstractHashedMap.HashEntry {
        protected final AbstractReferenceMap parent;

        public ReferenceEntry(AbstractReferenceMap abstractReferenceMap, AbstractHashedMap.HashEntry hashEntry, int i10, Object obj, Object obj2) {
            super(hashEntry, i10, (Object) null, (Object) null);
            this.parent = abstractReferenceMap;
            this.key = toReference(abstractReferenceMap.keyType, obj, i10);
            this.value = toReference(abstractReferenceMap.valueType, obj2, i10);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null || value == null) {
                return false;
            }
            if (!this.parent.isEqualKey(key, this.key) || !this.parent.isEqualValue(value, getValue())) {
                return false;
            }
            return true;
        }

        public Object getKey() {
            return this.parent.keyType > 0 ? ((Reference) this.key).get() : this.key;
        }

        public Object getValue() {
            return this.parent.valueType > 0 ? ((Reference) this.value).get() : this.value;
        }

        public int hashCode() {
            return this.parent.hashEntry(getKey(), getValue());
        }

        /* access modifiers changed from: protected */
        public ReferenceEntry next() {
            return (ReferenceEntry) this.next;
        }

        /* access modifiers changed from: package-private */
        public boolean purge(Reference reference) {
            boolean z10;
            AbstractReferenceMap abstractReferenceMap = this.parent;
            int i10 = abstractReferenceMap.keyType;
            boolean z11 = true;
            if (i10 <= 0 || this.key != reference) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10 && (abstractReferenceMap.valueType <= 0 || this.value != reference)) {
                z11 = false;
            }
            if (z11) {
                if (i10 > 0) {
                    ((Reference) this.key).clear();
                }
                AbstractReferenceMap abstractReferenceMap2 = this.parent;
                if (abstractReferenceMap2.valueType > 0) {
                    ((Reference) this.value).clear();
                } else if (abstractReferenceMap2.purgeValues) {
                    this.value = null;
                }
            }
            return z11;
        }

        public Object setValue(Object obj) {
            Object value = getValue();
            if (this.parent.valueType > 0) {
                ((Reference) this.value).clear();
            }
            this.value = toReference(this.parent.valueType, obj, this.hashCode);
            return value;
        }

        /* access modifiers changed from: protected */
        public Object toReference(int i10, Object obj, int i11) {
            if (i10 == 0) {
                return obj;
            }
            if (i10 == 1) {
                return new SoftRef(i11, obj, this.parent.queue);
            }
            if (i10 == 2) {
                return new WeakRef(i11, obj, this.parent.queue);
            }
            throw new Error();
        }
    }

    static class ReferenceEntrySet extends AbstractHashedMap.EntrySet {
        protected ReferenceEntrySet(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        public Object[] toArray(Object[] objArr) {
            ArrayList arrayList = new ArrayList();
            Iterator it = iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(new DefaultMapEntry(entry.getKey(), entry.getValue()));
            }
            return arrayList.toArray(objArr);
        }
    }

    static class ReferenceEntrySetIterator implements Iterator {
        Object currentKey;
        Object currentValue;
        ReferenceEntry entry;
        int expectedModCount;
        int index;
        Object nextKey;
        Object nextValue;
        final AbstractReferenceMap parent;
        ReferenceEntry previous;

        public ReferenceEntrySetIterator(AbstractReferenceMap abstractReferenceMap) {
            int i10;
            this.parent = abstractReferenceMap;
            if (abstractReferenceMap.size() != 0) {
                i10 = abstractReferenceMap.data.length;
            } else {
                i10 = 0;
            }
            this.index = i10;
            this.expectedModCount = abstractReferenceMap.modCount;
        }

        private void checkMod() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean nextNull() {
            return this.nextKey == null || this.nextValue == null;
        }

        /* access modifiers changed from: protected */
        public ReferenceEntry currentEntry() {
            checkMod();
            return this.previous;
        }

        public boolean hasNext() {
            checkMod();
            while (nextNull()) {
                ReferenceEntry referenceEntry = this.entry;
                int i10 = this.index;
                while (referenceEntry == null && i10 > 0) {
                    i10--;
                    referenceEntry = (ReferenceEntry) this.parent.data[i10];
                }
                this.entry = referenceEntry;
                this.index = i10;
                if (referenceEntry == null) {
                    this.currentKey = null;
                    this.currentValue = null;
                    return false;
                }
                this.nextKey = referenceEntry.getKey();
                this.nextValue = referenceEntry.getValue();
                if (nextNull()) {
                    this.entry = this.entry.next();
                }
            }
            return true;
        }

        public Object next() {
            return nextEntry();
        }

        /* access modifiers changed from: protected */
        public ReferenceEntry nextEntry() {
            checkMod();
            if (!nextNull() || hasNext()) {
                ReferenceEntry referenceEntry = this.entry;
                this.previous = referenceEntry;
                this.entry = referenceEntry.next();
                this.currentKey = this.nextKey;
                this.currentValue = this.nextValue;
                this.nextKey = null;
                this.nextValue = null;
                return this.previous;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkMod();
            if (this.previous != null) {
                this.parent.remove(this.currentKey);
                this.previous = null;
                this.currentKey = null;
                this.currentValue = null;
                this.expectedModCount = this.parent.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    static class ReferenceKeySet extends AbstractHashedMap.KeySet {
        protected ReferenceKeySet(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        public Object[] toArray(Object[] objArr) {
            ArrayList arrayList = new ArrayList(this.parent.size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList.toArray(objArr);
        }
    }

    static class ReferenceKeySetIterator extends ReferenceEntrySetIterator {
        ReferenceKeySetIterator(AbstractReferenceMap abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        public Object next() {
            return nextEntry().getKey();
        }
    }

    static class ReferenceMapIterator extends ReferenceEntrySetIterator implements MapIterator {
        protected ReferenceMapIterator(AbstractReferenceMap abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        public Object getKey() {
            ReferenceEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            ReferenceEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public Object next() {
            return nextEntry().getKey();
        }

        public Object setValue(Object obj) {
            ReferenceEntry currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.setValue(obj);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    static class ReferenceValues extends AbstractHashedMap.Values {
        protected ReferenceValues(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        public Object[] toArray(Object[] objArr) {
            ArrayList arrayList = new ArrayList(this.parent.size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList.toArray(objArr);
        }
    }

    static class ReferenceValuesIterator extends ReferenceEntrySetIterator {
        ReferenceValuesIterator(AbstractReferenceMap abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        public Object next() {
            return nextEntry().getValue();
        }
    }

    static class SoftRef extends SoftReference {
        private int hash;

        public SoftRef(int i10, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i10;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    static class WeakRef extends WeakReference {
        private int hash;

        public WeakRef(int i10, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i10;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    protected AbstractReferenceMap() {
    }

    private static void verify(String str, int i10) {
        if (i10 < 0 || i10 > 2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" must be HARD, SOFT, WEAK.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public void clear() {
        super.clear();
        do {
        } while (this.queue.poll() != null);
    }

    public boolean containsKey(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry entry = getEntry(obj);
        if (entry == null || entry.getValue() == null) {
            return false;
        }
        return true;
    }

    public boolean containsValue(Object obj) {
        purgeBeforeRead();
        if (obj == null) {
            return false;
        }
        return super.containsValue(obj);
    }

    /* access modifiers changed from: protected */
    public AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i10, Object obj, Object obj2) {
        return new ReferenceEntry(this, hashEntry, i10, obj, obj2);
    }

    /* access modifiers changed from: protected */
    public Iterator createEntrySetIterator() {
        return new ReferenceEntrySetIterator(this);
    }

    /* access modifiers changed from: protected */
    public Iterator createKeySetIterator() {
        return new ReferenceKeySetIterator(this);
    }

    /* access modifiers changed from: protected */
    public Iterator createValuesIterator() {
        return new ReferenceValuesIterator(this);
    }

    /* access modifiers changed from: protected */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.keyType = objectInputStream.readInt();
        this.valueType = objectInputStream.readInt();
        this.purgeValues = objectInputStream.readBoolean();
        this.loadFactor = objectInputStream.readFloat();
        int readInt = objectInputStream.readInt();
        init();
        this.data = new AbstractHashedMap.HashEntry[readInt];
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                this.threshold = calculateThreshold(this.data.length, this.loadFactor);
                return;
            }
            put(readObject, objectInputStream.readObject());
        }
    }

    /* access modifiers changed from: protected */
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.keyType);
        objectOutputStream.writeInt(this.valueType);
        objectOutputStream.writeBoolean(this.purgeValues);
        objectOutputStream.writeFloat(this.loadFactor);
        objectOutputStream.writeInt(this.data.length);
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
        objectOutputStream.writeObject((Object) null);
    }

    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new ReferenceEntrySet(this);
        }
        return this.entrySet;
    }

    public Object get(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    /* access modifiers changed from: protected */
    public AbstractHashedMap.HashEntry getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        return super.getEntry(obj);
    }

    /* access modifiers changed from: protected */
    public int hashEntry(Object obj, Object obj2) {
        int i10 = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 != null) {
            i10 = obj2.hashCode();
        }
        return hashCode ^ i10;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.queue = new ReferenceQueue();
    }

    public boolean isEmpty() {
        purgeBeforeRead();
        return super.isEmpty();
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(Object obj, Object obj2) {
        if (this.keyType > 0) {
            obj2 = ((Reference) obj2).get();
        }
        if (obj == obj2 || obj.equals(obj2)) {
            return true;
        }
        return false;
    }

    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new ReferenceKeySet(this);
        }
        return this.keySet;
    }

    public MapIterator mapIterator() {
        return new ReferenceMapIterator(this);
    }

    /* access modifiers changed from: protected */
    public void purge() {
        Reference poll = this.queue.poll();
        while (poll != null) {
            purge(poll);
            poll = this.queue.poll();
        }
    }

    /* access modifiers changed from: protected */
    public void purgeBeforeRead() {
        purge();
    }

    /* access modifiers changed from: protected */
    public void purgeBeforeWrite() {
        purge();
    }

    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null keys not allowed");
        } else if (obj2 != null) {
            purgeBeforeWrite();
            return super.put(obj, obj2);
        } else {
            throw new NullPointerException("null values not allowed");
        }
    }

    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        purgeBeforeWrite();
        return super.remove(obj);
    }

    public int size() {
        purgeBeforeRead();
        return super.size();
    }

    public Collection values() {
        if (this.values == null) {
            this.values = new ReferenceValues(this);
        }
        return this.values;
    }

    protected AbstractReferenceMap(int i10, int i11, int i12, float f10, boolean z10) {
        super(i12, f10);
        verify("keyType", i10);
        verify("valueType", i11);
        this.keyType = i10;
        this.valueType = i11;
        this.purgeValues = z10;
    }

    /* access modifiers changed from: protected */
    public void purge(Reference reference) {
        int hashIndex = hashIndex(reference.hashCode(), this.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.data[hashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (((ReferenceEntry) hashEntry2).purge(reference)) {
                if (hashEntry == null) {
                    this.data[hashIndex] = hashEntry2.next;
                } else {
                    hashEntry.next = hashEntry2.next;
                }
                this.size--;
                return;
            }
            hashEntry = hashEntry2;
        }
    }
}
