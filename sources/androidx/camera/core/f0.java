package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    private final List<z1> f2231a;

    /* renamed from: b  reason: collision with root package name */
    private final List<z1> f2232b;

    /* renamed from: c  reason: collision with root package name */
    private final List<z1> f2233c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2234d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final List<z1> f2235a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        final List<z1> f2236b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        final List<z1> f2237c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        long f2238d = 5000;

        public a(@NonNull z1 z1Var, int i10) {
            a(z1Var, i10);
        }

        @NonNull
        public a a(@NonNull z1 z1Var, int i10) {
            boolean z10;
            boolean z11 = false;
            if (z1Var != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.b(z10, "Point cannot be null.");
            if (i10 >= 1 && i10 <= 7) {
                z11 = true;
            }
            h.b(z11, "Invalid metering mode " + i10);
            if ((i10 & 1) != 0) {
                this.f2235a.add(z1Var);
            }
            if ((i10 & 2) != 0) {
                this.f2236b.add(z1Var);
            }
            if ((i10 & 4) != 0) {
                this.f2237c.add(z1Var);
            }
            return this;
        }

        @NonNull
        public f0 b() {
            return new f0(this);
        }
    }

    f0(a aVar) {
        this.f2231a = Collections.unmodifiableList(aVar.f2235a);
        this.f2232b = Collections.unmodifiableList(aVar.f2236b);
        this.f2233c = Collections.unmodifiableList(aVar.f2237c);
        this.f2234d = aVar.f2238d;
    }

    public long a() {
        return this.f2234d;
    }

    @NonNull
    public List<z1> b() {
        return this.f2232b;
    }

    @NonNull
    public List<z1> c() {
        return this.f2231a;
    }

    @NonNull
    public List<z1> d() {
        return this.f2233c;
    }

    public boolean e() {
        return this.f2234d > 0;
    }
}
