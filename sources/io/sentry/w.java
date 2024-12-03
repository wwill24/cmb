package io.sentry;

import com.leanplum.internal.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.validator.Var;
import org.jetbrains.annotations.ApiStatus;

public final class w {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Class<?>> f31772e;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f31773a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f31774b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private b f31775c = null;

    /* renamed from: d  reason: collision with root package name */
    private b f31776d = null;

    static {
        HashMap hashMap = new HashMap();
        f31772e = hashMap;
        hashMap.put("boolean", Boolean.class);
        hashMap.put("char", Character.class);
        hashMap.put("byte", Byte.class);
        hashMap.put("short", Short.class);
        hashMap.put(Var.JSTYPE_INT, Integer.class);
        hashMap.put("long", Long.class);
        hashMap.put(Constants.Kinds.FLOAT, Float.class);
        hashMap.put("double", Double.class);
    }

    private boolean h(Object obj, Class<?> cls) {
        Class cls2 = f31772e.get(cls.getCanonicalName());
        if (obj == null || !cls.isPrimitive() || cls2 == null || !cls2.isInstance(obj)) {
            return false;
        }
        return true;
    }

    public void a(List<b> list) {
        if (list != null) {
            this.f31774b.addAll(list);
        }
    }

    @ApiStatus.Internal
    public synchronized void b() {
        Iterator<Map.Entry<String, Object>> it = this.f31773a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (next.getKey() == null || !((String) next.getKey()).startsWith("sentry:")) {
                it.remove();
            }
        }
    }

    public synchronized Object c(String str) {
        return this.f31773a.get(str);
    }

    public synchronized <T> T d(String str, Class<T> cls) {
        T t10 = this.f31773a.get(str);
        if (cls.isInstance(t10)) {
            return t10;
        }
        if (h(t10, cls)) {
            return t10;
        }
        return null;
    }

    public List<b> e() {
        return new ArrayList(this.f31774b);
    }

    public b f() {
        return this.f31775c;
    }

    public b g() {
        return this.f31776d;
    }

    public synchronized void i(String str, Object obj) {
        this.f31773a.put(str, obj);
    }

    public void j(b bVar) {
        this.f31775c = bVar;
    }

    public void k(b bVar) {
        this.f31776d = bVar;
    }
}
