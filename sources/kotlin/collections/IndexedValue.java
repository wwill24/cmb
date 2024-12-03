package kotlin.collections;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class IndexedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f32019a;

    /* renamed from: b  reason: collision with root package name */
    private final T f32020b;

    public IndexedValue(int i10, T t10) {
        this.f32019a = i10;
        this.f32020b = t10;
    }

    public final int a() {
        return this.f32019a;
    }

    public final T b() {
        return this.f32020b;
    }

    public final int c() {
        return this.f32019a;
    }

    public final T d() {
        return this.f32020b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        return this.f32019a == indexedValue.f32019a && j.b(this.f32020b, indexedValue.f32020b);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.f32019a) * 31;
        T t10 = this.f32020b;
        return hashCode + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f32019a + ", value=" + this.f32020b + PropertyUtils.MAPPED_DELIM2;
    }
}
