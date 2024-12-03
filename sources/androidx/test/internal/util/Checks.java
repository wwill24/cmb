package androidx.test.internal.util;

import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.ThreadChecker;
import java.util.List;

public final class Checks {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadChecker f7053a;

    static {
        Class<ThreadChecker> cls = ThreadChecker.class;
        List<ThreadChecker> a10 = ServiceLoaderWrapper.a(cls);
        if (a10.isEmpty()) {
            f7053a = new ThreadChecker() {
            };
        } else if (a10.size() == 1) {
            f7053a = a10.get(0);
        } else {
            throw new IllegalStateException(String.format("Found more than one %s implementations.", new Object[]{cls.getName()}));
        }
    }

    public static <T> T a(T t10) {
        t10.getClass();
        return t10;
    }
}
