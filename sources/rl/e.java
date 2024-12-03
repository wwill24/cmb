package rl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ml.b;
import p004do.a;
import tl.d;

public final class e implements b, d {

    /* renamed from: a  reason: collision with root package name */
    public static final e f33806a = new e();

    private e() {
    }

    public boolean a(Object obj) {
        return d.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        boolean z10;
        List<Object> c10 = a.c(obj);
        boolean z11 = false;
        if (!(c10 instanceof Collection) || !c10.isEmpty()) {
            Iterator<T> it = c10.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!(it.next() instanceof Boolean)) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z10 = true;
        T t10 = null;
        if (z10) {
            Iterator<T> it2 = c10.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (f33806a.a(next)) {
                    t10 = next;
                    break;
                }
            }
            if (t10 != null) {
                z11 = true;
            }
            return Boolean.valueOf(z11);
        }
        Iterator<T> it3 = c10.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            T next2 = it3.next();
            if (f33806a.a(next2)) {
                t10 = next2;
                break;
            }
        }
        if (t10 == null) {
            return CollectionsKt___CollectionsKt.Y(c10);
        }
        return t10;
    }
}
