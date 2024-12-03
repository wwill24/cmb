package a4;

import androidx.annotation.NonNull;
import i3.g;
import java.util.ArrayList;
import java.util.List;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f147a = new ArrayList();

    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f148a;

        /* renamed from: b  reason: collision with root package name */
        final g<T> f149b;

        a(@NonNull Class<T> cls, @NonNull g<T> gVar) {
            this.f148a = cls;
            this.f149b = gVar;
        }

        /* access modifiers changed from: package-private */
        public boolean a(@NonNull Class<?> cls) {
            return this.f148a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull g<Z> gVar) {
        this.f147a.add(new a(cls, gVar));
    }

    public synchronized <Z> g<Z> b(@NonNull Class<Z> cls) {
        int size = this.f147a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = this.f147a.get(i10);
            if (aVar.a(cls)) {
                return aVar.f149b;
            }
        }
        return null;
    }
}
