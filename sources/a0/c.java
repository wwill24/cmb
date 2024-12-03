package a0;

import androidx.annotation.NonNull;
import java.util.List;

final class c extends w {

    /* renamed from: a  reason: collision with root package name */
    private final List<u> f20a;

    c(List<u> list) {
        if (list != null) {
            this.f20a = list;
            return;
        }
        throw new NullPointerException("Null surfaces");
    }

    @NonNull
    public List<u> b() {
        return this.f20a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            return this.f20a.equals(((w) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f20a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "SurfaceEdge{surfaces=" + this.f20a + "}";
    }
}
