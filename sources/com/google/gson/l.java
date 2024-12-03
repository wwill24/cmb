package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class l extends j {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedTreeMap<String, j> f21377a = new LinkedTreeMap<>(false);

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof l) && ((l) obj).f21377a.equals(this.f21377a))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f21377a.hashCode();
    }

    public void n(String str, j jVar) {
        LinkedTreeMap<String, j> linkedTreeMap = this.f21377a;
        if (jVar == null) {
            jVar = k.f21376a;
        }
        linkedTreeMap.put(str, jVar);
    }

    public Set<Map.Entry<String, j>> o() {
        return this.f21377a.entrySet();
    }

    public l p(String str) {
        return (l) this.f21377a.get(str);
    }

    public m q(String str) {
        return (m) this.f21377a.get(str);
    }

    public boolean r(String str) {
        return this.f21377a.containsKey(str);
    }
}
