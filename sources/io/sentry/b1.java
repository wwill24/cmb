package io.sentry;

import io.sentry.util.j;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Object> f31140a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final int f31141b;

    b1(int i10) {
        this.f31141b = i10;
    }

    private List<Object> a(Collection<?> collection, h0 h0Var) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Object d10 : collection) {
            arrayList.add(d(d10, h0Var));
        }
        return arrayList;
    }

    private List<Object> b(Object[] objArr, h0 h0Var) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Object d10 : objArr) {
            arrayList.add(d(d10, h0Var));
        }
        return arrayList;
    }

    private Map<String, Object> c(Map<?, ?> map, h0 h0Var) throws Exception {
        HashMap hashMap = new HashMap();
        for (Object next : map.keySet()) {
            Object obj = map.get(next);
            if (obj != null) {
                hashMap.put(next.toString(), d(obj, h0Var));
            } else {
                hashMap.put(next.toString(), (Object) null);
            }
        }
        return hashMap;
    }

    public Object d(Object obj, h0 h0Var) throws Exception {
        Object obj2;
        Map<String, Object> map = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return obj.toString();
        }
        if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (obj instanceof Locale) {
            return obj.toString();
        }
        if (obj instanceof AtomicIntegerArray) {
            return j.a((AtomicIntegerArray) obj);
        }
        if (obj instanceof AtomicBoolean) {
            return Boolean.valueOf(((AtomicBoolean) obj).get());
        }
        if (obj instanceof URI) {
            return obj.toString();
        }
        if (obj instanceof InetAddress) {
            return obj.toString();
        }
        if (obj instanceof UUID) {
            return obj.toString();
        }
        if (obj instanceof Currency) {
            return obj.toString();
        }
        if (obj instanceof Calendar) {
            return j.c((Calendar) obj);
        }
        if (obj.getClass().isEnum()) {
            return obj.toString();
        }
        if (this.f31140a.contains(obj)) {
            h0Var.c(SentryLevel.INFO, "Cyclic reference detected. Calling toString() on object.", new Object[0]);
            return obj.toString();
        }
        this.f31140a.add(obj);
        if (this.f31140a.size() > this.f31141b) {
            this.f31140a.remove(obj);
            h0Var.c(SentryLevel.INFO, "Max depth exceeded. Calling toString() on object.", new Object[0]);
            return obj.toString();
        }
        try {
            if (obj.getClass().isArray()) {
                obj2 = b((Object[]) obj, h0Var);
            } else if (obj instanceof Collection) {
                obj2 = a((Collection) obj, h0Var);
            } else if (obj instanceof Map) {
                obj2 = c((Map) obj, h0Var);
            } else {
                Map<String, Object> e10 = e(obj, h0Var);
                if (e10.isEmpty()) {
                    obj2 = obj.toString();
                } else {
                    map = e10;
                    this.f31140a.remove(obj);
                    return map;
                }
            }
            map = obj2;
        } catch (Exception e11) {
            h0Var.b(SentryLevel.INFO, "Not serializing object due to throwing sub-path.", e11);
        } catch (Throwable th2) {
            this.f31140a.remove(obj);
            throw th2;
        }
        this.f31140a.remove(obj);
        return map;
    }

    public Map<String, Object> e(Object obj, h0 h0Var) throws Exception {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        HashMap hashMap = new HashMap();
        for (Field field : declaredFields) {
            if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                try {
                    field.setAccessible(true);
                    hashMap.put(name, d(field.get(obj), h0Var));
                    field.setAccessible(false);
                } catch (Exception unused) {
                    h0Var.c(SentryLevel.INFO, "Cannot access field " + name + ".", new Object[0]);
                }
            }
        }
        return hashMap;
    }
}
