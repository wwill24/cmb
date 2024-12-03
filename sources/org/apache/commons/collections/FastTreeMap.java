package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class FastTreeMap extends TreeMap {
    protected boolean fast;
    protected TreeMap map;

    private class EntrySet extends CollectionView implements Set {
        private final /* synthetic */ FastTreeMap this$0;

        private EntrySet(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
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
        private final /* synthetic */ FastTreeMap this$0;

        private KeySet(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
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
        private final /* synthetic */ FastTreeMap this$0;

        private Values(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
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

    public FastTreeMap() {
        this.map = null;
        this.fast = false;
        this.map = new TreeMap();
    }

    public void clear() {
        if (this.fast) {
            synchronized (this) {
                this.map = new TreeMap();
            }
            return;
        }
        synchronized (this.map) {
            this.map.clear();
        }
    }

    public Object clone() {
        FastTreeMap fastTreeMap;
        FastTreeMap fastTreeMap2;
        if (this.fast) {
            fastTreeMap = new FastTreeMap((SortedMap) this.map);
        } else {
            synchronized (this.map) {
                fastTreeMap2 = new FastTreeMap((SortedMap) this.map);
            }
            fastTreeMap = fastTreeMap2;
        }
        fastTreeMap.setFast(getFast());
        return fastTreeMap;
    }

    public Comparator comparator() {
        Comparator comparator;
        if (this.fast) {
            return this.map.comparator();
        }
        synchronized (this.map) {
            comparator = this.map.comparator();
        }
        return comparator;
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
            java.util.TreeMap r3 = r6.map
            int r3 = r3.size()
            if (r1 == r3) goto L_0x001d
            return r2
        L_0x001d:
            java.util.TreeMap r1 = r6.map
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
            java.util.TreeMap r1 = r6.map
            monitor-enter(r1)
            int r3 = r7.size()     // Catch:{ all -> 0x00a3 }
            java.util.TreeMap r4 = r6.map     // Catch:{ all -> 0x00a3 }
            int r4 = r4.size()     // Catch:{ all -> 0x00a3 }
            if (r3 == r4) goto L_0x0067
            monitor-exit(r1)     // Catch:{ all -> 0x00a3 }
            return r2
        L_0x0067:
            java.util.TreeMap r3 = r6.map     // Catch:{ all -> 0x00a3 }
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
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.FastTreeMap.equals(java.lang.Object):boolean");
    }

    public Object firstKey() {
        Object firstKey;
        if (this.fast) {
            return this.map.firstKey();
        }
        synchronized (this.map) {
            firstKey = this.map.firstKey();
        }
        return firstKey;
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

    public SortedMap headMap(Object obj) {
        SortedMap headMap;
        if (this.fast) {
            return this.map.headMap(obj);
        }
        synchronized (this.map) {
            headMap = this.map.headMap(obj);
        }
        return headMap;
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

    public Object lastKey() {
        Object lastKey;
        if (this.fast) {
            return this.map.lastKey();
        }
        synchronized (this.map) {
            lastKey = this.map.lastKey();
        }
        return lastKey;
    }

    public Object put(Object obj, Object obj2) {
        Object put;
        Object put2;
        if (this.fast) {
            synchronized (this) {
                TreeMap treeMap = (TreeMap) this.map.clone();
                put2 = treeMap.put(obj, obj2);
                this.map = treeMap;
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
                TreeMap treeMap = (TreeMap) this.map.clone();
                treeMap.putAll(map2);
                this.map = treeMap;
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
                TreeMap treeMap = (TreeMap) this.map.clone();
                remove2 = treeMap.remove(obj);
                this.map = treeMap;
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

    public SortedMap subMap(Object obj, Object obj2) {
        SortedMap subMap;
        if (this.fast) {
            return this.map.subMap(obj, obj2);
        }
        synchronized (this.map) {
            subMap = this.map.subMap(obj, obj2);
        }
        return subMap;
    }

    public SortedMap tailMap(Object obj) {
        SortedMap tailMap;
        if (this.fast) {
            return this.map.tailMap(obj);
        }
        synchronized (this.map) {
            tailMap = this.map.tailMap(obj);
        }
        return tailMap;
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
                TreeMap treeMap = FastTreeMap.this.map;
                this.expected = treeMap;
                this.iterator = treeMap.entrySet().iterator();
            }

            public boolean hasNext() {
                if (this.expected == FastTreeMap.this.map) {
                    return this.iterator.hasNext();
                }
                throw new ConcurrentModificationException();
            }

            public Object next() {
                if (this.expected == FastTreeMap.this.map) {
                    Map.Entry entry = (Map.Entry) this.iterator.next();
                    this.lastReturned = entry;
                    return CollectionView.this.iteratorNext(entry);
                }
                throw new ConcurrentModificationException();
            }

            public void remove() {
                if (this.lastReturned == null) {
                    throw new IllegalStateException();
                } else if (FastTreeMap.this.fast) {
                    synchronized (FastTreeMap.this) {
                        if (this.expected == FastTreeMap.this.map) {
                            FastTreeMap.this.remove(this.lastReturned.getKey());
                            this.lastReturned = null;
                            this.expected = FastTreeMap.this.map;
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
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                synchronized (fastTreeMap) {
                    FastTreeMap.this.map = new TreeMap();
                }
                return;
            }
            synchronized (fastTreeMap.map) {
                get(FastTreeMap.this.map).clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).contains(obj);
            }
            synchronized (fastTreeMap.map) {
                contains = get(FastTreeMap.this.map).contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection collection) {
            boolean containsAll;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).containsAll(collection);
            }
            synchronized (fastTreeMap.map) {
                containsAll = get(FastTreeMap.this.map).containsAll(collection);
            }
            return containsAll;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).equals(obj);
            }
            synchronized (fastTreeMap.map) {
                equals = get(FastTreeMap.this.map).equals(obj);
            }
            return equals;
        }

        /* access modifiers changed from: protected */
        public abstract Collection get(Map map);

        public int hashCode() {
            int hashCode;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).hashCode();
            }
            synchronized (fastTreeMap.map) {
                hashCode = get(FastTreeMap.this.map).hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).isEmpty();
            }
            synchronized (fastTreeMap.map) {
                isEmpty = get(FastTreeMap.this.map).isEmpty();
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
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                synchronized (fastTreeMap) {
                    TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                    remove2 = get(treeMap).remove(obj);
                    FastTreeMap.this.map = treeMap;
                }
                return remove2;
            }
            synchronized (fastTreeMap.map) {
                remove = get(FastTreeMap.this.map).remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection collection) {
            boolean removeAll;
            boolean removeAll2;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                synchronized (fastTreeMap) {
                    TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                    removeAll2 = get(treeMap).removeAll(collection);
                    FastTreeMap.this.map = treeMap;
                }
                return removeAll2;
            }
            synchronized (fastTreeMap.map) {
                removeAll = get(FastTreeMap.this.map).removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection collection) {
            boolean retainAll;
            boolean retainAll2;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                synchronized (fastTreeMap) {
                    TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                    retainAll2 = get(treeMap).retainAll(collection);
                    FastTreeMap.this.map = treeMap;
                }
                return retainAll2;
            }
            synchronized (fastTreeMap.map) {
                retainAll = get(FastTreeMap.this.map).retainAll(collection);
            }
            return retainAll;
        }

        public int size() {
            int size;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).size();
            }
            synchronized (fastTreeMap.map) {
                size = get(FastTreeMap.this.map).size();
            }
            return size;
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array2;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).toArray(objArr);
            }
            synchronized (fastTreeMap.map) {
                array2 = get(FastTreeMap.this.map).toArray(objArr);
            }
            return array2;
        }

        public Object[] toArray() {
            Object[] array2;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).toArray();
            }
            synchronized (fastTreeMap.map) {
                array2 = get(FastTreeMap.this.map).toArray();
            }
            return array2;
        }
    }

    public FastTreeMap(Comparator comparator) {
        this.map = null;
        this.fast = false;
        this.map = new TreeMap(comparator);
    }

    public FastTreeMap(Map map2) {
        this.map = null;
        this.fast = false;
        this.map = new TreeMap(map2);
    }

    public FastTreeMap(SortedMap sortedMap) {
        this.map = null;
        this.fast = false;
        this.map = new TreeMap(sortedMap);
    }
}
