package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

class t1 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Executor f1975a;

    /* renamed from: b  reason: collision with root package name */
    final Object f1976b = new Object();

    /* renamed from: c  reason: collision with root package name */
    final Set<r2> f1977c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    final Set<r2> f1978d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    final Set<r2> f1979e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    private final CameraDevice.StateCallback f1980f = new a();

    class a extends CameraDevice.StateCallback {
        a() {
        }

        private void b() {
            List<r2> g10;
            synchronized (t1.this.f1976b) {
                g10 = t1.this.g();
                t1.this.f1979e.clear();
                t1.this.f1977c.clear();
                t1.this.f1978d.clear();
            }
            for (r2 d10 : g10) {
                d10.d();
            }
        }

        private void c() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            synchronized (t1.this.f1976b) {
                linkedHashSet.addAll(t1.this.f1979e);
                linkedHashSet.addAll(t1.this.f1977c);
            }
            t1.this.f1975a.execute(new s1(linkedHashSet));
        }

        public void onClosed(@NonNull CameraDevice cameraDevice) {
            b();
        }

        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            c();
            b();
        }

        public void onError(@NonNull CameraDevice cameraDevice, int i10) {
            c();
            b();
        }

        public void onOpened(@NonNull CameraDevice cameraDevice) {
        }
    }

    t1(@NonNull Executor executor) {
        this.f1975a = executor;
    }

    private void a(@NonNull r2 r2Var) {
        r2 next;
        Iterator<r2> it = g().iterator();
        while (it.hasNext() && (next = it.next()) != r2Var) {
            next.d();
        }
    }

    /* access modifiers changed from: package-private */
    public static void b(@NonNull Set<r2> set) {
        for (r2 next : set) {
            next.c().p(next);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CameraDevice.StateCallback c() {
        return this.f1980f;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<r2> d() {
        ArrayList arrayList;
        synchronized (this.f1976b) {
            arrayList = new ArrayList(this.f1977c);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<r2> e() {
        ArrayList arrayList;
        synchronized (this.f1976b) {
            arrayList = new ArrayList(this.f1978d);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<r2> f() {
        ArrayList arrayList;
        synchronized (this.f1976b) {
            arrayList = new ArrayList(this.f1979e);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<r2> g() {
        ArrayList arrayList;
        synchronized (this.f1976b) {
            arrayList = new ArrayList();
            arrayList.addAll(d());
            arrayList.addAll(f());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull r2 r2Var) {
        synchronized (this.f1976b) {
            this.f1977c.remove(r2Var);
            this.f1978d.remove(r2Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull r2 r2Var) {
        synchronized (this.f1976b) {
            this.f1978d.add(r2Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(@NonNull r2 r2Var) {
        a(r2Var);
        synchronized (this.f1976b) {
            this.f1979e.remove(r2Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(@NonNull r2 r2Var) {
        synchronized (this.f1976b) {
            this.f1977c.add(r2Var);
            this.f1979e.remove(r2Var);
        }
        a(r2Var);
    }

    /* access modifiers changed from: package-private */
    public void l(@NonNull r2 r2Var) {
        synchronized (this.f1976b) {
            this.f1979e.add(r2Var);
        }
    }
}
