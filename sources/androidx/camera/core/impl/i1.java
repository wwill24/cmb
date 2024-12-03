package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public final class i1 extends n1 implements h1 {
    @NonNull
    private static final Config.OptionPriority D = Config.OptionPriority.OPTIONAL;

    private i1(TreeMap<Config.a<?>, Map<Config.OptionPriority, Object>> treeMap) {
        super(treeMap);
    }

    @NonNull
    public static i1 O() {
        return new i1(new TreeMap(n1.B));
    }

    @NonNull
    public static i1 P(@NonNull Config config) {
        TreeMap treeMap = new TreeMap(n1.B);
        for (Config.a next : config.e()) {
            Set<Config.OptionPriority> f10 = config.f(next);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority next2 : f10) {
                arrayMap.put(next2, config.d(next, next2));
            }
            treeMap.put(next, arrayMap);
        }
        return new i1(treeMap);
    }

    public <ValueT> ValueT Q(@NonNull Config.a<ValueT> aVar) {
        return this.A.remove(aVar);
    }

    public <ValueT> void n(@NonNull Config.a<ValueT> aVar, @NonNull Config.OptionPriority optionPriority, ValueT valuet) {
        Map map = this.A.get(aVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.A.put(aVar, arrayMap);
            arrayMap.put(optionPriority, valuet);
            return;
        }
        Config.OptionPriority optionPriority2 = (Config.OptionPriority) Collections.min(map.keySet());
        if (Objects.equals(map.get(optionPriority2), valuet) || !Config.v(optionPriority2, optionPriority)) {
            map.put(optionPriority, valuet);
            return;
        }
        throw new IllegalArgumentException("Option values conflicts: " + aVar.c() + ", existing value (" + optionPriority2 + ")=" + map.get(optionPriority2) + ", conflicting (" + optionPriority + ")=" + valuet);
    }

    public <ValueT> void p(@NonNull Config.a<ValueT> aVar, ValueT valuet) {
        n(aVar, D, valuet);
    }
}
