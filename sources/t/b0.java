package t;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.h1;
import androidx.camera.core.impl.c0;
import androidx.camera.core.impl.f0;
import androidx.camera.core.o1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class b0 {

    /* renamed from: a  reason: collision with root package name */
    private final h1.o f17541a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Rect f17542b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17543c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17544d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f17545e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final h0 f17546f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final String f17547g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final List<Integer> f17548h = new ArrayList();

    b0(@NonNull c0 c0Var, h1.o oVar, @NonNull Rect rect, int i10, int i11, @NonNull Matrix matrix, @NonNull h0 h0Var) {
        this.f17541a = oVar;
        this.f17544d = i11;
        this.f17543c = i10;
        this.f17542b = rect;
        this.f17545e = matrix;
        this.f17546f = h0Var;
        this.f17547g = String.valueOf(c0Var.hashCode());
        List<f0> a10 = c0Var.a();
        Objects.requireNonNull(a10);
        for (f0 id2 : a10) {
            this.f17548h.add(Integer.valueOf(id2.getId()));
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Rect a() {
        return this.f17542b;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f17544d;
    }

    /* access modifiers changed from: package-private */
    public h1.o c() {
        return this.f17541a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f17543c;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Matrix e() {
        return this.f17545e;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<Integer> f() {
        return this.f17548h;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String g() {
        return this.f17547g;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f17546f.isAborted();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return c() == null;
    }

    /* access modifiers changed from: package-private */
    public void j(@NonNull h1.p pVar) {
        this.f17546f.a(pVar);
    }

    /* access modifiers changed from: package-private */
    public void k(@NonNull o1 o1Var) {
        this.f17546f.c(o1Var);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f17546f.e();
    }

    /* access modifiers changed from: package-private */
    public void m(@NonNull ImageCaptureException imageCaptureException) {
        this.f17546f.b(imageCaptureException);
    }
}
