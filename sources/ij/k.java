package ij;

import am.r;
import androidx.annotation.NonNull;
import ij.j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends r>, s> f29998a;

    static class a implements j.a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<? extends r>, s> f29999a = new HashMap(3);

        a() {
        }

        @NonNull
        public <N extends r> j.a a(@NonNull Class<N> cls, s sVar) {
            if (sVar == null) {
                this.f29999a.remove(cls);
            } else {
                this.f29999a.put(cls, sVar);
            }
            return this;
        }

        @NonNull
        public j build() {
            return new k(Collections.unmodifiableMap(this.f29999a));
        }
    }

    k(@NonNull Map<Class<? extends r>, s> map) {
        this.f29998a = map;
    }

    public <N extends r> s get(@NonNull Class<N> cls) {
        return this.f29998a.get(cls);
    }
}
