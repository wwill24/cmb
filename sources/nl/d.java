package nl;

import java.util.List;
import ml.b;
import p004do.a;
import p004do.c;

public final class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final d f32809a = new d();

    private d() {
    }

    /* renamed from: a */
    public Boolean f(Object obj, Object obj2) {
        Object P = CollectionsKt___CollectionsKt.P(a.c(obj));
        Object b10 = c.b(a.c(obj));
        if (b10 instanceof String) {
            return Boolean.valueOf(StringsKt__StringsKt.O((CharSequence) b10, String.valueOf(P), false, 2, (Object) null));
        }
        if (b10 instanceof List) {
            return Boolean.valueOf(((List) b10).contains(P));
        }
        return Boolean.FALSE;
    }
}
