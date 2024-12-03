package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.l1;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.x;
import androidx.camera.core.q;
import androidx.camera.core.v1;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.t;
import java.util.ArrayList;
import java.util.List;
import u.c;
import u.d;
import u.f;

final class e implements l1.a<CameraInternal.State> {

    /* renamed from: a  reason: collision with root package name */
    private final x f3467a;

    /* renamed from: b  reason: collision with root package name */
    private final t<PreviewView.StreamState> f3468b;

    /* renamed from: c  reason: collision with root package name */
    private PreviewView.StreamState f3469c;

    /* renamed from: d  reason: collision with root package name */
    private final l f3470d;

    /* renamed from: e  reason: collision with root package name */
    zf.a<Void> f3471e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3472f = false;

    class a implements c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f3473a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f3474b;

        a(List list, q qVar) {
            this.f3473a = list;
            this.f3474b = qVar;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            e.this.f3471e = null;
        }

        public void onFailure(@NonNull Throwable th2) {
            e.this.f3471e = null;
            if (!this.f3473a.isEmpty()) {
                for (n f10 : this.f3473a) {
                    ((x) this.f3474b).f(f10);
                }
                this.f3473a.clear();
            }
        }
    }

    class b extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CallbackToFutureAdapter.a f3476a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f3477b;

        b(CallbackToFutureAdapter.a aVar, q qVar) {
            this.f3476a = aVar;
            this.f3477b = qVar;
        }

        public void b(@NonNull p pVar) {
            this.f3476a.c(null);
            ((x) this.f3477b).f(this);
        }
    }

    e(x xVar, t<PreviewView.StreamState> tVar, l lVar) {
        this.f3467a = xVar;
        this.f3468b = tVar;
        this.f3470d = lVar;
        synchronized (this) {
            this.f3469c = tVar.f();
        }
    }

    private void e() {
        zf.a<Void> aVar = this.f3471e;
        if (aVar != null) {
            aVar.cancel(false);
            this.f3471e = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ zf.a g(Void voidR) throws Exception {
        return this.f3470d.j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void h(Void voidR) {
        l(PreviewView.StreamState.STREAMING);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object i(q qVar, List list, CallbackToFutureAdapter.a aVar) throws Exception {
        b bVar = new b(aVar, qVar);
        list.add(bVar);
        ((x) qVar).b(androidx.camera.core.impl.utils.executor.a.a(), bVar);
        return "waitForCaptureResult";
    }

    private void k(q qVar) {
        l(PreviewView.StreamState.IDLE);
        ArrayList arrayList = new ArrayList();
        d<T> d10 = d.a(m(qVar, arrayList)).e(new b(this), androidx.camera.core.impl.utils.executor.a.a()).d(new c(this), androidx.camera.core.impl.utils.executor.a.a());
        this.f3471e = d10;
        f.b(d10, new a(arrayList, qVar), androidx.camera.core.impl.utils.executor.a.a());
    }

    private zf.a<Void> m(q qVar, List<n> list) {
        return CallbackToFutureAdapter.a(new d(this, qVar, list));
    }

    /* access modifiers changed from: package-private */
    public void f() {
        e();
    }

    /* renamed from: j */
    public void a(CameraInternal.State state) {
        if (state == CameraInternal.State.CLOSING || state == CameraInternal.State.CLOSED || state == CameraInternal.State.RELEASING || state == CameraInternal.State.RELEASED) {
            l(PreviewView.StreamState.IDLE);
            if (this.f3472f) {
                this.f3472f = false;
                e();
            }
        } else if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.f3472f) {
            k(this.f3467a);
            this.f3472f = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void l(PreviewView.StreamState streamState) {
        synchronized (this) {
            if (!this.f3469c.equals(streamState)) {
                this.f3469c = streamState;
                v1.a("StreamStateObserver", "Update Preview stream state to " + streamState);
                this.f3468b.m(streamState);
            }
        }
    }

    public void onError(@NonNull Throwable th2) {
        f();
        l(PreviewView.StreamState.IDLE);
    }
}
