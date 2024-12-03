package t;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.o1;
import androidx.core.util.h;
import java.util.Objects;
import t.a0;
import t.m;

class g0 {

    /* renamed from: a  reason: collision with root package name */
    private b0 f17568a;

    /* renamed from: b  reason: collision with root package name */
    private a0.a f17569b;

    g0() {
    }

    /* access modifiers changed from: private */
    public void c(@NonNull o1 o1Var) {
        boolean z10;
        p.a();
        boolean z11 = true;
        if (this.f17568a != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.i(z10);
        Object c10 = o1Var.z1().c().c(this.f17568a.g());
        Objects.requireNonNull(c10);
        if (((Integer) c10).intValue() != this.f17568a.f().get(0).intValue()) {
            z11 = false;
        }
        h.i(z11);
        this.f17569b.a().accept(a0.b.c(this.f17568a, o1Var));
        this.f17568a = null;
    }

    /* access modifiers changed from: private */
    public void e(@NonNull b0 b0Var) {
        boolean z10;
        p.a();
        boolean z11 = false;
        if (b0Var.f().size() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        h.j(z10, "Cannot handle multi-image capture.");
        if (this.f17568a == null) {
            z11 = true;
        }
        h.j(z11, "Already has an existing request.");
        this.f17568a = b0Var;
    }

    public void d() {
    }

    @NonNull
    public a0.a f(@NonNull m.b bVar) {
        bVar.b().a(new e0(this));
        bVar.c().a(new f0(this));
        a0.a c10 = a0.a.c(bVar.a());
        this.f17569b = c10;
        return c10;
    }
}
