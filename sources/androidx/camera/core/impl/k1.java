package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import java.util.Map;

public class k1 extends a2 {
    private k1(Map<String, Object> map) {
        super(map);
    }

    @NonNull
    public static k1 f() {
        return new k1(new ArrayMap());
    }

    @NonNull
    public static k1 g(@NonNull a2 a2Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (String next : a2Var.d()) {
            arrayMap.put(next, a2Var.c(next));
        }
        return new k1(arrayMap);
    }

    public void e(@NonNull a2 a2Var) {
        Map<String, Object> map;
        Map<String, Object> map2 = this.f2462a;
        if (map2 != null && (map = a2Var.f2462a) != null) {
            map2.putAll(map);
        }
    }

    public void h(@NonNull String str, @NonNull Object obj) {
        this.f2462a.put(str, obj);
    }
}
