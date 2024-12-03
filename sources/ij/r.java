package ij;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

class r implements q {

    /* renamed from: a  reason: collision with root package name */
    private final Map<o, Object> f30013a = new HashMap(3);

    r() {
    }

    public <T> T a(@NonNull o<T> oVar) {
        return this.f30013a.get(oVar);
    }

    public <T> void b(@NonNull o<T> oVar, T t10) {
        if (t10 == null) {
            this.f30013a.remove(oVar);
        } else {
            this.f30013a.put(oVar, t10);
        }
    }
}
