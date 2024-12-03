package hj;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import ml.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, ml.b> f29745a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, a> f29746b;

    public b() {
        this((Map) null, (Map) null, 3, (DefaultConstructorMarker) null);
    }

    public b(Map<String, ? extends ml.b> map, Map<String, ? extends a> map2) {
        j.g(map, "standardOperations");
        j.g(map2, "functionalOperations");
        this.f29745a = map;
        this.f29746b = map2;
    }

    public final Map<String, a> a() {
        return this.f29746b;
    }

    public final Map<String, ml.b> b() {
        return this.f29745a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.b(this.f29745a, bVar.f29745a) && j.b(this.f29746b, bVar.f29746b);
    }

    public int hashCode() {
        return (this.f29745a.hashCode() * 31) + this.f29746b.hashCode();
    }

    public String toString() {
        Map<String, ml.b> map = this.f29745a;
        Map<String, a> map2 = this.f29746b;
        return "LogicOperations(standardOperations=" + map + ", functionalOperations=" + map2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Map map, Map map2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? h0.i() : map, (i10 & 2) != 0 ? h0.i() : map2);
    }
}
