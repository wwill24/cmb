package ij;

import androidx.annotation.NonNull;
import ij.i;
import io.noties.markwon.core.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class p implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<i> f30010a;

    /* renamed from: b  reason: collision with root package name */
    private final List<i> f30011b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<i> f30012c = new HashSet(3);

    p(@NonNull List<i> list) {
        this.f30010a = list;
        this.f30011b = new ArrayList(list.size());
    }

    private void a(@NonNull i iVar) {
        if (this.f30011b.contains(iVar)) {
            return;
        }
        if (!this.f30012c.contains(iVar)) {
            this.f30012c.add(iVar);
            iVar.g(this);
            this.f30012c.remove(iVar);
            if (this.f30011b.contains(iVar)) {
                return;
            }
            if (a.class.isAssignableFrom(iVar.getClass())) {
                this.f30011b.add(0, iVar);
            } else {
                this.f30011b.add(iVar);
            }
        } else {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.f30012c);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<i> b() {
        for (i a10 : this.f30010a) {
            a(a10);
        }
        return this.f30011b;
    }
}
