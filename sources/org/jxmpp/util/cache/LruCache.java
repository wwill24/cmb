package org.jxmpp.util.cache;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import mm.a;

public class LruCache<K, V> extends LinkedHashMap<K, V> implements a<K, V> {
    private static final long serialVersionUID = -4980809402073634607L;
    private final AtomicLong cacheHits;
    private final AtomicLong cacheMisses;
    private int maxCacheSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LruCache(int i10) {
        super(i10 < 50 ? i10 : 50, 0.75f, true);
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        if (i10 != 0) {
            this.maxCacheSize = i10;
            return;
        }
        throw new IllegalArgumentException("Max cache size cannot be 0.");
    }

    public final V a(K k10) {
        return get(k10);
    }

    public final void b(int i10) {
        this.maxCacheSize = i10;
    }

    public final void clear() {
        synchronized (this) {
            super.clear();
        }
        this.cacheHits.set(0);
        this.cacheMisses.set(0);
    }

    public final synchronized boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    public final synchronized boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    public final synchronized Set<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    public final V get(Object obj) {
        V v10;
        synchronized (this) {
            v10 = super.get(obj);
        }
        if (v10 == null) {
            this.cacheMisses.incrementAndGet();
            return null;
        }
        this.cacheHits.incrementAndGet();
        return v10;
    }

    public final synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    public final synchronized Set<K> keySet() {
        return super.keySet();
    }

    public final synchronized V put(K k10, V v10) {
        return super.put(k10, v10);
    }

    public final synchronized void putAll(Map<? extends K, ? extends V> map) {
        super.putAll(map);
    }

    public final synchronized V remove(Object obj) {
        return super.remove(obj);
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.maxCacheSize;
    }

    public final synchronized int size() {
        return super.size();
    }

    public final synchronized Collection<V> values() {
        return super.values();
    }
}
