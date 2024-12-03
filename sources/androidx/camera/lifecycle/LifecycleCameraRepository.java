package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.k3;
import androidx.camera.core.m;
import androidx.core.util.h;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.v;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class LifecycleCameraRepository {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2971a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Map<a, LifecycleCamera> f2972b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<LifecycleCameraRepositoryObserver, Set<a>> f2973c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<l> f2974d = new ArrayDeque<>();

    private static class LifecycleCameraRepositoryObserver implements k {

        /* renamed from: a  reason: collision with root package name */
        private final LifecycleCameraRepository f2975a;

        /* renamed from: b  reason: collision with root package name */
        private final l f2976b;

        LifecycleCameraRepositoryObserver(l lVar, LifecycleCameraRepository lifecycleCameraRepository) {
            this.f2976b = lVar;
            this.f2975a = lifecycleCameraRepository;
        }

        /* access modifiers changed from: package-private */
        public l a() {
            return this.f2976b;
        }

        @v(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(l lVar) {
            this.f2975a.l(lVar);
        }

        @v(Lifecycle.Event.ON_START)
        public void onStart(l lVar) {
            this.f2975a.h(lVar);
        }

        @v(Lifecycle.Event.ON_STOP)
        public void onStop(l lVar) {
            this.f2975a.i(lVar);
        }
    }

    static abstract class a {
        a() {
        }

        static a a(@NonNull l lVar, @NonNull CameraUseCaseAdapter.a aVar) {
            return new a(lVar, aVar);
        }

        @NonNull
        public abstract CameraUseCaseAdapter.a b();

        @NonNull
        public abstract l c();
    }

    LifecycleCameraRepository() {
    }

    private LifecycleCameraRepositoryObserver d(l lVar) {
        synchronized (this.f2971a) {
            for (LifecycleCameraRepositoryObserver next : this.f2973c.keySet()) {
                if (lVar.equals(next.a())) {
                    return next;
                }
            }
            return null;
        }
    }

    private boolean f(l lVar) {
        synchronized (this.f2971a) {
            LifecycleCameraRepositoryObserver d10 = d(lVar);
            if (d10 == null) {
                return false;
            }
            for (a aVar : this.f2973c.get(d10)) {
                if (!((LifecycleCamera) h.g(this.f2972b.get(aVar))).p().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    private void g(LifecycleCamera lifecycleCamera) {
        Set set;
        synchronized (this.f2971a) {
            l o10 = lifecycleCamera.o();
            a a10 = a.a(o10, lifecycleCamera.n().x());
            LifecycleCameraRepositoryObserver d10 = d(o10);
            if (d10 != null) {
                set = this.f2973c.get(d10);
            } else {
                set = new HashSet();
            }
            set.add(a10);
            this.f2972b.put(a10, lifecycleCamera);
            if (d10 == null) {
                LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = new LifecycleCameraRepositoryObserver(o10, this);
                this.f2973c.put(lifecycleCameraRepositoryObserver, set);
                o10.getLifecycle().a(lifecycleCameraRepositoryObserver);
            }
        }
    }

    private void j(l lVar) {
        synchronized (this.f2971a) {
            LifecycleCameraRepositoryObserver d10 = d(lVar);
            if (d10 != null) {
                for (a aVar : this.f2973c.get(d10)) {
                    ((LifecycleCamera) h.g(this.f2972b.get(aVar))).r();
                }
            }
        }
    }

    private void m(l lVar) {
        synchronized (this.f2971a) {
            for (a aVar : this.f2973c.get(d(lVar))) {
                LifecycleCamera lifecycleCamera = this.f2972b.get(aVar);
                if (!((LifecycleCamera) h.g(lifecycleCamera)).p().isEmpty()) {
                    lifecycleCamera.t();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull LifecycleCamera lifecycleCamera, k3 k3Var, @NonNull List<m> list, @NonNull Collection<UseCase> collection) {
        boolean z10;
        synchronized (this.f2971a) {
            if (!collection.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.a(z10);
            l o10 = lifecycleCamera.o();
            for (a aVar : this.f2973c.get(d(o10))) {
                LifecycleCamera lifecycleCamera2 = (LifecycleCamera) h.g(this.f2972b.get(aVar));
                if (!lifecycleCamera2.equals(lifecycleCamera)) {
                    if (!lifecycleCamera2.p().isEmpty()) {
                        throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                    }
                }
            }
            try {
                lifecycleCamera.n().K(k3Var);
                lifecycleCamera.n().J(list);
                lifecycleCamera.d(collection);
                if (o10.getLifecycle().b().b(Lifecycle.State.STARTED)) {
                    h(o10);
                }
            } catch (CameraUseCaseAdapter.CameraException e10) {
                throw new IllegalArgumentException(e10.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public LifecycleCamera b(@NonNull l lVar, @NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        boolean z10;
        LifecycleCamera lifecycleCamera;
        synchronized (this.f2971a) {
            if (this.f2972b.get(a.a(lVar, cameraUseCaseAdapter.x())) == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            h.b(z10, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
            if (lVar.getLifecycle().b() != Lifecycle.State.DESTROYED) {
                lifecycleCamera = new LifecycleCamera(lVar, cameraUseCaseAdapter);
                if (cameraUseCaseAdapter.z().isEmpty()) {
                    lifecycleCamera.r();
                }
                g(lifecycleCamera);
            } else {
                throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
            }
        }
        return lifecycleCamera;
    }

    /* access modifiers changed from: package-private */
    public LifecycleCamera c(l lVar, CameraUseCaseAdapter.a aVar) {
        LifecycleCamera lifecycleCamera;
        synchronized (this.f2971a) {
            lifecycleCamera = this.f2972b.get(a.a(lVar, aVar));
        }
        return lifecycleCamera;
    }

    /* access modifiers changed from: package-private */
    public Collection<LifecycleCamera> e() {
        Collection<LifecycleCamera> unmodifiableCollection;
        synchronized (this.f2971a) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.f2972b.values());
        }
        return unmodifiableCollection;
    }

    /* access modifiers changed from: package-private */
    public void h(l lVar) {
        synchronized (this.f2971a) {
            if (f(lVar)) {
                if (this.f2974d.isEmpty()) {
                    this.f2974d.push(lVar);
                } else {
                    l peek = this.f2974d.peek();
                    if (!lVar.equals(peek)) {
                        j(peek);
                        this.f2974d.remove(lVar);
                        this.f2974d.push(lVar);
                    }
                }
                m(lVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(l lVar) {
        synchronized (this.f2971a) {
            this.f2974d.remove(lVar);
            j(lVar);
            if (!this.f2974d.isEmpty()) {
                m(this.f2974d.peek());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        synchronized (this.f2971a) {
            for (a aVar : this.f2972b.keySet()) {
                LifecycleCamera lifecycleCamera = this.f2972b.get(aVar);
                lifecycleCamera.s();
                i(lifecycleCamera.o());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(l lVar) {
        synchronized (this.f2971a) {
            LifecycleCameraRepositoryObserver d10 = d(lVar);
            if (d10 != null) {
                i(lVar);
                for (a remove : this.f2973c.get(d10)) {
                    this.f2972b.remove(remove);
                }
                this.f2973c.remove(d10);
                d10.a().getLifecycle().d(d10);
            }
        }
    }
}
