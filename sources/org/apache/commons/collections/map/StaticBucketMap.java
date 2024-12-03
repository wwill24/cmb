package org.apache.commons.collections.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.KeyValue;

public final class StaticBucketMap implements Map {
    private static final int DEFAULT_BUCKETS = 255;
    /* access modifiers changed from: private */
    public Node[] buckets;
    /* access modifiers changed from: private */
    public Lock[] locks;

    private class EntryIterator implements Iterator {
        private int bucket;
        private ArrayList current;
        private Map.Entry last;

        private EntryIterator() {
            this.current = new ArrayList();
        }

        public boolean hasNext() {
            if (this.current.size() > 0) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    for (Node node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                        this.current.add(node);
                    }
                    this.bucket++;
                    if (this.current.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        public Object next() {
            return nextEntry();
        }

        /* access modifiers changed from: protected */
        public Map.Entry nextEntry() {
            if (hasNext()) {
                ArrayList arrayList = this.current;
                Map.Entry entry = (Map.Entry) arrayList.remove(arrayList.size() - 1);
                this.last = entry;
                return entry;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Map.Entry entry = this.last;
            if (entry != null) {
                StaticBucketMap.this.remove(entry.getKey());
                this.last = null;
                return;
            }
            throw new IllegalStateException();
        }
    }

    private class EntrySet extends AbstractSet {
        private EntrySet() {
        }

        public void clear() {
            StaticBucketMap.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int access$800 = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[access$800]) {
                for (Node node = StaticBucketMap.this.buckets[access$800]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        return true;
                    }
                }
                return false;
            }
        }

        public Iterator iterator() {
            return new EntryIterator();
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int access$800 = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[access$800]) {
                for (Node node = StaticBucketMap.this.buckets[access$800]; node != null; node = node.next) {
                    if (node.equals(entry)) {
                        StaticBucketMap.this.remove(node.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    private class KeyIterator extends EntryIterator {
        private final /* synthetic */ StaticBucketMap this$0;

        private KeyIterator(StaticBucketMap staticBucketMap) {
            super();
            this.this$0 = staticBucketMap;
        }

        public Object next() {
            return nextEntry().getKey();
        }
    }

    private class KeySet extends AbstractSet {
        private KeySet() {
        }

        public void clear() {
            StaticBucketMap.this.clear();
        }

        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        public Iterator iterator() {
            return new KeyIterator();
        }

        public boolean remove(Object obj) {
            int access$800 = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[access$800]) {
                Node node = StaticBucketMap.this.buckets[access$800];
                while (node != null) {
                    Object key = node.getKey();
                    if (key != obj) {
                        if (key == null || !key.equals(obj)) {
                            node = node.next;
                        }
                    }
                    StaticBucketMap.this.remove(key);
                    return true;
                }
                return false;
            }
        }

        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    private static final class Lock {
        public int size;

        private Lock() {
        }
    }

    private static final class Node implements Map.Entry, KeyValue {
        protected Object key;
        protected Node next;
        protected Object value;

        private Node() {
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.key;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.value;
                Object value2 = entry.getValue();
                if (obj3 == null) {
                    if (value2 == null) {
                        return true;
                    }
                } else if (obj3.equals(value2)) {
                    return true;
                }
            }
            return false;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public int hashCode() {
            Object obj = this.key;
            int i10 = 0;
            int hashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.value;
            if (obj2 != null) {
                i10 = obj2.hashCode();
            }
            return hashCode ^ i10;
        }

        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }
    }

    private class ValueIterator extends EntryIterator {
        private final /* synthetic */ StaticBucketMap this$0;

        private ValueIterator(StaticBucketMap staticBucketMap) {
            super();
            this.this$0 = staticBucketMap;
        }

        public Object next() {
            return nextEntry().getValue();
        }
    }

    private class Values extends AbstractCollection {
        private Values() {
        }

        public void clear() {
            StaticBucketMap.this.clear();
        }

        public Iterator iterator() {
            return new ValueIterator();
        }

        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    public StaticBucketMap() {
        this(255);
    }

    /* access modifiers changed from: private */
    public final int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int hashCode = obj.hashCode();
        int i10 = hashCode + (~(hashCode << 15));
        int i11 = i10 ^ (i10 >>> 10);
        int i12 = i11 + (i11 << 3);
        int i13 = i12 ^ (i12 >>> 6);
        int i14 = i13 + (~(i13 << 11));
        int length = (i14 ^ (i14 >>> 16)) % this.buckets.length;
        if (length < 0) {
            return length * -1;
        }
        return length;
    }

    public void atomic(Runnable runnable) {
        runnable.getClass();
        atomic(runnable, 0);
    }

    public void clear() {
        for (int i10 = 0; i10 < this.buckets.length; i10++) {
            Lock lock = this.locks[i10];
            synchronized (lock) {
                this.buckets[i10] = null;
                lock.size = 0;
            }
        }
    }

    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node node = this.buckets[hash];
            while (node != null) {
                Object obj2 = node.key;
                if (obj2 != obj) {
                    if (obj2 == null || !obj2.equals(obj)) {
                        node = node.next;
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsValue(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            org.apache.commons.collections.map.StaticBucketMap$Node[] r2 = r5.buckets
            int r2 = r2.length
            if (r1 >= r2) goto L_0x002c
            org.apache.commons.collections.map.StaticBucketMap$Lock[] r2 = r5.locks
            r2 = r2[r1]
            monitor-enter(r2)
            org.apache.commons.collections.map.StaticBucketMap$Node[] r3 = r5.buckets     // Catch:{ all -> 0x0029 }
            r3 = r3[r1]     // Catch:{ all -> 0x0029 }
        L_0x0010:
            if (r3 == 0) goto L_0x0025
            java.lang.Object r4 = r3.value     // Catch:{ all -> 0x0029 }
            if (r4 == r6) goto L_0x0022
            if (r4 == 0) goto L_0x001f
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x0029 }
            if (r4 == 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            org.apache.commons.collections.map.StaticBucketMap$Node r3 = r3.next     // Catch:{ all -> 0x0029 }
            goto L_0x0010
        L_0x0022:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            r6 = 1
            return r6
        L_0x0025:
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0029:
            r6 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0029 }
            throw r6
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.map.StaticBucketMap.containsValue(java.lang.Object):boolean");
    }

    public Set entrySet() {
        return new EntrySet();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public Object get(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node node = this.buckets[hash];
            while (node != null) {
                Object obj2 = node.key;
                if (obj2 != obj) {
                    if (obj2 == null || !obj2.equals(obj)) {
                        node = node.next;
                    }
                }
                Object obj3 = node.value;
                return obj3;
            }
            return null;
        }
    }

    public int hashCode() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.buckets.length; i11++) {
            synchronized (this.locks[i11]) {
                for (Node node = this.buckets[i11]; node != null; node = node.next) {
                    i10 += node.hashCode();
                }
            }
        }
        return i10;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set keySet() {
        return new KeySet();
    }

    public Object put(Object obj, Object obj2) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node node = this.buckets[hash];
            if (node == null) {
                Node node2 = new Node();
                node2.key = obj;
                node2.value = obj2;
                this.buckets[hash] = node2;
                this.locks[hash].size++;
                return null;
            }
            Node node3 = node;
            while (node != null) {
                Object obj3 = node.key;
                if (obj3 != obj) {
                    if (obj3 == null || !obj3.equals(obj)) {
                        node3 = node;
                        node = node.next;
                    }
                }
                Object obj4 = node.value;
                node.value = obj2;
                return obj4;
            }
            Node node4 = new Node();
            node4.key = obj;
            node4.value = obj2;
            node3.next = node4;
            this.locks[hash].size++;
            return null;
        }
    }

    public void putAll(Map map) {
        for (Object next : map.keySet()) {
            put(next, map.get(next));
        }
    }

    public Object remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            Node node = this.buckets[hash];
            Node node2 = null;
            while (node != null) {
                Object obj2 = node.key;
                if (obj2 != obj) {
                    if (obj2 == null || !obj2.equals(obj)) {
                        node2 = node;
                        node = node.next;
                    }
                }
                if (node2 == null) {
                    this.buckets[hash] = node.next;
                } else {
                    node2.next = node.next;
                }
                Lock lock = this.locks[hash];
                lock.size--;
                Object obj3 = node.value;
                return obj3;
            }
            return null;
        }
    }

    public int size() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.buckets.length; i11++) {
            synchronized (this.locks[i11]) {
                i10 += this.locks[i11].size;
            }
        }
        return i10;
    }

    public Collection values() {
        return new Values();
    }

    public StaticBucketMap(int i10) {
        int max = Math.max(17, i10);
        max = max % 2 == 0 ? max - 1 : max;
        this.buckets = new Node[max];
        this.locks = new Lock[max];
        for (int i11 = 0; i11 < max; i11++) {
            this.locks[i11] = new Lock();
        }
    }

    private void atomic(Runnable runnable, int i10) {
        if (i10 >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i10]) {
            atomic(runnable, i10 + 1);
        }
    }
}
