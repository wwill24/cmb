package s;

import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.t;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import n.a;
import u.f;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f17427a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17428b = false;

    /* renamed from: c  reason: collision with root package name */
    private final t f17429c;

    /* renamed from: d  reason: collision with root package name */
    final Executor f17430d;

    /* renamed from: e  reason: collision with root package name */
    final Object f17431e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private a.C0174a f17432f = new a.C0174a();

    /* renamed from: g  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f17433g;

    /* renamed from: h  reason: collision with root package name */
    private final t.c f17434h = new d(this);

    public g(@NonNull t tVar, @NonNull Executor executor) {
        this.f17429c = tVar;
        this.f17430d = executor;
    }

    private void h(@NonNull j jVar) {
        synchronized (this.f17431e) {
            for (Config.a next : jVar.e()) {
                this.f17432f.a().p(next, jVar.a(next));
            }
        }
    }

    private void j() {
        synchronized (this.f17431e) {
            this.f17432f = new a.C0174a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f17430d.execute(new e(this, aVar));
        return "addCaptureRequestOptions";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f17430d.execute(new f(this, aVar));
        return "clearCaptureRequestOptions";
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ boolean q(android.hardware.camera2.TotalCaptureResult r3) {
        /*
            r2 = this;
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r0 = r2.f17433g
            r1 = 0
            if (r0 == 0) goto L_0x0032
            android.hardware.camera2.CaptureRequest r3 = r3.getRequest()
            java.lang.Object r3 = r3.getTag()
            boolean r0 = r3 instanceof androidx.camera.core.impl.a2
            if (r0 == 0) goto L_0x0032
            androidx.camera.core.impl.a2 r3 = (androidx.camera.core.impl.a2) r3
            java.lang.String r0 = "Camera2CameraControl"
            java.lang.Object r3 = r3.c(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x0032
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r0 = r2.f17433g
            int r0 = r0.hashCode()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r3 = r2.f17433g
            r2.f17433g = r1
            goto L_0x0033
        L_0x0032:
            r3 = r1
        L_0x0033:
            if (r3 == 0) goto L_0x0038
            r3.c(r1)
        L_0x0038:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: s.g.q(android.hardware.camera2.TotalCaptureResult):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void r(boolean z10) {
        if (this.f17427a != z10) {
            this.f17427a = z10;
            if (!z10) {
                CallbackToFutureAdapter.a<Void> aVar = this.f17433g;
                if (aVar != null) {
                    aVar.f(new CameraControl.OperationCanceledException("The camera control has became inactive."));
                    this.f17433g = null;
                }
            } else if (this.f17428b) {
                v();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void o(CallbackToFutureAdapter.a<Void> aVar) {
        this.f17428b = true;
        CallbackToFutureAdapter.a<Void> aVar2 = this.f17433g;
        if (aVar2 == null) {
            aVar2 = null;
        }
        this.f17433g = aVar;
        if (this.f17427a) {
            v();
        }
        if (aVar2 != null) {
            aVar2.f(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    private void v() {
        this.f17429c.j0();
        this.f17428b = false;
    }

    @NonNull
    public zf.a<Void> g(@NonNull j jVar) {
        h(jVar);
        return f.j(CallbackToFutureAdapter.a(new c(this)));
    }

    @NonNull
    public zf.a<Void> i() {
        j();
        return f.j(CallbackToFutureAdapter.a(new b(this)));
    }

    @NonNull
    public a k() {
        a c10;
        synchronized (this.f17431e) {
            if (this.f17433g != null) {
                this.f17432f.a().p(a.H, Integer.valueOf(this.f17433g.hashCode()));
            }
            c10 = this.f17432f.c();
        }
        return c10;
    }

    @NonNull
    public t.c l() {
        return this.f17434h;
    }

    public void s(boolean z10) {
        this.f17430d.execute(new a(this, z10));
    }
}
