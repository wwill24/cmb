package ra;

import java.util.Objects;
import qj.q;

public abstract class a<Plugin, DynamicDependency> {
    public abstract Plugin a(DynamicDependency dynamicdependency);

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    public abstract q<Boolean> c();

    /* access modifiers changed from: protected */
    public abstract Boolean d();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(b(), ((a) obj).b());
    }

    public int hashCode() {
        return Objects.hash(new Object[]{b()});
    }
}
