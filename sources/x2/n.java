package x2;

import d3.a;
import java.util.Arrays;
import java.util.List;

abstract class n<V, O> implements m<V, O> {

    /* renamed from: a  reason: collision with root package name */
    final List<a<V>> f18525a;

    n(List<a<V>> list) {
        this.f18525a = list;
    }

    public List<a<V>> b() {
        return this.f18525a;
    }

    public boolean isStatic() {
        return this.f18525a.isEmpty() || (this.f18525a.size() == 1 && this.f18525a.get(0).i());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f18525a.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f18525a.toArray()));
        }
        return sb2.toString();
    }
}
