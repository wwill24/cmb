package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.Set;

public class a2 {

    /* renamed from: b  reason: collision with root package name */
    private static final a2 f2461b = new a2(new ArrayMap());

    /* renamed from: a  reason: collision with root package name */
    protected final Map<String, Object> f2462a;

    protected a2(@NonNull Map<String, Object> map) {
        this.f2462a = map;
    }

    @NonNull
    public static a2 a() {
        return f2461b;
    }

    @NonNull
    public static a2 b(@NonNull a2 a2Var) {
        ArrayMap arrayMap = new ArrayMap();
        for (String next : a2Var.d()) {
            arrayMap.put(next, a2Var.c(next));
        }
        return new a2(arrayMap);
    }

    public Object c(@NonNull String str) {
        return this.f2462a.get(str);
    }

    @NonNull
    public Set<String> d() {
        return this.f2462a.keySet();
    }

    @NonNull
    public final String toString() {
        return "android.hardware.camera2.CaptureRequest.setTag.CX";
    }
}
