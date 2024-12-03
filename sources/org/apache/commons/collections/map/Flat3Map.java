package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.EmptyMapIterator;

public class Flat3Map implements IterableMap, Serializable, Cloneable {
    private static final long serialVersionUID = -6701087419741928296L;
    /* access modifiers changed from: private */
    public transient AbstractHashedMap delegateMap;
    private transient int hash1;
    private transient int hash2;
    private transient int hash3;
    /* access modifiers changed from: private */
    public transient Object key1;
    /* access modifiers changed from: private */
    public transient Object key2;
    /* access modifiers changed from: private */
    public transient Object key3;
    /* access modifiers changed from: private */
    public transient int size;
    /* access modifiers changed from: private */
    public transient Object value1;
    /* access modifiers changed from: private */
    public transient Object value2;
    /* access modifiers changed from: private */
    public transient Object value3;

    static class EntrySet extends AbstractSet {
        private final Flat3Map parent;

        EntrySet(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        public void clear() {
            this.parent.clear();
        }

        public Iterator iterator() {
            if (this.parent.delegateMap != null) {
                return this.parent.delegateMap.entrySet().iterator();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.INSTANCE;
            }
            return new EntrySetIterator(this.parent);
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Object key = ((Map.Entry) obj).getKey();
            boolean containsKey = this.parent.containsKey(key);
            this.parent.remove(key);
            return containsKey;
        }

        public int size() {
            return this.parent.size();
        }
    }

    static class EntrySetIterator implements Iterator, Map.Entry {
        private boolean canRemove = false;
        private int nextIndex = 0;
        private final Flat3Map parent;

        EntrySetIterator(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0037 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                boolean r0 = r4.canRemove
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                boolean r0 = r5 instanceof java.util.Map.Entry
                if (r0 != 0) goto L_0x000b
                return r1
            L_0x000b:
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r0 = r4.getKey()
                java.lang.Object r2 = r4.getValue()
                if (r0 != 0) goto L_0x001e
                java.lang.Object r0 = r5.getKey()
                if (r0 != 0) goto L_0x0038
                goto L_0x0028
            L_0x001e:
                java.lang.Object r3 = r5.getKey()
                boolean r0 = r0.equals(r3)
                if (r0 == 0) goto L_0x0038
            L_0x0028:
                java.lang.Object r5 = r5.getValue()
                if (r2 != 0) goto L_0x0031
                if (r5 != 0) goto L_0x0038
                goto L_0x0037
            L_0x0031:
                boolean r5 = r2.equals(r5)
                if (r5 == 0) goto L_0x0038
            L_0x0037:
                r1 = 1
            L_0x0038:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.map.Flat3Map.EntrySetIterator.equals(java.lang.Object):boolean");
        }

        public Object getKey() {
            if (this.canRemove) {
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    return this.parent.key1;
                }
                if (i10 == 2) {
                    return this.parent.key2;
                }
                if (i10 == 3) {
                    return this.parent.key3;
                }
                throw new IllegalStateException("Invalid map index");
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            if (this.canRemove) {
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    return this.parent.value1;
                }
                if (i10 == 2) {
                    return this.parent.value2;
                }
                if (i10 == 3) {
                    return this.parent.value3;
                }
                throw new IllegalStateException("Invalid map index");
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public boolean hasNext() {
            return this.nextIndex < this.parent.size;
        }

        public int hashCode() {
            int i10;
            int i11 = 0;
            if (!this.canRemove) {
                return 0;
            }
            Object key = getKey();
            Object value = getValue();
            if (key == null) {
                i10 = 0;
            } else {
                i10 = key.hashCode();
            }
            if (value != null) {
                i11 = value.hashCode();
            }
            return i10 ^ i11;
        }

        public Object next() {
            if (hasNext()) {
                this.canRemove = true;
                this.nextIndex++;
                return this;
            }
            throw new NoSuchElementException("No next() entry in the iteration");
        }

        public void remove() {
            if (this.canRemove) {
                this.parent.remove(getKey());
                this.nextIndex--;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("remove() can only be called once after next()");
        }

        public Object setValue(Object obj) {
            if (this.canRemove) {
                Object value = getValue();
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    Object unused = this.parent.value1 = obj;
                } else if (i10 == 2) {
                    Object unused2 = this.parent.value2 = obj;
                } else if (i10 == 3) {
                    Object unused3 = this.parent.value3 = obj;
                }
                return value;
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (!this.canRemove) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getKey());
            stringBuffer.append("=");
            stringBuffer.append(getValue());
            return stringBuffer.toString();
        }
    }

