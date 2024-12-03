package t;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.h1;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.o1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import zf.a;

class d0 implements h0 {

    /* renamed from: a  reason: collision with root package name */
    private final p0 f17555a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Void> f17556b;

    /* renamed from: c  reason: collision with root package name */
    private CallbackToFutureAdapter.a<Void> f17557c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17558d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17559e = false;

    d0(@NonNull p0 p0Var) {
        this.f17555a = p0Var;
        this.f17556b = CallbackToFutureAdapter.a(new c0(this));
    }

    private void h() {
        h.j(this.f17556b.isDone(), "onImageCaptured() must be called before onFinalResult()");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object j(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f17557c = aVar;
        return "CaptureCompleteFuture";
    }

    private void k() {
        h.j(!this.f17558d, "The callback can only complete once.");
        this.f17558d = true;
    }

    private void l(@NonNull ImageCaptureException imageCaptureException) {
        p.a();
        this.f17555a.r(imageCaptureException);
    }

    public void a(@NonNull h1.p pVar) {
        p.a();
        if (!this.f17559e) {
            h();
            k();
            this.f17555a.s(pVar);
        }
    }

    public void b(@NonNull ImageCaptureException imageCaptureException) {
        p.a();
        if (!this.f17559e) {
            h();
            k();
            l(imageCaptureException);
        }
    }

    public void c(@NonNull o1 o1Var) {
        p.a();
        if (!this.f17559e) {
            h();
            k();
            this.f17555a.t(o1Var);
        }
    }

    public void d(@NonNull ImageCaptureException imageCaptureException) {
        p.a();
        if (!this.f17559e) {
            k();
            this.f17557c.c(null);
            l(imageCaptureException);
        }
    }

    public void e() {
        p.a();
        if (!this.f17559e) {
            this.f17557c.c(null);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull ImageCaptureException imageCaptureException) {
        p.a();
        this.f17559e = true;
        this.f17557c.c(null);
        l(imageCaptureException);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public a<Void> i() {
        p.a();
        return this.f17556b;
    }

    public boolean isAborted() {
        return this.f17559e;
    }
}
