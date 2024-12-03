package r;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.r1;
import q.d;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17223a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17224b = false;

    public l(@NonNull r1 r1Var) {
        boolean z10 = false;
        this.f17223a = r1Var.b(d.class) != null ? true : z10;
    }

    public void a() {
        this.f17224b = false;
    }

    public void b() {
        this.f17224b = true;
    }

    public boolean c(int i10) {
        return this.f17224b && i10 == 0 && this.f17223a;
    }
}
