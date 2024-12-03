package tg;

import androidx.annotation.NonNull;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map f24623a = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Class f24624a;

        /* renamed from: b  reason: collision with root package name */
        private final Provider f24625b;

        public <RemoteT extends b> a(@NonNull Class<RemoteT> cls, @NonNull Provider<Object> provider) {
            this.f24624a = cls;
            this.f24625b = provider;
        }

        /* access modifiers changed from: package-private */
        public final Provider a() {
            return this.f24625b;
        }

        /* access modifiers changed from: package-private */
        public final Class b() {
            return this.f24624a;
        }
    }

    public c(@NonNull Set<a> set) {
        for (a next : set) {
            this.f24623a.put(next.b(), next.a());
        }
    }
}
