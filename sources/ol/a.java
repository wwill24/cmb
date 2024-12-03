package ol;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<Object> f33471a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f33472b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f33473c;

    public a(List<? extends Object> list, Map<String, ? extends Object> map, Object obj) {
        this.f33471a = list;
        this.f33472b = map;
        this.f33473c = obj;
    }

    public final Map<String, Object> a() {
        return this.f33472b;
    }

    public final List<Object> b() {
        return this.f33471a;
    }

    public final Object c() {
        return this.f33473c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.b(this.f33471a, aVar.f33471a) && j.b(this.f33472b, aVar.f33472b) && j.b(this.f33473c, aVar.f33473c);
    }

    public int hashCode() {
        List<Object> list = this.f33471a;
        int i10 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Map<String, Object> map = this.f33472b;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        Object obj = this.f33473c;
        if (obj != null) {
            i10 = obj.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        List<Object> list = this.f33471a;
        Map<String, Object> map = this.f33472b;
        Object obj = this.f33473c;
        return "ArrayOperationInputData(operationData=" + list + ", mappingOperation=" + map + ", operationDefault=" + obj + ")";
    }
}
