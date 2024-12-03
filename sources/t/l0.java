package t;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.h0;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.o1;
import androidx.core.util.d;
import androidx.core.util.h;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import u.c;
import u.f;

public class l0 implements h0.a {

    /* renamed from: a  reason: collision with root package name */
    final Deque<p0> f17588a = new ArrayDeque();

    /* renamed from: b  reason: collision with root package name */
    final p f17589b;

    /* renamed from: c  reason: collision with root package name */
    final o f17590c;

    /* renamed from: d  reason: collision with root package name */
    d0 f17591d;

    /* renamed from: e  reason: collision with root package name */
    boolean f17592e = false;

    class a implements c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f17593a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f17594b;

        a(Runnable runnable, j jVar) {
            this.f17593a = runnable;
            this.f17594b = jVar;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            this.f17593a.run();
            l0.this.f17590c.c();
        }

        public void onFailure(@NonNull Throwable th2) {
            if (th2 instanceof ImageCaptureException) {
                this.f17594b.b((ImageCaptureException) th2);
            } else {
                this.f17594b.b(new ImageCaptureException(2, "Failed to submit capture request", th2));
            }
            l0.this.f17590c.c();
        }
    }

    public l0(@NonNull o oVar, @NonNull p pVar) {
        p.a();
        this.f17590c = oVar;
        this.f17589b = pVar;
        pVar.j(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(b0 b0Var) {
        this.f17589b.i(b0Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f17591d = null;
        f();
    }

    private void l(@NonNull j jVar, @NonNull Runnable runnable) {
        p.a();
        this.f17590c.b();
        f.b(this.f17590c.a(jVar.a()), new a(runnable, jVar), androidx.camera.core.impl.utils.executor.a.d());
    }

    private void m(@NonNull d0 d0Var) {
        h.i(!e());
        this.f17591d = d0Var;
        d0Var.i().addListener(new k0(this), androidx.camera.core.impl.utils.executor.a.a());
    }

    public void a(@NonNull o1 o1Var) {
        androidx.camera.core.impl.utils.executor.a.d().execute(new j0(this));
    }

    public void d() {
        p.a();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", (Throwable) null);
        for (p0 r10 : this.f17588a) {
            r10.r(imageCaptureException);
        }
        this.f17588a.clear();
        d0 d0Var = this.f17591d;
        if (d0Var != null) {
            d0Var.g(imageCaptureException);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f17591d != null;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        p0 poll;
        p.a();
        if (!e() && !this.f17592e && this.f17589b.h() != 0 && (poll = this.f17588a.poll()) != null) {
            d0 d0Var = new d0(poll);
            m(d0Var);
            d<j, b0> e10 = this.f17589b.e(poll, d0Var);
            j jVar = (j) e10.f4735a;
            Objects.requireNonNull(jVar);
            b0 b0Var = (b0) e10.f4736b;
            Objects.requireNonNull(b0Var);
            l(jVar, new i0(this, b0Var));
        }
    }

    public void i(@NonNull p0 p0Var) {
        p.a();
        this.f17588a.offer(p0Var);
        f();
    }

    public void j() {
        p.a();
        this.f17592e = true;
    }

    public void k() {
        p.a();
        this.f17592e = false;
        f();
    }
}
