package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.r2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.b;
import o.e;

final class e3 extends r2.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<r2.a> f1736a;

    e3(@NonNull List<r2.a> list) {
        ArrayList arrayList = new ArrayList();
        this.f1736a = arrayList;
        arrayList.addAll(list);
    }

    @NonNull
    static r2.a v(@NonNull r2.a... aVarArr) {
        return new e3(Arrays.asList(aVarArr));
    }

    public void n(@NonNull r2 r2Var) {
        for (r2.a n10 : this.f1736a) {
            n10.n(r2Var);
        }
    }

    public void o(@NonNull r2 r2Var) {
        for (r2.a o10 : this.f1736a) {
            o10.o(r2Var);
        }
    }

    public void p(@NonNull r2 r2Var) {
        for (r2.a p10 : this.f1736a) {
            p10.p(r2Var);
        }
    }

    public void q(@NonNull r2 r2Var) {
        for (r2.a q10 : this.f1736a) {
            q10.q(r2Var);
        }
    }

    public void r(@NonNull r2 r2Var) {
        for (r2.a r10 : this.f1736a) {
            r10.r(r2Var);
        }
    }

    public void s(@NonNull r2 r2Var) {
        for (r2.a s10 : this.f1736a) {
            s10.s(r2Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(@NonNull r2 r2Var) {
        for (r2.a t10 : this.f1736a) {
            t10.t(r2Var);
        }
    }

    public void u(@NonNull r2 r2Var, @NonNull Surface surface) {
        for (r2.a u10 : this.f1736a) {
            u10.u(r2Var, surface);
        }
    }

    static class a extends r2.a {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final CameraCaptureSession.StateCallback f1737a;

        a(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.f1737a = stateCallback;
        }

        public void n(@NonNull r2 r2Var) {
            this.f1737a.onActive(r2Var.k().c());
        }

        public void o(@NonNull r2 r2Var) {
            e.b(this.f1737a, r2Var.k().c());
        }

        public void p(@NonNull r2 r2Var) {
            this.f1737a.onClosed(r2Var.k().c());
        }

        public void q(@NonNull r2 r2Var) {
            this.f1737a.onConfigureFailed(r2Var.k().c());
        }

        public void r(@NonNull r2 r2Var) {
            this.f1737a.onConfigured(r2Var.k().c());
        }

        public void s(@NonNull r2 r2Var) {
            this.f1737a.onReady(r2Var.k().c());
        }

        /* access modifiers changed from: package-private */
        public void t(@NonNull r2 r2Var) {
        }

        public void u(@NonNull r2 r2Var, @NonNull Surface surface) {
            b.a(this.f1737a, r2Var.k().c(), surface);
        }

        a(@NonNull List<CameraCaptureSession.StateCallback> list) {
            this(g1.a(list));
        }
    }
}
