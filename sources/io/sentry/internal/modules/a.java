package io.sentry.internal.modules;

import io.sentry.h0;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
@ApiStatus.Internal
public final class a extends d {

    /* renamed from: d  reason: collision with root package name */
    private final List<b> f31291d;

    public a(List<b> list, h0 h0Var) {
        super(h0Var);
        this.f31291d = list;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        for (b a10 : this.f31291d) {
            Map<String, String> a11 = a10.a();
            if (a11 != null) {
                treeMap.putAll(a11);
            }
        }
        return treeMap;
    }
}
