package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMap<K, V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MAP_SIZE = 6;
    private static final int ENTRY_LIST_SIZE = 3;
    private final Map<K, List<V>> map;

    private static final class SimpleMapEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V v10) {
            V v11 = this.value;
            this.value = v10;
            return v11;
        }

        private SimpleMapEntry(K k10, V v10) {
            this.key = k10;
            this.value = v10;
        }
    }

    public MultiMap() {
        this(6);
    }

    private boolean putInternal(K k10, Consumer<List<V>> consumer) {
        boolean z10;
        Object obj = this.map.get(k10);
        if (obj == null) {
            obj = new ArrayList(3);
            this.map.put(k10, obj);
            z10 = false;
        } else {
            z10 = true;
        }
        consumer.accept(obj);
        return z10;
    }

    public MultiMap<K, V> asUnmodifiableMultiMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.map.size());
        for (Map.Entry next : this.map.entrySet()) {
            linkedHashMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
        }
        return new MultiMap<>(Collections.unmodifiableMap(linkedHashMap));
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(K k10) {
        return this.map.containsKey(k10);
    }

    public boolean containsValue(V v10) {
        for (List<V> contains : this.map.values()) {
            if (contains.contains(v10)) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (Map.Entry next : this.map.entrySet()) {
            Object key = next.getKey();
            for (Object simpleMapEntry : (List) next.getValue()) {
                linkedHashSet.add(new SimpleMapEntry(key, simpleMapEntry));
            }
        }
        return linkedHashSet;
    }

    public List<V> getAll(K k10) {
        List<V> list = this.map.get(k10);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public V getFirst(K k10) {
        List all = getAll(k10);
        if (all.isEmpty()) {
            return null;
        }
        return all.iterator().next();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }

    public boolean put(K k10, V v10) {
        return putInternal(k10, new i(v10));
    }

    public void putAll(Map<? extends K, ? extends V> map2) {
        for (Map.Entry next : map2.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean putFirst(K k10, V v10) {
        return putInternal(k10, new j(v10));
    }

    public V remove(K k10) {
        List remove = this.map.remove(k10);
        if (remove == null) {
            return null;
        }
        return remove.iterator().next();
    }

    public boolean removeOne(K k10, V v10) {
        List list = this.map.get(k10);
        if (list == null) {
            return false;
        }
        boolean remove = list.remove(v10);
        if (list.isEmpty()) {
            this.map.remove(k10);
        }
        return remove;
    }

    public int size() {
        int i10 = 0;
        for (List<V> size : this.map.values()) {
            i10 += size.size();
        }
        return i10;
    }

    public List<V> values() {
        ArrayList arrayList = new ArrayList(size());
        for (List<V> addAll : this.map.values()) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }

    public MultiMap(int i10) {
        this(new LinkedHashMap(i10));
    }

    public MultiMap<K, V> clone() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.map.size());
        for (Map.Entry next : this.map.entrySet()) {
            linkedHashMap.put(next.getKey(), CollectionUtil.newListWith((Collection) next.getValue()));
        }
        return new MultiMap<>(linkedHashMap);
    }

    private MultiMap(Map<K, List<V>> map2) {
        this.map = map2;
    }

    public List<V> remove(K k10, int i10) {
        List list = this.map.get(k10);
        if (list == null) {
            return Collections.emptyList();
        }
        if (list.size() <= i10) {
            i10 = list.size();
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(list.get(0));
        }
        if (list.isEmpty()) {
            this.map.remove(k10);
        }
        return arrayList;
    }
}
