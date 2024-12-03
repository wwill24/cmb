package ie;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final List f40978a;

    /* renamed from: b  reason: collision with root package name */
    private final a f40979b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f40980c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f40981d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f40982a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private boolean f40983b = true;

        /* renamed from: c  reason: collision with root package name */
        private a f40984c;

        /* renamed from: d  reason: collision with root package name */
        private Executor f40985d;

        @NonNull
        public a a(@NonNull e eVar) {
            this.f40982a.add(eVar);
            return this;
        }

        @NonNull
        public d b() {
            return new d(this.f40982a, this.f40984c, this.f40985d, this.f40983b, (g) null);
        }
    }

    /* synthetic */ d(List list, a aVar, Executor executor, boolean z10, g gVar) {
        p.l(list, "APIs must not be null.");
        p.b(!list.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            p.l(aVar, "Listener must not be null when listener executor is set.");
        }
        this.f40978a = list;
        this.f40979b = aVar;
        this.f40980c = executor;
        this.f40981d = z10;
    }

    @NonNull
    public static a d() {
        return new a();
    }

    @NonNull
    public List<e> a() {
        return this.f40978a;
    }

    public a b() {
        return this.f40979b;
    }

    public Executor c() {
        return this.f40980c;
    }

    public final boolean e() {
        return this.f40981d;
    }
}