    static class FlatMapIterator implements MapIterator, ResettableIterator {
        private boolean canRemove = false;
        private int nextIndex = 0;
        private final Flat3Map parent;

        FlatMapIterator(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        public Object getKey() {
            if (this.canRemove) {
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    return this.parent.key1;
                }
                if (i10 == 2) {
                    return this.parent.key2;
                }
                if (i10 == 3) {
                    return this.parent.key3;
                }
                throw new IllegalStateException("Invalid map index");
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        public Object getValue() {
            if (this.canRemove) {
                int i10 = this.nextIndex;
                if (i10 == 1) {
                    return this.parent.value1;
                }
                if (i10 == 2) {
                    return this.parent.value2;
                }
                if (i10 == 3) {
                    return this.parent.value3;
                }
                throw new IllegalStateException("Invalid map index");
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        public boolean hasNext() {
            return this.nextIndex < this.parent.size;
        }

        public Object next() {
            if (hasNext()) {
                this.canRemove = true;
                this.nextIndex++;
                return getKey();
            }
            throw new NoSuchElementException("No next() entry in the iteration");
        }

        public void remove() {
            if (this.canRemove) {
                this.parent.remove(getKey());
                this.nextIndex--;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("remove() can only be called once after next()");
        }

        public void reset() {
            this.nextIndex = 0;
            this.canRemove = false;
        }

        public Object setValue(Object obj) {
            if (this.canRemove) {
                Object value = getValue();
                int i10 = this.nextIndex;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            Object unused = this.parent.value3 = obj;
                        }
                        return value;
                    }
                    Object unused2 = this.parent.value2 = obj;
                }
                Object unused3 = this.parent.value1 = obj;
                return value;
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (!this.canRemove) {
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

    static class KeySet extends AbstractSet {
        private final Flat3Map parent;

        KeySet(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        public Iterator iterator() {
            if (this.parent.delegateMap != null) {
                return this.parent.delegateMap.keySet().iterator();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.INSTANCE;
            }
            return new KeySetIterator(this.parent);
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

    static class KeySetIterator extends EntrySetIterator {
        KeySetIterator(Flat3Map flat3Map) {
            super(flat3Map);
        }

        public Object next() {
            super.next();
            return getKey();
        }
    }

    static class Values extends AbstractCollection {
        private final Flat3Map parent;

        Values(Flat3Map flat3Map) {
            this.parent = flat3Map;
        }

        public void clear() {
            this.parent.clear();
        }

        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        public Iterator iterator() {
            if (this.parent.delegateMap != null) {
                return this.parent.delegateMap.values().iterator();
            }
            if (this.parent.size() == 0) {
                return EmptyIterator.INSTANCE;
            }
            return new ValuesIterator(this.parent);
        }

        public int size() {
            return this.parent.size();
        }
    }

    static class ValuesIterator extends EntrySetIterator {
        ValuesIterator(Flat3Map flat3Map) {
            super(flat3Map);
        }

        public Object next() {
            super.next();
            return getValue();
        }
    }

    public Flat3Map() {
    }

    private void convertToMap() {
        AbstractHashedMap createDelegateMap = createDelegateMap();
        this.delegateMap = createDelegateMap;
        int i10 = this.size;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    createDelegateMap.put(this.key3, this.value3);
                }
                this.size = 0;
                this.hash3 = 0;
                this.hash2 = 0;
                this.hash1 = 0;
                this.key3 = null;
                this.key2 = null;
                this.key1 = null;
                this.value3 = null;
                this.value2 = null;
                this.value1 = null;
            }
            this.delegateMap.put(this.key2, this.value2);
        }
        this.delegateMap.put(this.key1, this.value1);
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt > 3) {
            this.delegateMap = createDelegateMap();
        }
        while (readInt > 0) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
            readInt--;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    public void clear() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            abstractHashedMap.clear();
            this.delegateMap = null;
            return;
        }
        this.size = 0;
        this.hash3 = 0;
        this.hash2 = 0;
        this.hash1 = 0;
        this.key3 = null;
        this.key2 = null;
        this.key1 = null;
        this.value3 = null;
        this.value2 = null;
        this.value1 = null;
    }

    public Object clone() {
        try {
            Flat3Map flat3Map = (Flat3Map) super.clone();
            AbstractHashedMap abstractHashedMap = flat3Map.delegateMap;
            if (abstractHashedMap != null) {
                flat3Map.delegateMap = (HashedMap) abstractHashedMap.clone();
            }
            return flat3Map;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean containsKey(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.containsKey(obj);
        }
        if (obj == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return false;
                    }
                    if (this.key3 == null) {
                        return true;
                    }
                }
                if (this.key2 == null) {
                    return true;
                }
            }
            if (this.key1 == null) {
                return true;
            }
            return false;
        } else if (this.size <= 0) {
            return false;
        } else {
            int hashCode = obj.hashCode();
            int i11 = this.size;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        return false;
                    }
                    if (this.hash3 == hashCode && obj.equals(this.key3)) {
                        return true;
                    }
                }
                if (this.hash2 == hashCode && obj.equals(this.key2)) {
                    return true;
                }
            }
            if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                return false;
            }
            return true;
        }
    }

