package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

public class x extends y {

    /* renamed from: f  reason: collision with root package name */
    private final k0 f5391f;

    static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Map.Entry<K, x> f5392a;

        public x a() {
            return this.f5392a.getValue();
        }

        public K getKey() {
            return this.f5392a.getKey();
        }

        public Object getValue() {
            x value = this.f5392a.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        public Object setValue(Object obj) {
            if (obj instanceof k0) {
                return this.f5392a.getValue().d((k0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry<K, x> entry) {
            this.f5392a = entry;
        }
    }

    static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f5393a;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f5393a = it;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f5393a.next();
            if (next.getValue() instanceof x) {
                return new b(next);
            }
            return next;
        }

        public boolean hasNext() {
            return this.f5393a.hasNext();
        }

        public void remove() {
            this.f5393a.remove();
        }
    }

    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public k0 f() {
        return c(this.f5391f);
    }

    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
