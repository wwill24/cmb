package array;

import java.util.List;
import ml.b;

public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final e f7666a = new e();

    private e() {
    }

    public Object f(Object obj, Object obj2) {
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            return Integer.valueOf(list.size());
        }
        return null;
    }
}
