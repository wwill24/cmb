package array;

import java.util.List;
import ml.b;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7657a = new a();

    private a() {
    }

    public Object f(Object obj, Object obj2) {
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            return CollectionsKt___CollectionsKt.F(list);
        }
        return null;
    }
}
