package org.apache.commons.collections.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.AbstractHashedMap;

public class MultiKeyMap implements IterableMap, Serializable {
    private static final long serialVersionUID = -1788199231038721040L;
    protected final AbstractHashedMap map;

    public MultiKeyMap() {
        this.map = new HashedMap();
    }

    public static MultiKeyMap decorate(AbstractHashedMap abstractHashedMap) {
        if (abstractHashedMap == null) {
            throw new IllegalArgumentException("Map must not be null");
        } else if (abstractHashedMap.size() <= 0) {
            return new MultiKeyMap(abstractHashedMap);
        } else {
            throw new IllegalArgumentException("Map must be empty");
        }
    }

    /* access modifiers changed from: protected */
    public void checkKey(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Key must not be null");
        } else if (!(obj instanceof MultiKey)) {
            throw new ClassCastException("Key must be a MultiKey");
        }
    }

    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new MultiKeyMap((AbstractHashedMap) this.map.clone());
    }

    public boolean containsKey(Object obj, Object obj2) {
        int hash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set entrySet() {
        return this.map.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.map.equals(obj);
    }

    public Object get(Object obj, Object obj2) {
        int hash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj, Object obj2) {
        int i10 = 0;
        if (obj != null) {
            i10 = 0 ^ obj.hashCode();
        }
        if (obj2 != null) {
            i10 ^= obj2.hashCode();
        }
        int i11 = i10 + (~(i10 << 9));
        int i12 = (i11 >>> 14) ^ i11;
        int i13 = i12 + (i12 << 4);
        return i13 ^ (i13 >>> 10);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 2 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 == null) {
                if (key == null) {
                    return true;
                }
            } else if (obj2.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Set keySet() {
        return this.map.keySet();
    }

    public MapIterator mapIterator() {
        return this.map.mapIterator();
    }

    public Object put(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2)) {
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj3);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2), obj3);
        return null;
    }

    public void putAll(Map map2) {
        for (Object checkKey : map2.keySet()) {
            checkKey(checkKey);
        }
        this.map.putAll(map2);
    }

    public Object remove(Object obj, Object obj2) {
        int hash = hash(obj, obj2);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        AbstractHashedMap.HashEntry hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2)) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.removeMapping(hashEntry, hashIndex, hashEntry2);
                return value;
            }
        }
        return null;
    }

    public boolean removeAll(Object obj) {
        MapIterator mapIterator = mapIterator();
        boolean z10 = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 1) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key != null) {
                    }
                } else if (!obj.equals(key)) {
                }
                mapIterator.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public int size() {
        return this.map.size();
    }

    public String toString() {
        return this.map.toString();
    }

    public Collection values() {
        return this.map.values();
    }

    protected MultiKeyMap(AbstractHashedMap abstractHashedMap) {
        this.map = abstractHashedMap;
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj, Object obj2, Object obj3) {
        int i10 = 0;
        if (obj != null) {
            i10 = 0 ^ obj.hashCode();
        }
        if (obj2 != null) {
            i10 ^= obj2.hashCode();
        }
        if (obj3 != null) {
            i10 ^= obj3.hashCode();
        }
        int i11 = i10 + (~(i10 << 9));
        int i12 = (i11 >>> 14) ^ i11;
        int i13 = i12 + (i12 << 4);
        return i13 ^ (i13 >>> 10);
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 3 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 != null ? obj2.equals(key) : key == null) {
                Object key2 = multiKey.getKey(2);
                if (obj3 == null) {
                    if (key2 == null) {
                        return true;
                    }
                } else if (obj3.equals(key2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3, Object obj4) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 4 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 != null ? obj2.equals(key) : key == null) {
                Object key2 = multiKey.getKey(2);
                if (obj3 != null ? obj3.equals(key2) : key2 == null) {
                    Object key3 = multiKey.getKey(3);
                    if (obj4 == null) {
                        if (key3 == null) {
                            return true;
                        }
                    } else if (obj4.equals(key3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Object get(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj, Object obj2, Object obj3, Object obj4) {
        int i10 = 0;
        if (obj != null) {
            i10 = 0 ^ obj.hashCode();
        }
        if (obj2 != null) {
            i10 ^= obj2.hashCode();
        }
        if (obj3 != null) {
            i10 ^= obj3.hashCode();
        }
        if (obj4 != null) {
            i10 ^= obj4.hashCode();
        }
        int i11 = i10 + (~(i10 << 9));
        int i12 = (i11 >>> 14) ^ i11;
        int i13 = i12 + (i12 << 4);
        return i13 ^ (i13 >>> 10);
    }

    public boolean removeAll(Object obj, Object obj2) {
        MapIterator mapIterator = mapIterator();
        boolean z10 = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 2) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key != null) {
                    }
                } else if (!obj.equals(key)) {
                }
                Object key2 = multiKey.getKey(1);
                if (obj2 == null) {
                    if (key2 != null) {
                    }
                } else if (!obj2.equals(key2)) {
                }
                mapIterator.remove();
                z10 = true;
            }
        }
        return z10;
    }

    /* access modifiers changed from: protected */
    public boolean isEqualKey(AbstractHashedMap.HashEntry hashEntry, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        MultiKey multiKey = (MultiKey) hashEntry.getKey();
        if (multiKey.size() == 5 && (obj != null ? obj.equals(multiKey.getKey(0)) : multiKey.getKey(0) == null)) {
            Object key = multiKey.getKey(1);
            if (obj2 != null ? obj2.equals(key) : key == null) {
                Object key2 = multiKey.getKey(2);
                if (obj3 != null ? obj3.equals(key2) : key2 == null) {
                    Object key3 = multiKey.getKey(3);
                    if (obj4 != null ? obj4.equals(key3) : key3 == null) {
                        Object key4 = multiKey.getKey(4);
                        if (obj5 == null) {
                            if (key4 == null) {
                                return true;
                            }
                        } else if (obj5.equals(key4)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public Object remove(Object obj, Object obj2, Object obj3) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        AbstractHashedMap.HashEntry hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2, obj3)) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.removeMapping(hashEntry, hashIndex, hashEntry2);
                return value;
            }
        }
        return null;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                return true;
            }
        }
        return false;
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2, obj3)) {
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj4);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2, obj3), obj4);
        return null;
    }

    /* access modifiers changed from: protected */
    public int hash(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int i10 = 0;
        if (obj != null) {
            i10 = 0 ^ obj.hashCode();
        }
        if (obj2 != null) {
            i10 ^= obj2.hashCode();
        }
        if (obj3 != null) {
            i10 ^= obj3.hashCode();
        }
        if (obj4 != null) {
            i10 ^= obj4.hashCode();
        }
        if (obj5 != null) {
            i10 ^= obj5.hashCode();
        }
        int i11 = i10 + (~(i10 << 9));
        int i12 = (i11 >>> 14) ^ i11;
        int i13 = i12 + (i12 << 4);
        return i13 ^ (i13 >>> 10);
    }

    public Object get(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean removeAll(Object obj, Object obj2, Object obj3) {
        MapIterator mapIterator = mapIterator();
        boolean z10 = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 3) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key != null) {
                    }
                } else if (!obj.equals(key)) {
                }
                Object key2 = multiKey.getKey(1);
                if (obj2 == null) {
                    if (key2 != null) {
                    }
                } else if (!obj2.equals(key2)) {
                }
                Object key3 = multiKey.getKey(2);
                if (obj3 == null) {
                    if (key3 != null) {
                    }
                } else if (!obj3.equals(key3)) {
                }
                mapIterator.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public boolean containsKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                return true;
            }
        }
        return false;
    }

    public Object remove(Object obj, Object obj2, Object obj3, Object obj4) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        AbstractHashedMap.HashEntry hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.removeMapping(hashEntry, hashIndex, hashEntry2);
                return value;
            }
        }
        return null;
    }

    public Object get(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap abstractHashedMap = this.map;
        AbstractHashedMap.HashEntry[] hashEntryArr = abstractHashedMap.data;
        for (AbstractHashedMap.HashEntry hashEntry = hashEntryArr[abstractHashedMap.hashIndex(hash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == hash && isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public boolean removeAll(Object obj, Object obj2, Object obj3, Object obj4) {
        MapIterator mapIterator = mapIterator();
        boolean z10 = false;
        while (mapIterator.hasNext()) {
            MultiKey multiKey = (MultiKey) mapIterator.next();
            if (multiKey.size() >= 4) {
                Object key = multiKey.getKey(0);
                if (obj == null) {
                    if (key != null) {
                    }
                } else if (!obj.equals(key)) {
                }
                Object key2 = multiKey.getKey(1);
                if (obj2 == null) {
                    if (key2 != null) {
                    }
                } else if (!obj2.equals(key2)) {
                }
                Object key3 = multiKey.getKey(2);
                if (obj3 == null) {
                    if (key3 != null) {
                    }
                } else if (!obj3.equals(key3)) {
                }
                Object key4 = multiKey.getKey(3);
                if (obj4 == null) {
                    if (key4 != null) {
                    }
                } else if (!obj4.equals(key4)) {
                }
                mapIterator.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2, obj3, obj4)) {
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj5);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2, obj3, obj4), obj5);
        return null;
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public Object remove(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        AbstractHashedMap.HashEntry hashEntry2 = null;
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.removeMapping(hashEntry, hashIndex, hashEntry2);
                return value;
            }
        }
        return null;
    }

    public Object put(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object obj7 = obj6;
        int hash = hash(obj, obj2, obj3, obj4, obj5);
        AbstractHashedMap abstractHashedMap = this.map;
        int hashIndex = abstractHashedMap.hashIndex(hash, abstractHashedMap.data.length);
        AbstractHashedMap.HashEntry hashEntry = this.map.data[hashIndex];
        while (hashEntry != null) {
            if (hashEntry.hashCode != hash || !isEqualKey(hashEntry, obj, obj2, obj3, obj4, obj5)) {
                hashEntry = hashEntry.next;
            } else {
                Object value = hashEntry.getValue();
                this.map.updateEntry(hashEntry, obj7);
                return value;
            }
        }
        this.map.addMapping(hashIndex, hash, new MultiKey(obj, obj2, obj3, obj4, obj5), obj7);
        return null;
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public Object put(Object obj, Object obj2) {
        checkKey(obj);
        return this.map.put(obj, obj2);
    }
}
