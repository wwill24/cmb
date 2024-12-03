package defpackage;

import java.util.List;
import ml.b;

/* renamed from: h  reason: default package */
public final class h implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final h f29743a = new h();

    private h() {
    }

    public Object f(Object obj, Object obj2) {
        if (obj instanceof String) {
            return t.f1((String) obj).toString();
        }
        if (obj instanceof List) {
            return CollectionsKt___CollectionsKt.k0((Iterable) obj);
        }
        return null;
    }
}
