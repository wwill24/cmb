package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class n1 implements Config {
    protected static final Comparator<Config.a<?>> B;
    private static final n1 C;
    protected final TreeMap<Config.a<?>, Map<Config.OptionPriority, Object>> A;

    static {
        m1 m1Var = new m1();
        B = m1Var;
        C = new n1(new TreeMap(m1Var));
    }

    n1(TreeMap<Config.a<?>, Map<Config.OptionPriority, Object>> treeMap) {
        this.A = treeMap;
    }

    @NonNull
    public static n1 L() {
        return C;
    }

    @NonNull
    public static n1 M(@NonNull Config config) {
        if (n1.class.equals(config.getClass())) {
            return (n1) config;
        }
        TreeMap treeMap = new TreeMap(B);
        for (Config.a next : config.e()) {
            Set<Config.OptionPriority> f10 = config.f(next);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority next2 : f10) {
                arrayMap.put(next2, config.d(next, next2));
            }
            treeMap.put(next, arrayMap);
        }
        return new n1(treeMap);
    }

    public <ValueT> ValueT a(@NonNull Config.a<ValueT> aVar) {
        Map map = this.A.get(aVar);
        if (map != null) {
            return map.get((Config.OptionPriority) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }

    public boolean b(@NonNull Config.a<?> aVar) {
        return this.A.containsKey(aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(@androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.NonNull androidx.camera.core.impl.Config.b r5) {
        /*
            r3 = this;
            java.lang.Class<java.lang.Void> r0 = java.lang.Void.class
            androidx.camera.core.impl.Config$a r0 = androidx.camera.core.impl.Config.a.a(r4, r0)
            java.util.TreeMap<androidx.camera.core.impl.Config$a<?>, java.util.Map<androidx.camera.core.impl.Config$OptionPriority, java.lang.Object>> r1 = r3.A
            java.util.SortedMap r0 = r1.tailMap(r0)
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0014:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            androidx.camera.core.impl.Config$a r2 = (androidx.camera.core.impl.Config.a) r2
            java.lang.String r2 = r2.c()
            boolean r2 = r2.startsWith(r4)
            if (r2 != 0) goto L_0x0031
            goto L_0x003d
        L_0x0031:
            java.lang.Object r1 = r1.getKey()
            androidx.camera.core.impl.Config$a r1 = (androidx.camera.core.impl.Config.a) r1
            boolean r1 = r5.a(r1)
            if (r1 != 0) goto L_0x0014
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.n1.c(java.lang.String, androidx.camera.core.impl.Config$b):void");
    }

    public <ValueT> ValueT d(@NonNull Config.a<ValueT> aVar, @NonNull Config.OptionPriority optionPriority) {
        Map map = this.A.get(aVar);
        if (map == null) {
            throw new IllegalArgumentException("Option does not exist: " + aVar);
        } else if (map.containsKey(optionPriority)) {
            return map.get(optionPriority);
        } else {
            throw new IllegalArgumentException("Option does not exist: " + aVar + " with priority=" + optionPriority);
        }
    }

    @NonNull
    public Set<Config.a<?>> e() {
        return Collections.unmodifiableSet(this.A.keySet());
    }

    @NonNull
    public Set<Config.OptionPriority> f(@NonNull Config.a<?> aVar) {
        Map map = this.A.get(aVar);
        if (map == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(map.keySet());
    }

    public <ValueT> ValueT g(@NonNull Config.a<ValueT> aVar, ValueT valuet) {
        try {
            return a(aVar);
        } catch (IllegalArgumentException unused) {
            return valuet;
        }
    }

    @NonNull
    public Config.OptionPriority h(@NonNull Config.a<?> aVar) {
        Map map = this.A.get(aVar);
        if (map != null) {
            return (Config.OptionPriority) Collections.min(map.keySet());
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }
}
