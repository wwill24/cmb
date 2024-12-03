package r;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.r2;
import androidx.camera.core.impl.r1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import q.h;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private final h f17217a;

    @FunctionalInterface
    public interface a {
        void a(@NonNull r2 r2Var);
    }

    public g(@NonNull r1 r1Var) {
        this.f17217a = (h) r1Var.b(h.class);
    }

    private void a(@NonNull Set<r2> set) {
        for (r2 next : set) {
            next.c().p(next);
        }
    }

    private void b(@NonNull Set<r2> set) {
        for (r2 next : set) {
            next.c().q(next);
        }
    }

    public void c(@NonNull r2 r2Var, @NonNull List<r2> list, @NonNull List<r2> list2, @NonNull a aVar) {
        r2 next;
        r2 next2;
        if (d()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<r2> it = list.iterator();
            while (it.hasNext() && (next2 = it.next()) != r2Var) {
                linkedHashSet.add(next2);
            }
            b(linkedHashSet);
        }
        aVar.a(r2Var);
        if (d()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<r2> it2 = list2.iterator();
            while (it2.hasNext() && (next = it2.next()) != r2Var) {
                linkedHashSet2.add(next);
            }
            a(linkedHashSet2);
        }
    }

    public boolean d() {
        return this.f17217a != null;
    }
}
