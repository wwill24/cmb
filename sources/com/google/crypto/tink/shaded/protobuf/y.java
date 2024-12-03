package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

public class y extends z {

    /* renamed from: f  reason: collision with root package name */
    private final l0 f20926f;

    static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Map.Entry<K, y> f20927a;

        public y a() {
            return this.f20927a.getValue();
        }

        public K getKey() {
            return this.f20927a.getKey();
        }

        public Object getValue() {
            y value = this.f20927a.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        public Object setValue(Object obj) {
            if (obj instanceof l0) {
                return this.f20927a.getValue().d((l0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, y> entry) {
            this.f20927a = entry;
        }
    }

    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f20928a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f20928a = it;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f20928a.next();
            if (next.getValue() instanceof y) {
                return new b(next);
            }
            return next;
        }

        public boolean hasNext() {
            return this.f20928a.hasNext();
        }

        public void remove() {
            this.f20928a.remove();
        }
    }

    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public l0 f() {
        return c(this.f20926f);
    }

    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
