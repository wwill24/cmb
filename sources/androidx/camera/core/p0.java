package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.x0;
import u.c;
import u.f;

final class p0 extends o0 {

    class a implements c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ o1 f2853a;

        a(o1 o1Var) {
            this.f2853a = o1Var;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(@NonNull Throwable th2) {
            this.f2853a.close();
        }
    }

    p0() {
    }

    /* access modifiers changed from: package-private */
    public o1 d(@NonNull x0 x0Var) {
        return x0Var.g();
    }

    /* access modifiers changed from: package-private */
    public void g() {
    }

    /* access modifiers changed from: package-private */
    public void o(@NonNull o1 o1Var) {
        f.b(e(o1Var), new a(o1Var), androidx.camera.core.impl.utils.executor.a.a());
    }
}
