package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;

public final class f3 {

    /* renamed from: a  reason: collision with root package name */
    private final k3 f2253a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final List<UseCase> f2254b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final List<m> f2255c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private k3 f2256a;

        /* renamed from: b  reason: collision with root package name */
        private final List<UseCase> f2257b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<m> f2258c = new ArrayList();

        @NonNull
        public a a(@NonNull UseCase useCase) {
            this.f2257b.add(useCase);
            return this;
        }

        @NonNull
        public f3 b() {
            h.b(!this.f2257b.isEmpty(), "UseCase must not be empty.");
            return new f3(this.f2256a, this.f2257b, this.f2258c);
        }
    }

    f3(k3 k3Var, @NonNull List<UseCase> list, @NonNull List<m> list2) {
        this.f2253a = k3Var;
        this.f2254b = list;
        this.f2255c = list2;
    }

    @NonNull
    public List<m> a() {
        return this.f2255c;
    }

    @NonNull
    public List<UseCase> b() {
        return this.f2254b;
    }

    public k3 c() {
        return this.f2253a;
    }
}
