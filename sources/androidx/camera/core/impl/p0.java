package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2575a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Object, t> f2576b = new HashMap();

    @NonNull
    public static t a(@NonNull Object obj) {
        t tVar;
        synchronized (f2575a) {
            tVar = f2576b.get(obj);
        }
        if (tVar == null) {
            return t.f2583a;
        }
        return tVar;
    }
}
