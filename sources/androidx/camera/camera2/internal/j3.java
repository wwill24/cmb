package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Looper;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.t;
import androidx.camera.core.l3;
import androidx.camera.core.v1;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.t;
import java.util.concurrent.Executor;
import n.a;
import o.c0;
import v.f;

final class j3 {

    /* renamed from: a  reason: collision with root package name */
    private final t f1820a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f1821b;

    /* renamed from: c  reason: collision with root package name */
    private final k3 f1822c;

    /* renamed from: d  reason: collision with root package name */
    private final t<l3> f1823d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final b f1824e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1825f = false;

    /* renamed from: g  reason: collision with root package name */
    private t.c f1826g = new a();

    class a implements t.c {
        a() {
        }

        public boolean a(@NonNull TotalCaptureResult totalCaptureResult) {
            j3.this.f1824e.a(totalCaptureResult);
            return false;
        }
    }

    interface b {
        void a(@NonNull TotalCaptureResult totalCaptureResult);

        float b();

        void c(@NonNull a.C0174a aVar);

        void d();

        float e();

        @NonNull
        Rect f();
    }

    j3(@NonNull t tVar, @NonNull c0 c0Var, @NonNull Executor executor) {
        this.f1820a = tVar;
        this.f1821b = executor;
        b b10 = b(c0Var);
        this.f1824e = b10;
        k3 k3Var = new k3(b10.e(), b10.b());
        this.f1822c = k3Var;
        k3Var.f(1.0f);
        this.f1823d = new androidx.lifecycle.t<>(f.e(k3Var));
        tVar.t(this.f1826g);
    }

    private static b b(@NonNull c0 c0Var) {
        if (f(c0Var)) {
            return new a(c0Var);
        }
        return new u1(c0Var);
    }

    private static Range<Float> d(c0 c0Var) {
        try {
            return (Range) c0Var.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        } catch (AssertionError e10) {
            v1.m("ZoomControl", "AssertionError, fail to get camera characteristic.", e10);
            return null;
        }
    }

    static boolean f(c0 c0Var) {
        return Build.VERSION.SDK_INT >= 30 && d(c0Var) != null;
    }

    private void h(l3 l3Var) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f1823d.o(l3Var);
        } else {
            this.f1823d.m(l3Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(@NonNull a.C0174a aVar) {
        this.f1824e.c(aVar);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Rect c() {
        return this.f1824e.f();
    }

    /* access modifiers changed from: package-private */
    public LiveData<l3> e() {
        return this.f1823d;
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z10) {
        l3 e10;
        if (this.f1825f != z10) {
            this.f1825f = z10;
            if (!z10) {
                synchronized (this.f1822c) {
                    this.f1822c.f(1.0f);
                    e10 = f.e(this.f1822c);
                }
                h(e10);
                this.f1824e.d();
                this.f1820a.l0();
            }
        }
    }
}
