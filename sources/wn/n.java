package wn;

import java.util.List;
import ml.b;
import p004do.a;

public final class n implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final n f42501a = new n();

    private n() {
    }

    public Object f(Object obj, Object obj2) {
        List C0;
        List G;
        Object P = CollectionsKt___CollectionsKt.P(a.c(obj));
        String str = P instanceof String ? (String) P : null;
        if (str == null || (C0 = StringsKt__StringsKt.C0(str, new String[]{""}, false, 0, 6, (Object) null)) == null || (G = CollectionsKt___CollectionsKt.G(C0, 1)) == null) {
            return null;
        }
        return CollectionsKt___CollectionsKt.H(G, 1);
    }
}
