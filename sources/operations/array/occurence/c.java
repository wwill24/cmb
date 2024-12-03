package operations.array.occurence;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final List<Object> f33484a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f33485b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f33486c;

    public c(List<? extends Object> list, Map<String, ? extends Object> map, Object obj) {
        j.g(list, "operationData");
        j.g(map, "mappingOperation");
        this.f33484a = list;
        this.f33485b = map;
        this.f33486c = obj;
    }

    public final Map<String, Object> a() {
        return this.f33485b;
    }

    public final List<Object> b() {
        return this.f33484a;
    }

    public final Object c() {
        return this.f33486c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return j.b(this.f33484a, cVar.f33484a) && j.b(this.f33485b, cVar.f33485b) && j.b(this.f33486c, cVar.f33486c);
    }

    public int hashCode() {
        int hashCode = ((this.f33484a.hashCode() * 31) + this.f33485b.hashCode()) * 31;
        Object obj = this.f33486c;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        List<Object> list = this.f33484a;
        Map<String, Object> map = this.f33485b;
        Object obj = this.f33486c;
        return "OccurrenceCheckInputData(operationData=" + list + ", mappingOperation=" + map + ", operationDefault=" + obj + ")";
    }
}
