package rl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ml.b;
import tl.d;

public final class a implements b, d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33802a = new a();

    private a() {
    }

    public boolean a(Object obj) {
        return d.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        boolean z10;
        T t10;
        List<Object> c10 = p004do.a.c(obj);
        boolean z11 = c10 instanceof Collection;
        boolean z12 = false;
        if (!z11 || !c10.isEmpty()) {
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
        if (z10) {
            if (!z11 || !c10.isEmpty()) {
                Iterator<T> it2 = c10.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!f33802a.a(it2.next())) {
                        break;
                    }
                }
            }
            z12 = true;
            return Boolean.valueOf(z12);
        }
        Iterator<T> it3 = c10.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t10 = null;
                break;
            }
            T next = it3.next();
            if (!f33802a.a(next)) {
                t10 = next;
                break;
            }
        }
        if (t10 == null) {
            return CollectionsKt___CollectionsKt.Y(c10);
        }
        return t10;
    }
}