    public boolean containsValue(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.containsValue(obj);
        }
        if (obj == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return false;
                    }
                    if (this.value3 == null) {
                        return true;
                    }
                }
                if (this.value2 == null) {
                    return true;
                }
            }
            if (this.value1 == null) {
                return true;
            }
            return false;
        }
        int i11 = this.size;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    return false;
                }
                if (obj.equals(this.value3)) {
                    return true;
                }
            }
            if (obj.equals(this.value2)) {
                return true;
            }
        }
        if (obj.equals(this.value1)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public AbstractHashedMap createDelegateMap() {
        return new HashedMap();
    }

    public Set entrySet() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.entrySet();
        }
        return new EntrySet(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.equals(obj);
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.size != map.size()) {
            return false;
        }
        int i10 = this.size;
        if (i10 > 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (!map.containsKey(this.key3)) {
                            return false;
                        }
                        Object obj2 = map.get(this.key3);
                        Object obj3 = this.value3;
                        if (obj3 != null ? !obj3.equals(obj2) : obj2 != null) {
                            return false;
                        }
                    }
                }
                if (!map.containsKey(this.key2)) {
                    return false;
                }
                Object obj4 = map.get(this.key2);
                Object obj5 = this.value2;
                if (obj5 != null ? !obj5.equals(obj4) : obj4 != null) {
                    return false;
                }
            }
            if (!map.containsKey(this.key1)) {
                return false;
            }
            Object obj6 = map.get(this.key1);
            Object obj7 = this.value1;
            if (obj7 != null ? obj7.equals(obj6) : obj6 == null) {
                return true;
            }
            return false;
        }
        return true;
    }

    public Object get(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.get(obj);
        }
        if (obj == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    if (this.key3 == null) {
                        return this.value3;
                    }
                }
                if (this.key2 == null) {
                    return this.value2;
                }
            }
            if (this.key1 == null) {
                return this.value1;
            }
            return null;
        } else if (this.size <= 0) {
            return null;
        } else {
            int hashCode = obj.hashCode();
            int i11 = this.size;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        return null;
                    }
                    if (this.hash3 == hashCode && obj.equals(this.key3)) {
                        return this.value3;
                    }
                }
                if (this.hash2 == hashCode && obj.equals(this.key2)) {
                    return this.value2;
                }
            }
            if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                return null;
            }
            return this.value1;
        }
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.hashCode();
        }
        int i14 = this.size;
        int i15 = 0;
        if (i14 != 1) {
            if (i14 == 2) {
                i11 = 0;
            } else if (i14 != 3) {
                return 0;
            } else {
                int i16 = this.hash3;
                Object obj = this.value3;
                if (obj == null) {
                    i13 = 0;
                } else {
                    i13 = obj.hashCode();
                }
                i11 = (i16 ^ i13) + 0;
            }
            int i17 = this.hash2;
            Object obj2 = this.value2;
            if (obj2 == null) {
                i12 = 0;
            } else {
                i12 = obj2.hashCode();
            }
            i10 = i11 + (i17 ^ i12);
        } else {
            i10 = 0;
        }
        int i18 = this.hash1;
        Object obj3 = this.value1;
        if (obj3 != null) {
            i15 = obj3.hashCode();
        }
        return i10 + (i18 ^ i15);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set keySet() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.keySet();
        }
        return new KeySet(this);
    }

    public MapIterator mapIterator() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.mapIterator();
        }
        if (this.size == 0) {
            return EmptyMapIterator.INSTANCE;
        }
        return new FlatMapIterator(this);
    }

    public Object put(Object obj, Object obj2) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.put(obj, obj2);
        }
        if (obj == null) {
            int i10 = this.size;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        if (this.key3 == null) {
                            Object obj3 = this.value3;
                            this.value3 = obj2;
                            return obj3;
                        }
                    }
                }
                if (this.key2 == null) {
                    Object obj4 = this.value2;
                    this.value2 = obj2;
                    return obj4;
                }
            }
            if (this.key1 == null) {
                Object obj5 = this.value1;
                this.value1 = obj2;
                return obj5;
            }
        } else if (this.size > 0) {
            int hashCode = obj.hashCode();
            int i11 = this.size;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        if (this.hash3 == hashCode && obj.equals(this.key3)) {
                            Object obj6 = this.value3;
                            this.value3 = obj2;
                            return obj6;
                        }
                    }
                }
                if (this.hash2 == hashCode && obj.equals(this.key2)) {
                    Object obj7 = this.value2;
                    this.value2 = obj2;
                    return obj7;
                }
            }
            if (this.hash1 == hashCode && obj.equals(this.key1)) {
                Object obj8 = this.value1;
                this.value1 = obj2;
                return obj8;
            }
        }
        int i12 = this.size;
        int i13 = 0;
        if (i12 == 0) {
            if (obj != null) {
                i13 = obj.hashCode();
            }
            this.hash1 = i13;
            this.key1 = obj;
            this.value1 = obj2;
        } else if (i12 == 1) {
            if (obj != null) {
                i13 = obj.hashCode();
            }
            this.hash2 = i13;
            this.key2 = obj;
            this.value2 = obj2;
        } else if (i12 != 2) {
            convertToMap();
            this.delegateMap.put(obj, obj2);
            return null;
        } else {
            if (obj != null) {
                i13 = obj.hashCode();
            }
            this.hash3 = i13;
            this.key3 = obj;
            this.value3 = obj2;
        }
        this.size++;
        return null;
    }

    public void putAll(Map map) {
        int size2 = map.size();
        if (size2 != 0) {
            AbstractHashedMap abstractHashedMap = this.delegateMap;
            if (abstractHashedMap != null) {
                abstractHashedMap.putAll(map);
            } else if (size2 < 4) {
                for (Map.Entry entry : map.entrySet()) {
                    put(entry.getKey(), entry.getValue());
                }
            } else {
                convertToMap();
                this.delegateMap.putAll(map);
            }
        }
    }

    public Object remove(Object obj) {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.remove(obj);
        }
        int i10 = this.size;
        if (i10 == 0) {
            return null;
        }
        if (obj == null) {
            if (i10 != 1) {
                if (i10 == 2) {
                    Object obj2 = this.key2;
                    if (obj2 == null) {
                        Object obj3 = this.value2;
                        this.hash2 = 0;
                        this.key2 = null;
                        this.value2 = null;
                        this.size = 1;
                        return obj3;
                    } else if (this.key1 != null) {
                        return null;
                    } else {
                        Object obj4 = this.value1;
                        this.hash1 = this.hash2;
                        this.key1 = obj2;
                        this.value1 = this.value2;
                        this.hash2 = 0;
                        this.key2 = null;
                        this.value2 = null;
                        this.size = 1;
                        return obj4;
                    }
                } else if (i10 == 3) {
                    Object obj5 = this.key3;
                    if (obj5 == null) {
                        Object obj6 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return obj6;
                    } else if (this.key2 == null) {
                        Object obj7 = this.value2;
                        this.hash2 = this.hash3;
                        this.key2 = obj5;
                        this.value2 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return obj7;
                    } else if (this.key1 != null) {
                        return null;
                    } else {
                        Object obj8 = this.value1;
                        this.hash1 = this.hash3;
                        this.key1 = obj5;
                        this.value1 = this.value3;
                        this.hash3 = 0;
                        this.key3 = null;
                        this.value3 = null;
                        this.size = 2;
                        return obj8;
                    }
                }
            } else if (this.key1 == null) {
                Object obj9 = this.value1;
                this.hash1 = 0;
                this.key1 = null;
                this.value1 = null;
                this.size = 0;
                return obj9;
            }
        } else if (i10 > 0) {
            int hashCode = obj.hashCode();
            int i11 = this.size;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        if (this.hash3 == hashCode && obj.equals(this.key3)) {
                            Object obj10 = this.value3;
                            this.hash3 = 0;
                            this.key3 = null;
                            this.value3 = null;
                            this.size = 2;
                            return obj10;
                        } else if (this.hash2 == hashCode && obj.equals(this.key2)) {
                            Object obj11 = this.value2;
                            this.hash2 = this.hash3;
                            this.key2 = this.key3;
                            this.value2 = this.value3;
                            this.hash3 = 0;
                            this.key3 = null;
                            this.value3 = null;
                            this.size = 2;
                            return obj11;
                        } else if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                            return null;
                        } else {
                            Object obj12 = this.value1;
                            this.hash1 = this.hash3;
                            this.key1 = this.key3;
                            this.value1 = this.value3;
                            this.hash3 = 0;
                            this.key3 = null;
                            this.value3 = null;
                            this.size = 2;
                            return obj12;
                        }
                    }
                } else if (this.hash2 == hashCode && obj.equals(this.key2)) {
                    Object obj13 = this.value2;
                    this.hash2 = 0;
                    this.key2 = null;
                    this.value2 = null;
                    this.size = 1;
                    return obj13;
                } else if (this.hash1 != hashCode || !obj.equals(this.key1)) {
                    return null;
                } else {
                    Object obj14 = this.value1;
                    this.hash1 = this.hash2;
                    this.key1 = this.key2;
                    this.value1 = this.value2;
                    this.hash2 = 0;
                    this.key2 = null;
                    this.value2 = null;
                    this.size = 1;
                    return obj14;
                }
            } else if (this.hash1 == hashCode && obj.equals(this.key1)) {
                Object obj15 = this.value1;
                this.hash1 = 0;
                this.key1 = null;
                this.value1 = null;
                this.size = 0;
                return obj15;
            }
        }
        return null;
    }

    public int size() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.size();
        }
        return this.size;
    }

    public String toString() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.toString();
        }
        if (this.size == 0) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append('{');
        int i10 = this.size;
        Object obj = "(this Map)";
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    Object obj2 = this.key3;
                    if (obj2 == this) {
                        obj2 = obj;
                    }
                    stringBuffer.append(obj2);
                    stringBuffer.append(SignatureVisitor.INSTANCEOF);
                    Object obj3 = this.value3;
                    if (obj3 == this) {
                        obj3 = obj;
                    }
                    stringBuffer.append(obj3);
                    stringBuffer.append(',');
                }
                stringBuffer.append('}');
                return stringBuffer.toString();
            }
            Object obj4 = this.key2;
            if (obj4 == this) {
                obj4 = obj;
            }
            stringBuffer.append(obj4);
            stringBuffer.append(SignatureVisitor.INSTANCEOF);
            Object obj5 = this.value2;
            if (obj5 == this) {
                obj5 = obj;
            }
            stringBuffer.append(obj5);
            stringBuffer.append(',');
        }
        Object obj6 = this.key1;
        if (obj6 == this) {
            obj6 = obj;
        }
        stringBuffer.append(obj6);
        stringBuffer.append(SignatureVisitor.INSTANCEOF);
        Object obj7 = this.value1;
        if (obj7 != this) {
            obj = obj7;
        }
        stringBuffer.append(obj);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public Collection values() {
        AbstractHashedMap abstractHashedMap = this.delegateMap;
        if (abstractHashedMap != null) {
            return abstractHashedMap.values();
        }
        return new Values(this);
    }

    public Flat3Map(Map map) {
        putAll(map);
    }
}
