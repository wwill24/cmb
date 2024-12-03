package t;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.h1;
import androidx.camera.core.impl.n;
import androidx.camera.core.o1;
import androidx.core.util.h;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public abstract class p0 {
    /* access modifiers changed from: private */
    public /* synthetic */ void n(ImageCaptureException imageCaptureException) {
        boolean z10;
        boolean z11 = true;
        if (g() != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i() == null) {
            z11 = false;
        }
        if (z10 && !z11) {
            h1.m g10 = g();
            Objects.requireNonNull(g10);
            g10.b(imageCaptureException);
        } else if (!z11 || z10) {
            throw new IllegalStateException("One and only one callback is allowed.");
        } else {
            h1.n i10 = i();
            Objects.requireNonNull(i10);
            i10.b(imageCaptureException);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(h1.p pVar) {
        h1.n i10 = i();
        Objects.requireNonNull(i10);
        Objects.requireNonNull(pVar);
        i10.a(pVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(o1 o1Var) {
        h1.m g10 = g();
        Objects.requireNonNull(g10);
        Objects.requireNonNull(o1Var);
        g10.a(o1Var);
    }

    @NonNull
    public static p0 q(@NonNull Executor executor, h1.m mVar, h1.n nVar, h1.o oVar, @NonNull Rect rect, @NonNull Matrix matrix, int i10, int i11, int i12, @NonNull List<n> list) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        if (nVar == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (oVar == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 == z11) {
            z12 = true;
        } else {
            z12 = false;
        }
        h.b(z12, "onDiskCallback and outputFileOptions should be both null or both non-null.");
        if (nVar == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (mVar != null) {
            z14 = false;
        }
        h.b(z14 ^ z13, "One and only one on-disk or in-memory callback should be present.");
        return new h(executor, mVar, nVar, oVar, rect, matrix, i10, i11, i12, list);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Executor d();

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Rect f();

    /* access modifiers changed from: package-private */
    public abstract h1.m g();

    /* access modifiers changed from: package-private */
    public abstract int h();

    /* access modifiers changed from: package-private */
    public abstract h1.n i();

    /* access modifiers changed from: package-private */
    public abstract h1.o j();

    /* access modifiers changed from: package-private */
    public abstract int k();

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract Matrix l();

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract List<n> m();

    /* access modifiers changed from: package-private */
    public void r(@NonNull ImageCaptureException imageCaptureException) {
        d().execute(new o0(this, imageCaptureException));
    }

    /* access modifiers changed from: package-private */
    public void s(h1.p pVar) {
        d().execute(new m0(this, pVar));
    }

    /* access modifiers changed from: package-private */
    public void t(o1 o1Var) {
        d().execute(new n0(this, o1Var));
    }
}
