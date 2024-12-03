package t;

import a0.l;
import a0.n;
import a0.o;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.h1;
import androidx.camera.core.o1;
import java.util.Objects;
import java.util.concurrent.Executor;
import t.i;
import t.n;
import t.r;

public class a0 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Executor f17530a;

    /* renamed from: b  reason: collision with root package name */
    private n<b, o<o1>> f17531b;

    /* renamed from: c  reason: collision with root package name */
    private n<n.a, o<byte[]>> f17532c;

    /* renamed from: d  reason: collision with root package name */
    private a0.n<i.a, o<byte[]>> f17533d;

    /* renamed from: e  reason: collision with root package name */
    private a0.n<r.a, h1.p> f17534e;

    /* renamed from: f  reason: collision with root package name */
    private a0.n<o<byte[]>, o<Bitmap>> f17535f;

    /* renamed from: g  reason: collision with root package name */
    private a0.n<o<o1>, o1> f17536g;

    /* renamed from: h  reason: collision with root package name */
    private a0.n<o<byte[]>, o<o1>> f17537h;

    static abstract class a {
        a() {
        }

        static a c(int i10) {
            return new f(new l(), i10);
        }

        /* access modifiers changed from: package-private */
        public abstract l<b> a();

        /* access modifiers changed from: package-private */
        public abstract int b();
    }

    static abstract class b {
        b() {
        }

        static b c(@NonNull b0 b0Var, @NonNull o1 o1Var) {
            return new g(b0Var, o1Var);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract o1 a();

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract b0 b();
    }

    a0(@NonNull Executor executor) {
        this.f17530a = executor;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(b bVar) {
        if (!bVar.b().h()) {
            this.f17530a.execute(new x(this, bVar));
        }
    }

    private static void o(@NonNull b0 b0Var, @NonNull ImageCaptureException imageCaptureException) {
        androidx.camera.core.impl.utils.executor.a.d().execute(new v(b0Var, imageCaptureException));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public o1 k(@NonNull b bVar) throws ImageCaptureException {
        b0 b10 = bVar.b();
        o apply = this.f17531b.apply(bVar);
        if (apply.e() == 35) {
            apply = this.f17537h.apply(this.f17532c.apply(n.a.c(apply, b10.b())));
        }
        return this.f17536g.apply(apply);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void i(@NonNull b bVar) {
        b0 b10 = bVar.b();
        try {
            if (bVar.b().i()) {
                androidx.camera.core.impl.utils.executor.a.d().execute(new y(b10, k(bVar)));
                return;
            }
            androidx.camera.core.impl.utils.executor.a.d().execute(new z(b10, m(bVar)));
        } catch (ImageCaptureException e10) {
            o(b10, e10);
        } catch (RuntimeException e11) {
            o(b10, new ImageCaptureException(0, "Processing failed.", e11));
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public h1.p m(@NonNull b bVar) throws ImageCaptureException {
        b0 b10 = bVar.b();
        o apply = this.f17532c.apply(n.a.c(this.f17531b.apply(bVar), b10.b()));
        if (apply.i()) {
            apply = this.f17533d.apply(i.a.c(this.f17535f.apply(apply), b10.b()));
        }
        a0.n<r.a, h1.p> nVar = this.f17534e;
        h1.o c10 = b10.c();
        Objects.requireNonNull(c10);
        return nVar.apply(r.a.c(apply, c10));
    }

    public void n() {
    }

    @NonNull
    public Void p(@NonNull a aVar) {
        aVar.a().a(new w(this));
        this.f17531b = new u();
        this.f17532c = new n();
        this.f17535f = new q();
        this.f17533d = new i();
        this.f17534e = new r();
        this.f17536g = new t();
        if (aVar.b() != 35) {
            return null;
        }
        this.f17537h = new s();
        return null;
    }
}
