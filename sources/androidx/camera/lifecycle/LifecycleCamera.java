package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.r;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.l;
import androidx.camera.core.q;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.v;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class LifecycleCamera implements k, l {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2965a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final androidx.lifecycle.l f2966b;

    /* renamed from: c  reason: collision with root package name */
    private final CameraUseCaseAdapter f2967c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f2968d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2969e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2970f = false;

    LifecycleCamera(androidx.lifecycle.l lVar, CameraUseCaseAdapter cameraUseCaseAdapter) {
        this.f2966b = lVar;
        this.f2967c = cameraUseCaseAdapter;
        if (lVar.getLifecycle().b().b(Lifecycle.State.STARTED)) {
            cameraUseCaseAdapter.n();
        } else {
            cameraUseCaseAdapter.v();
        }
        lVar.getLifecycle().a(this);
    }

    @NonNull
    public CameraControl a() {
        return this.f2967c.a();
    }

    @NonNull
    public q b() {
        return this.f2967c.b();
    }

    /* access modifiers changed from: package-private */
    public void d(Collection<UseCase> collection) throws CameraUseCaseAdapter.CameraException {
        synchronized (this.f2965a) {
            this.f2967c.i(collection);
        }
    }

    public void m(r rVar) {
        this.f2967c.m(rVar);
    }

    public CameraUseCaseAdapter n() {
        return this.f2967c;
    }

    public androidx.lifecycle.l o() {
        androidx.lifecycle.l lVar;
        synchronized (this.f2965a) {
            lVar = this.f2966b;
        }
        return lVar;
    }

    @v(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.l lVar) {
        synchronized (this.f2965a) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.f2967c;
            cameraUseCaseAdapter.H(cameraUseCaseAdapter.z());
        }
    }

    @v(Lifecycle.Event.ON_PAUSE)
    public void onPause(androidx.lifecycle.l lVar) {
        this.f2967c.h(false);
    }

    @v(Lifecycle.Event.ON_RESUME)
    public void onResume(androidx.lifecycle.l lVar) {
        this.f2967c.h(true);
    }

    @v(Lifecycle.Event.ON_START)
    public void onStart(androidx.lifecycle.l lVar) {
        synchronized (this.f2965a) {
            if (!this.f2969e && !this.f2970f) {
                this.f2967c.n();
                this.f2968d = true;
            }
        }
    }

    @v(Lifecycle.Event.ON_STOP)
    public void onStop(androidx.lifecycle.l lVar) {
        synchronized (this.f2965a) {
            if (!this.f2969e && !this.f2970f) {
                this.f2967c.v();
                this.f2968d = false;
            }
        }
    }

    @NonNull
    public List<UseCase> p() {
        List<UseCase> unmodifiableList;
        synchronized (this.f2965a) {
            unmodifiableList = Collections.unmodifiableList(this.f2967c.z());
        }
        return unmodifiableList;
    }

    public boolean q(@NonNull UseCase useCase) {
        boolean contains;
        synchronized (this.f2965a) {
            contains = this.f2967c.z().contains(useCase);
        }
        return contains;
    }

    public void r() {
        synchronized (this.f2965a) {
            if (!this.f2969e) {
                onStop(this.f2966b);
                this.f2969e = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        synchronized (this.f2965a) {
            CameraUseCaseAdapter cameraUseCaseAdapter = this.f2967c;
            cameraUseCaseAdapter.H(cameraUseCaseAdapter.z());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f2965a
            monitor-enter(r0)
            boolean r1 = r3.f2969e     // Catch:{ all -> 0x0025 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0009:
            r1 = 0
            r3.f2969e = r1     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.l r1 = r3.f2966b     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.Lifecycle r1 = r1.getLifecycle()     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.Lifecycle$State r1 = r1.b()     // Catch:{ all -> 0x0025 }
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ all -> 0x0025 }
            boolean r1 = r1.b(r2)     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            androidx.lifecycle.l r1 = r3.f2966b     // Catch:{ all -> 0x0025 }
            r3.onStart(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.lifecycle.LifecycleCamera.t():void");
    }
}
