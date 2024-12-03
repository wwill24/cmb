package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.utils.p;
import androidx.camera.core.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.t;
import java.util.concurrent.Executor;
import o.c0;
import r.f;
import zf.a;

final class i3 {

    /* renamed from: a  reason: collision with root package name */
    private final t f1808a;

    /* renamed from: b  reason: collision with root package name */
    private final t<Integer> f1809b = new t<>(0);

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1810c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f1811d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1812e;

    /* renamed from: f  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f1813f;

    /* renamed from: g  reason: collision with root package name */
    boolean f1814g;

    i3(@NonNull t tVar, @NonNull c0 c0Var, @NonNull Executor executor) {
        this.f1808a = tVar;
        this.f1811d = executor;
        this.f1810c = f.c(c0Var);
        tVar.t(new g3(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object h(boolean z10, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f1811d.execute(new h3(this, aVar, z10));
        return "enableTorch: " + z10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean i(TotalCaptureResult totalCaptureResult) {
        boolean z10;
        if (this.f1813f != null) {
            Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
            if (num == null || num.intValue() != 2) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 == this.f1814g) {
                this.f1813f.c(null);
                this.f1813f = null;
            }
        }
        return false;
    }

    private <T> void k(@NonNull t<T> tVar, T t10) {
        if (p.b()) {
            tVar.o(t10);
        } else {
            tVar.m(t10);
        }
    }

    /* access modifiers changed from: package-private */
    public a<Void> d(boolean z10) {
        if (!this.f1810c) {
            v1.a("TorchControl", "Unable to enableTorch due to there is no flash unit.");
            return u.f.f(new IllegalStateException("No flash unit"));
        }
        k(this.f1809b, Integer.valueOf(z10 ? 1 : 0));
        return CallbackToFutureAdapter.a(new f3(this, z10));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void g(CallbackToFutureAdapter.a<Void> aVar, boolean z10) {
        if (!this.f1810c) {
            if (aVar != null) {
                aVar.f(new IllegalStateException("No flash unit"));
            }
        } else if (!this.f1812e) {
            k(this.f1809b, 0);
            if (aVar != null) {
                aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        } else {
            this.f1814g = z10;
            this.f1808a.w(z10);
            k(this.f1809b, Integer.valueOf(z10 ? 1 : 0));
            CallbackToFutureAdapter.a<Void> aVar2 = this.f1813f;
            if (aVar2 != null) {
                aVar2.f(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
            }
            this.f1813f = aVar;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public LiveData<Integer> f() {
        return this.f1809b;
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z10) {
        if (this.f1812e != z10) {
            this.f1812e = z10;
            if (!z10) {
                if (this.f1814g) {
                    this.f1814g = false;
                    this.f1808a.w(false);
                    k(this.f1809b, 0);
                }
                CallbackToFutureAdapter.a<Void> aVar = this.f1813f;
                if (aVar != null) {
                    aVar.f(new CameraControl.OperationCanceledException("Camera is not active."));
                    this.f1813f = null;
                }
            }
        }
    }
}
