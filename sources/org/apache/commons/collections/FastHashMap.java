package org.apache.commons.collections;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FastHashMap extends HashMap {
    protected boolean fast;
    protected HashMap map;

    private class EntrySet extends CollectionView implements Set {
        private final /* synthetic */ FastHashMap this$0;

        private EntrySet(FastHashMap fastHashMap) {
            super();
            this.this$0 = fastHashMap;
        }

        /* access modifiers changed from: protected */
        public Collection get(Map map) {
            return map.entrySet();
        }

        /* access modifiers changed from: protected */
        public Object iteratorNext(Map.Entry entry) {
            return entry;
        }
    }

    private class KeySet extends CollectionView implements Set {
        private final /* synthetic */ FastHashMap this$0;

        private KeySet(FastHashMap fastHashMap) {
            super();
            this.this$0 = fastHashMap;
        }

        /* access modifiers changed from: protected */
        public Collection get(Map map) {
            return map.keySet();
        }

        /* access modifiers changed from: protected */
        public Object iteratorNext(Map.Entry entry) {
            return entry.getKey();
        }
    }

    private class Values extends CollectionView {
        private final /* synthetic */ FastHashMap this$0;

        private Values(FastHashMap fastHashMap) {
            super();
            this.this$0 = fastHashMap;
        }

        /* access modifiers changed from: protected */
        public Collection get(Map map) {
            return map.values();
        }

        /* access modifiers changed from: protected */
        public Object iteratorNext(Map.Entry entry) {
            return entry.getValue();
        }
    }

    public FastHashMap() {
        this.map = null;
        this.fast = false;
        this.map = new HashMap();
    }

    public void clear() {
        if (this.fast) {
            synchronized (this) {
                this.map = new HashMap();
            }
            return;
        }
        synchronized (this.map) {
            this.map.clear();
        }
    }

    public Object clone() {
        FastHashMap fastHashMap;
        FastHashMap fastHashMap2;
        if (this.fast) {
            fastHashMap = new FastHashMap((Map) this.map);
        } else {
            synchronized (this.map) {
                fastHashMap2 = new FastHashMap((Map) this.map);
            }
            fastHashMap = fastHashMap2;
        }
        fastHashMap.setFast(getFast());
        return fastHashMap;
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

    public Set entrySet() {
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
            java.util.HashMap r3 = r6.map
            int r3 = r3.size()
            if (r1 == r3) goto L_0x001d
            return r2
        L_0x001d:
            java.util.HashMap r1 = r6.map
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
            java.util.HashMap r1 = r6.map
            monitor-enter(r1)
            int r3 = r7.size()     // Catch:{ all -> 0x00a3 }
            java.util.HashMap r4 = r6.map     // Catch:{ all -> 0x00a3 }
            int r4 = r4.size()     // Catch:{ all -> 0x00a3 }
            if (r3 == r4) goto L_0x0067
            monitor-exit(r1)     // Catch:{ all -> 0x00a3 }
            return r2
        L_0x0067:
            java.util.HashMap r3 = r6.map     // Catch:{ all -> 0x00a3 }
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
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.FastHashMap.equals(java.lang.Object):boolean");
    }

    public Object get(Object obj) {
        Object obj2;
        if (this.fast) {
            return this.map.get(obj);
        }
        synchronized (this.map) {
            obj2 = this.map.get(obj);
        }
        return obj2;
    }

    public boolean getFast() {
        return this.fast;
    }

    public int hashCode() {
        int i10 = 0;
        if (this.fast) {
            for (Object hashCode : this.map.entrySet()) {
                i10 += hashCode.hashCode();
            }
            return i10;
        }
        synchronized (this.map) {
            for (Object hashCode2 : this.map.entrySet()) {
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

    public Set keySet() {
        return new KeySet();
    }

    public Object put(Object obj, Object obj2) {
        Object put;
        Object put2;
        if (this.fast) {
            synchronized (this) {
                HashMap hashMap = (HashMap) this.map.clone();
                put2 = hashMap.put(obj, obj2);
                this.map = hashMap;
            }
            return put2;
        }
        synchronized (this.map) {
            put = this.map.put(obj, obj2);
        }
        return put;
    }

    public void putAll(Map map2) {
        if (this.fast) {
            synchronized (this) {
                HashMap hashMap = (HashMap) this.map.clone();
                hashMap.putAll(map2);
                this.map = hashMap;
            }
            return;
        }
        synchronized (this.map) {
            this.map.putAll(map2);
        }
    }

    public Object remove(Object obj) {
        Object remove;
        Object remove2;
        if (this.fast) {
            synchronized (this) {
                HashMap hashMap = (HashMap) this.map.clone();
                remove2 = hashMap.remove(obj);
                this.map = hashMap;
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

    public Collection values() {
        return new Values();
    }

    private abstract class CollectionView implements Collection {

        private class CollectionViewIterator implements Iterator {
            private Map expected;
            private Iterator iterator;
            private Map.Entry lastReturned = null;

            public CollectionViewIterator() {
                HashMap hashMap = FastHashMap.this.map;
                this.expected = hashMap;
                this.iterator = hashMap.entrySet().iterator();
            }

            public boolean hasNext() {
                if (this.expected == FastHashMap.this.map) {
                    return this.iterator.hasNext();
                }
                throw new ConcurrentModificationException();
            }

            public Object next() {
                if (this.expected == FastHashMap.this.map) {
                    Map.Entry entry = (Map.Entry) this.iterator.next();
                    this.lastReturned = entry;
                    return CollectionView.this.iteratorNext(entry);
                }
                throw new ConcurrentModificationException();
            }

            public void remove() {
                if (this.lastReturned == null) {
                    throw new IllegalStateException();
                } else if (FastHashMap.this.fast) {
                    synchronized (FastHashMap.this) {
                        if (this.expected == FastHashMap.this.map) {
                            FastHashMap.this.remove(this.lastReturned.getKey());
                            this.lastReturned = null;
                            this.expected = FastHashMap.this.map;
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

        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                synchronized (fastHashMap) {
                    FastHashMap.this.map = new HashMap();
                }
                return;
            }
            synchronized (fastHashMap.map) {
                get(FastHashMap.this.map).clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).contains(obj);
            }
            synchronized (fastHashMap.map) {
                contains = get(FastHashMap.this.map).contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection collection) {
            boolean containsAll;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).containsAll(collection);
            }
            synchronized (fastHashMap.map) {
                containsAll = get(FastHashMap.this.map).containsAll(collection);
            }
            return containsAll;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).equals(obj);
            }
            synchronized (fastHashMap.map) {
                equals = get(FastHashMap.this.map).equals(obj);
            }
            return equals;
        }

        /* access modifiers changed from: protected */
        public abstract Collection get(Map map);

        public int hashCode() {
            int hashCode;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).hashCode();
            }
            synchronized (fastHashMap.map) {
                hashCode = get(FastHashMap.this.map).hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).isEmpty();
            }
            synchronized (fastHashMap.map) {
                isEmpty = get(FastHashMap.this.map).isEmpty();
            }
            return isEmpty;
        }

        public Iterator iterator() {
            return new CollectionViewIterator();
        }

        /* access modifiers changed from: protected */
        public abstract Object iteratorNext(Map.Entry entry);

        public boolean remove(Object obj) {
            boolean remove;
            boolean remove2;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                synchronized (fastHashMap) {
                    HashMap hashMap = (HashMap) FastHashMap.this.map.clone();
                    remove2 = get(hashMap).remove(obj);
                    FastHashMap.this.map = hashMap;
                }
                return remove2;
            }
            synchronized (fastHashMap.map) {
                remove = get(FastHashMap.this.map).remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection collection) {
            boolean removeAll;
            boolean removeAll2;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                synchronized (fastHashMap) {
                    HashMap hashMap = (HashMap) FastHashMap.this.map.clone();
                    removeAll2 = get(hashMap).removeAll(collection);
                    FastHashMap.this.map = hashMap;
                }
                return removeAll2;
            }
            synchronized (fastHashMap.map) {
                removeAll = get(FastHashMap.this.map).removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection collection) {
            boolean retainAll;
            boolean retainAll2;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                synchronized (fastHashMap) {
                    HashMap hashMap = (HashMap) FastHashMap.this.map.clone();
                    retainAll2 = get(hashMap).retainAll(collection);
                    FastHashMap.this.map = hashMap;
                }
                return retainAll2;
            }
            synchronized (fastHashMap.map) {
                retainAll = get(FastHashMap.this.map).retainAll(collection);
            }
            return retainAll;
        }

        public int size() {
            int size;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).size();
            }
            synchronized (fastHashMap.map) {
                size = get(FastHashMap.this.map).size();
            }
            return size;
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array2;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).toArray(objArr);
            }
            synchronized (fastHashMap.map) {
                array2 = get(FastHashMap.this.map).toArray(objArr);
            }
            return array2;
        }

        public Object[] toArray() {
            Object[] array2;
            FastHashMap fastHashMap = FastHashMap.this;
            if (fastHashMap.fast) {
                return get(fastHashMap.map).toArray();
            }
            synchronized (fastHashMap.map) {
                array2 = get(FastHashMap.this.map).toArray();
            }
            return array2;
        }
    }

    public FastHashMap(int i10) {
        this.map = null;
        this.fast = false;
        this.map = new HashMap(i10);
    }

    public FastHashMap(int i10, float f10) {
        this.map = null;
        this.fast = false;
        this.map = new HashMap(i10, f10);
    }

    public FastHashMap(Map map2) {
        this.map = null;
        this.fast = false;
        this.map = new HashMap(map2);
    }
}
