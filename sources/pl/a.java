package pl;

import java.util.ArrayList;
import java.util.List;
import ml.b;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33765a = new a();

    private a() {
    }

    private final boolean b(Object obj) {
        if (obj != null) {
            if (!(obj instanceof String)) {
                return false;
            }
            if (!(((CharSequence) obj).length() == 0)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public List<Object> f(Object obj, Object obj2) {
        List<Object> c10 = p004do.a.c(obj);
        ArrayList arrayList = new ArrayList();
        for (T next : c10) {
            if (!f33765a.b(c.f33767a.f(next, obj2))) {
                next = null;
            }
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
