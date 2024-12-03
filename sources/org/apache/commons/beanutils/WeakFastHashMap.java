package org.apache.commons.beanutils;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

class WeakFastHashMap<K, V> extends HashMap<K, V> {
    /* access modifiers changed from: private */
    public boolean fast;
    /* access modifiers changed from: private */
    public Map<K, V> map;

    private class EntrySet extends WeakFastHashMap<K, V>.CollectionView<Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private EntrySet() {
            super();
        }

        /* access modifiers changed from: protected */
        public Collection<Map.Entry<K, V>> get(Map<K, V> map) {
            return map.entrySet();
        }

        /* access modifiers changed from: protected */
        public Map.Entry<K, V> iteratorNext(Map.Entry<K, V> entry) {
            return entry;
        }
    }

    private class KeySet extends WeakFastHashMap<K, V>.CollectionView<K> implements Set<K> {
        private KeySet() {
            super();
        }

        /* access modifiers changed from: protected */
        public Collection<K> get(Map<K, V> map) {
            return map.keySet();
        }

        /* access modifiers changed from: protected */
        public K iteratorNext(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    private class Values extends WeakFastHashMap<K, V>.CollectionView<V> {
        private Values() {
            super();
        }

        /* access modifiers changed from: protected */
        public Collection<V> get(Map<K, V> map) {
            return map.values();
        }

        /* access modifiers changed from: protected */
        public V iteratorNext(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    public WeakFastHashMap() {
        this.map = null;
        this.fast = false;
        this.map = createMap();
    }

    public void clear() {
        if (this.fast) {
            synchronized (this) {
                this.map = createMap();
            }
            return;
        }
        synchronized (this.map) {
            this.map.clear();
        }
    }

    public Object clone() {
        WeakFastHashMap weakFastHashMap;
        WeakFastHashMap weakFastHashMap2;
        if (this.fast) {
            weakFastHashMap = new WeakFastHashMap(this.map);
        } else {
            synchronized (this.map) {
                weakFastHashMap2 = new WeakFastHashMap(this.map);
            }
            weakFastHashMap = weakFastHashMap2;
        }
        weakFastHashMap.setFast(getFast());
        return weakFastHashMap;
    }

    /* access modifiers changed from: protected */
    public Map<K, V> cloneMap(Map<? extends K, ? extends V> map2) {
        return createMap(map2);
    }

    public boolean containsKey(Object obj) {
        boolean containsKey;
        if (this.fast) {
            return this.map.containsKey(obj);
        }
        synchronized (this.map) {
            containsKey = this.map.containsKey(obj);
        }
        return containsKey;
    }

    public boolean containsValue(Object obj) {
        boolean containsValue;
        if (this.fast) {
            return this.map.containsValue(obj);
        }
        synchronized (this.map) {
            containsValue = this.map.containsValue(obj);
        }
        return containsValue;
    }

    /* access modifiers changed from: protected */
    public Map<K, V> createMap() {
        return new WeakHashMap();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0094, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r7 instanceof java.util.Map
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.Map r7 = (java.util.Map) r7
            boolean r1 = r6.fast
            if (r1 == 0) goto L_0x0056
            int r1 = r7.size()
            java.util.Map<K, V> r3 = r6.map
            int r3 = r3.size()
            if (r1 == r3) goto L_0x001d
            return r2
        L_0x001d:
            java.util.Map<K, V> r1 = r6.map
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0027:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0055
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.Object r3 = r3.getValue()
            if (r3 != 0) goto L_0x004a
            java.lang.Object r3 = r7.get(r4)
            if (r3 != 0) goto L_0x0049
            boolean r3 = r7.containsKey(r4)
            if (r3 != 0) goto L_0x0027
        L_0x0049:
            return r2
        L_0x004a:
            java.lang.Object r4 = r7.get(r4)
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0027
            return r2
        L_0x0055:
            return r0
        L_0x0056:
            java.util.Map<K, V> r1 = r6.map
            monitor-enter(r1)
            int r3 = r7.size()     // Catch:{ all -> 0x00a3 }
            java.util.Map<K, V> r4 = r6.map     // Catch:{ all -> 0x00a3 }
            int r4 = r4.size()     // Catch:{ all -> 0x00a3 }
            if (r3 == r4) goto L_0x0067
            monitor-exit(r1)     // Catch:{ all -> 0x00a3 }
            return r2
        L_0x0067:
            java.util.Map<K, V> r3 = r6.map     // Catch:{ all -> 0x00a3 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x00a3 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00a3 }
        L_0x0071:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00a3 }
            if (r4 == 0) goto L_0x00a1
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00a3 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00a3 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x00a3 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x0095
            java.lang.Object r4 = r7.get(r5)     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x0093
            boolean r4 = r7.containsKey(r5)     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x0071
        L_0x0093:
            monitor-exit(r1)     // Catch:{ all -> 0x00a3 }
            return r2
        L_0x0095:
            java.lang.Object r5 = r7.get(r5)     // Catch:{ all -> 0x00a3 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x0071
            monitor-exit(r1)     // Catch:{ all -> 0x00a3 }
            return r2
        L_0x00a1:
            monitor-exit(r1)     // Catch:{ all -> 0x00a3 }
            return r0
        L_0x00a3:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a3 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.beanutils.WeakFastHashMap.equals(java.lang.Object):boolean");
    }

    public V get(Object obj) {
        V v10;
        if (this.fast) {
            return this.map.get(obj);
        }
        synchronized (this.map) {
            v10 = this.map.get(obj);
        }
        return v10;
    }

    public boolean getFast() {
        return this.fast;
    }

    public int hashCode() {
        int i10 = 0;
        if (this.fast) {
            for (Map.Entry<K, V> hashCode : this.map.entrySet()) {
                i10 += hashCode.hashCode();
            }
            return i10;
        }
        synchronized (this.map) {
            for (Map.Entry<K, V> hashCode2 : this.map.entrySet()) {
                i10 += hashCode2.hashCode();
            }
        }
        return i10;
    }

    public boolean isEmpty() {
        boolean isEmpty;
        if (this.fast) {
            return this.map.isEmpty();
        }
        synchronized (this.map) {
            isEmpty = this.map.isEmpty();
        }
        return isEmpty;
    }

    public Set<K> keySet() {
        return new KeySet();
    }

    public V put(K k10, V v10) {
        V put;
        V put2;
        if (this.fast) {
            synchronized (this) {
                Map<K, V> cloneMap = cloneMap(this.map);
                put2 = cloneMap.put(k10, v10);
                this.map = cloneMap;
            }
            return put2;
        }
        synchronized (this.map) {
            put = this.map.put(k10, v10);
        }
        return put;
    }

    public void putAll(Map<? extends K, ? extends V> map2) {
        if (this.fast) {
            synchronized (this) {
                Map<K, V> cloneMap = cloneMap(this.map);
                cloneMap.putAll(map2);
                this.map = cloneMap;
            }
            return;
        }
        synchronized (this.map) {
            this.map.putAll(map2);
        }
    }

    public V remove(Object obj) {
        V remove;
        V remove2;
        if (this.fast) {
            synchronized (this) {
                Map<K, V> cloneMap = cloneMap(this.map);
                remove2 = cloneMap.remove(obj);
                this.map = cloneMap;
            }
            return remove2;
        }
        synchronized (this.map) {
            remove = this.map.remove(obj);
        }
        return remove;
    }

    public void setFast(boolean z10) {
        this.fast = z10;
    }

    public int size() {
        int size;
        if (this.fast) {
            return this.map.size();
        }
        synchronized (this.map) {
            size = this.map.size();
        }
        return size;
    }

    public Collection<V> values() {
        return new Values();
    }

    /* access modifiers changed from: protected */
    public Map<K, V> createMap(int i10) {
        return new WeakHashMap(i10);
    }

    /* access modifiers changed from: protected */
    public Map<K, V> createMap(int i10, float f10) {
        return new WeakHashMap(i10, f10);
    }

    /* access modifiers changed from: protected */
    public Map<K, V> createMap(Map<? extends K, ? extends V> map2) {
        return new WeakHashMap(map2);
    }

    private abstract class CollectionView<E> implements Collection<E> {

        private class CollectionViewIterator implements Iterator<E> {
            private Map<K, V> expected;
            private final Iterator<Map.Entry<K, V>> iterator;
            private Map.Entry<K, V> lastReturned = null;

            public CollectionViewIterator() {
                Map<K, V> access$400 = WeakFastHashMap.this.map;
                this.expected = access$400;
                this.iterator = access$400.entrySet().iterator();
            }

            public boolean hasNext() {
                if (this.expected == WeakFastHashMap.this.map) {
                    return this.iterator.hasNext();
                }
                throw new ConcurrentModificationException();
            }

            public E next() {
                if (this.expected == WeakFastHashMap.this.map) {
                    Map.Entry<K, V> next = this.iterator.next();
                    this.lastReturned = next;
                    return CollectionView.this.iteratorNext(next);
                }
                throw new ConcurrentModificationException();
            }

            public void remove() {
                if (this.lastReturned == null) {
                    throw new IllegalStateException();
                } else if (WeakFastHashMap.this.fast) {
                    synchronized (WeakFastHashMap.this) {
                        if (this.expected == WeakFastHashMap.this.map) {
                            WeakFastHashMap.this.remove(this.lastReturned.getKey());
                            this.lastReturned = null;
                            this.expected = WeakFastHashMap.this.map;
                        } else {
                            throw new ConcurrentModificationException();
                        }
                    }
                } else {
                    this.iterator.remove();
                    this.lastReturned = null;
                }
            }
        }

        public CollectionView() {
        }

        public boolean add(E e10) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            if (WeakFastHashMap.this.fast) {
                synchronized (WeakFastHashMap.this) {
                    WeakFastHashMap weakFastHashMap = WeakFastHashMap.this;
                    Map unused = weakFastHashMap.map = weakFastHashMap.createMap();
                }
                return;
            }
            synchronized (WeakFastHashMap.this.map) {
                get(WeakFastHashMap.this.map).clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).contains(obj);
            }
            synchronized (WeakFastHashMap.this.map) {
                contains = get(WeakFastHashMap.this.map).contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).containsAll(collection);
            }
            synchronized (WeakFastHashMap.this.map) {
                containsAll = get(WeakFastHashMap.this.map).containsAll(collection);
            }
            return containsAll;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).equals(obj);
            }
            synchronized (WeakFastHashMap.this.map) {
                equals = get(WeakFastHashMap.this.map).equals(obj);
            }
            return equals;
        }

        /* access modifiers changed from: protected */
        public abstract Collection<E> get(Map<K, V> map);

        public int hashCode() {
            int hashCode;
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).hashCode();
            }
            synchronized (WeakFastHashMap.this.map) {
                hashCode = get(WeakFastHashMap.this.map).hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).isEmpty();
            }
            synchronized (WeakFastHashMap.this.map) {
                isEmpty = get(WeakFastHashMap.this.map).isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return new CollectionViewIterator();
        }

        /* access modifiers changed from: protected */
        public abstract E iteratorNext(Map.Entry<K, V> entry);

        public boolean remove(Object obj) {
            boolean remove;
            boolean remove2;
            if (WeakFastHashMap.this.fast) {
                synchronized (WeakFastHashMap.this) {
                    WeakFastHashMap weakFastHashMap = WeakFastHashMap.this;
                    Map cloneMap = weakFastHashMap.cloneMap(weakFastHashMap.map);
                    remove2 = get(cloneMap).remove(obj);
                    Map unused = WeakFastHashMap.this.map = cloneMap;
                }
                return remove2;
            }
            synchronized (WeakFastHashMap.this.map) {
                remove = get(WeakFastHashMap.this.map).remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            boolean removeAll2;
            if (WeakFastHashMap.this.fast) {
                synchronized (WeakFastHashMap.this) {
                    WeakFastHashMap weakFastHashMap = WeakFastHashMap.this;
                    Map cloneMap = weakFastHashMap.cloneMap(weakFastHashMap.map);
                    removeAll2 = get(cloneMap).removeAll(collection);
                    Map unused = WeakFastHashMap.this.map = cloneMap;
                }
                return removeAll2;
            }
            synchronized (WeakFastHashMap.this.map) {
                removeAll = get(WeakFastHashMap.this.map).removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            boolean retainAll2;
            if (WeakFastHashMap.this.fast) {
                synchronized (WeakFastHashMap.this) {
                    WeakFastHashMap weakFastHashMap = WeakFastHashMap.this;
                    Map cloneMap = weakFastHashMap.cloneMap(weakFastHashMap.map);
                    retainAll2 = get(cloneMap).retainAll(collection);
                    Map unused = WeakFastHashMap.this.map = cloneMap;
                }
                return retainAll2;
            }
            synchronized (WeakFastHashMap.this.map) {
                retainAll = get(WeakFastHashMap.this.map).retainAll(collection);
            }
            return retainAll;
        }

        public int size() {
            int size;
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).size();
            }
            synchronized (WeakFastHashMap.this.map) {
                size = get(WeakFastHashMap.this.map).size();
            }
            return size;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] array2;
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).toArray(tArr);
            }
            synchronized (WeakFastHashMap.this.map) {
                array2 = get(WeakFastHashMap.this.map).toArray(tArr);
            }
            return array2;
        }

        public Object[] toArray() {
            Object[] array2;
            if (WeakFastHashMap.this.fast) {
                return get(WeakFastHashMap.this.map).toArray();
            }
            synchronized (WeakFastHashMap.this.map) {
                array2 = get(WeakFastHashMap.this.map).toArray();
            }
            return array2;
        }
    }

    public WeakFastHashMap(int i10) {
        this.map = null;
        this.fast = false;
        this.map = createMap(i10);
    }

    public WeakFastHashMap(int i10, float f10) {
        this.map = null;
        this.fast = false;
        this.map = createMap(i10, f10);
    }

    public WeakFastHashMap(Map<? extends K, ? extends V> map2) {
        this.map = null;
        this.fast = false;
        this.map = createMap(map2);
    }
}
