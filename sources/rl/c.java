package rl;

import java.util.List;
import ml.b;
import p004do.a;
import tl.d;

public final class c implements b, d {

    /* renamed from: a  reason: collision with root package name */
    public static final c f33804a = new c();

    private c() {
    }

    private final Object a(List<? extends Object> list) {
        int size = list.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return CollectionsKt___CollectionsKt.P(list);
        }
        if (size != 2) {
            if (size != 3) {
                if (b(CollectionsKt___CollectionsKt.P(list))) {
                    return p004do.c.b(list);
                }
                return a(list.subList(2, list.size()));
            } else if (b(CollectionsKt___CollectionsKt.P(list))) {
                return p004do.c.b(list);
            } else {
                return p004do.c.c(list);
            }
        } else if (b(CollectionsKt___CollectionsKt.P(list))) {
            return p004do.c.b(list);
        } else {
            return null;
        }
    }

    public boolean b(Object obj) {
        return d.a.a(this, obj);
    }

    public Object f(Object obj, Object obj2) {
        return a(a.c(obj));
    }
}
