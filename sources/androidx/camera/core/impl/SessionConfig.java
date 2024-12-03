package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.h;
import androidx.camera.core.v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class SessionConfig {

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f2411a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CameraDevice.StateCallback> f2412b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CameraCaptureSession.StateCallback> f2413c;

    /* renamed from: d  reason: collision with root package name */
    private final List<n> f2414d;

    /* renamed from: e  reason: collision with root package name */
    private final List<c> f2415e;

    /* renamed from: f  reason: collision with root package name */
    private final d0 f2416f;

    /* renamed from: g  reason: collision with root package name */
    private InputConfiguration f2417g;

    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Set<e> f2421a = new LinkedHashSet();

        /* renamed from: b  reason: collision with root package name */
        final d0.a f2422b = new d0.a();

        /* renamed from: c  reason: collision with root package name */
        final List<CameraDevice.StateCallback> f2423c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        final List<CameraCaptureSession.StateCallback> f2424d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        final List<c> f2425e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        final List<n> f2426f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        InputConfiguration f2427g;

        a() {
        }
    }

    public static class b extends a {
        @NonNull
        public static b o(@NonNull f2<?> f2Var) {
            d I = f2Var.I((d) null);
            if (I != null) {
                b bVar = new b();
                I.a(f2Var, bVar);
                return bVar;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + f2Var.s(f2Var.toString()));
        }

        @NonNull
        public b a(@NonNull Collection<CameraDevice.StateCallback> collection) {
            for (CameraDevice.StateCallback e10 : collection) {
                e(e10);
            }
            return this;
        }

        @NonNull
        public b b(@NonNull Collection<n> collection) {
            this.f2422b.a(collection);
            return this;
        }

        @NonNull
        public b c(@NonNull List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback j10 : list) {
                j(j10);
            }
            return this;
        }

        @NonNull
        public b d(@NonNull n nVar) {
            this.f2422b.c(nVar);
            if (!this.f2426f.contains(nVar)) {
                this.f2426f.add(nVar);
            }
            return this;
        }

        @NonNull
        public b e(@NonNull CameraDevice.StateCallback stateCallback) {
            if (this.f2423c.contains(stateCallback)) {
                return this;
            }
            this.f2423c.add(stateCallback);
            return this;
        }

        @NonNull
        public b f(@NonNull c cVar) {
            this.f2425e.add(cVar);
            return this;
        }

        @NonNull
        public b g(@NonNull Config config) {
            this.f2422b.e(config);
            return this;
        }

        @NonNull
        public b h(@NonNull DeferrableSurface deferrableSurface) {
            this.f2421a.add(e.a(deferrableSurface).a());
            return this;
        }

        @NonNull
        public b i(@NonNull n nVar) {
            this.f2422b.c(nVar);
            return this;
        }

        @NonNull
        public b j(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            if (this.f2424d.contains(stateCallback)) {
                return this;
            }
            this.f2424d.add(stateCallback);
            return this;
        }

        @NonNull
        public b k(@NonNull DeferrableSurface deferrableSurface) {
            this.f2421a.add(e.a(deferrableSurface).a());
            this.f2422b.f(deferrableSurface);
            return this;
        }

        @NonNull
        public b l(@NonNull String str, @NonNull Object obj) {
            this.f2422b.g(str, obj);
            return this;
        }

        @NonNull
        public SessionConfig m() {
            return new SessionConfig(new ArrayList(this.f2421a), this.f2423c, this.f2424d, this.f2426f, this.f2425e, this.f2422b.h(), this.f2427g);
        }

        @NonNull
        public b n() {
            this.f2421a.clear();
            this.f2422b.i();
            return this;
        }

        @NonNull
        public List<n> p() {
            return Collections.unmodifiableList(this.f2426f);
        }

        public boolean q(@NonNull n nVar) {
            boolean n10 = this.f2422b.n(nVar);
            boolean remove = this.f2426f.remove(nVar);
            if (n10 || remove) {
                return true;
            }
            return false;
        }

        @NonNull
        public b r(@NonNull Config config) {
            this.f2422b.p(config);
            return this;
        }

        @NonNull
        public b s(InputConfiguration inputConfiguration) {
            this.f2427g = inputConfiguration;
            return this;
        }

        @NonNull
        public b t(int i10) {
            this.f2422b.q(i10);
            return this;
        }
    }

    public interface c {
        void a(@NonNull SessionConfig sessionConfig, @NonNull SessionError sessionError);
    }

    public interface d {
        void a(@NonNull f2<?> f2Var, @NonNull b bVar);
    }

    public static abstract class e {

        public static abstract class a {
            @NonNull
            public abstract e a();

            @NonNull
            public abstract a b(String str);

            @NonNull
            public abstract a c(@NonNull List<DeferrableSurface> list);

            @NonNull
            public abstract a d(int i10);
        }

        @NonNull
        public static a a(@NonNull DeferrableSurface deferrableSurface) {
            return new h.b().e(deferrableSurface).c(Collections.emptyList()).b((String) null).d(-1);
        }

        public abstract String b();

        @NonNull
        public abstract List<DeferrableSurface> c();

        @NonNull
        public abstract DeferrableSurface d();

        public abstract int e();
    }

    public static final class f extends a {

        /* renamed from: k  reason: collision with root package name */
        private static final List<Integer> f2428k = Arrays.asList(new Integer[]{1, 5, 3});

        /* renamed from: h  reason: collision with root package name */
        private final y.c f2429h = new y.c();

        /* renamed from: i  reason: collision with root package name */
        private boolean f2430i = true;

        /* renamed from: j  reason: collision with root package name */
        private boolean f2431j = false;

        private List<DeferrableSurface> e() {
            ArrayList arrayList = new ArrayList();
            for (e next : this.f2421a) {
                arrayList.add(next.d());
                for (DeferrableSurface add : next.c()) {
                    arrayList.add(add);
                }
            }
            return arrayList;
        }

        private int g(int i10, int i11) {
            List<Integer> list = f2428k;
            if (list.indexOf(Integer.valueOf(i10)) >= list.indexOf(Integer.valueOf(i11))) {
                return i10;
            }
            return i11;
        }

        public void a(@NonNull SessionConfig sessionConfig) {
            d0 h10 = sessionConfig.h();
            if (h10.g() != -1) {
                this.f2431j = true;
                this.f2422b.q(g(h10.g(), this.f2422b.m()));
            }
            this.f2422b.b(sessionConfig.h().f());
            this.f2423c.addAll(sessionConfig.b());
            this.f2424d.addAll(sessionConfig.i());
            this.f2422b.a(sessionConfig.g());
            this.f2426f.addAll(sessionConfig.j());
            this.f2425e.addAll(sessionConfig.c());
            if (sessionConfig.e() != null) {
                this.f2427g = sessionConfig.e();
            }
            this.f2421a.addAll(sessionConfig.f());
            this.f2422b.l().addAll(h10.e());
            if (!e().containsAll(this.f2422b.l())) {
                v1.a("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.f2430i = false;
            }
            this.f2422b.e(h10.d());
        }

        public <T> void b(@NonNull Config.a<T> aVar, @NonNull T t10) {
            this.f2422b.d(aVar, t10);
        }

        @NonNull
        public SessionConfig c() {
            if (this.f2430i) {
                ArrayList arrayList = new ArrayList(this.f2421a);
                this.f2429h.d(arrayList);
                return new SessionConfig(arrayList, this.f2423c, this.f2424d, this.f2426f, this.f2425e, this.f2422b.h(), this.f2427g);
            }
            throw new IllegalArgumentException("Unsupported session configuration combination");
        }

        public void d() {
            this.f2421a.clear();
            this.f2422b.i();
        }

        public boolean f() {
            return this.f2431j && this.f2430i;
        }
    }

    SessionConfig(List<e> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<n> list4, List<c> list5, d0 d0Var, InputConfiguration inputConfiguration) {
        this.f2411a = list;
        this.f2412b = Collections.unmodifiableList(list2);
        this.f2413c = Collections.unmodifiableList(list3);
        this.f2414d = Collections.unmodifiableList(list4);
        this.f2415e = Collections.unmodifiableList(list5);
        this.f2416f = d0Var;
        this.f2417g = inputConfiguration;
    }

    @NonNull
    public static SessionConfig a() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new ArrayList(0), new d0.a().h(), (InputConfiguration) null);
    }

    @NonNull
    public List<CameraDevice.StateCallback> b() {
        return this.f2412b;
    }

    @NonNull
    public List<c> c() {
        return this.f2415e;
    }

    @NonNull
    public Config d() {
        return this.f2416f.d();
    }

    public InputConfiguration e() {
        return this.f2417g;
    }

    @NonNull
    public List<e> f() {
        return this.f2411a;
    }

    @NonNull
    public List<n> g() {
        return this.f2416f.b();
    }

    @NonNull
    public d0 h() {
        return this.f2416f;
    }

    @NonNull
    public List<CameraCaptureSession.StateCallback> i() {
        return this.f2413c;
    }

    @NonNull
    public List<n> j() {
        return this.f2414d;
    }

    @NonNull
    public List<DeferrableSurface> k() {
        ArrayList arrayList = new ArrayList();
        for (e next : this.f2411a) {
            arrayList.add(next.d());
            for (DeferrableSurface add : next.c()) {
                arrayList.add(add);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int l() {
        return this.f2416f.g();
    }
}
