package r;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.j0;
import androidx.camera.camera2.internal.r2;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.r1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.List;
import p.k;
import q.i;
import u.d;
import u.f;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17237a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f17238b = new Object();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final zf.a<Void> f17239c;

    /* renamed from: d  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f17240d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17241e;

    /* renamed from: f  reason: collision with root package name */
    private final CameraCaptureSession.CaptureCallback f17242f = new a();

    class a extends CameraCaptureSession.CaptureCallback {
        a() {
        }

        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i10) {
            CallbackToFutureAdapter.a<Void> aVar = v.this.f17240d;
            if (aVar != null) {
                aVar.d();
                v.this.f17240d = null;
            }
        }

        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j10, long j11) {
            CallbackToFutureAdapter.a<Void> aVar = v.this.f17240d;
            if (aVar != null) {
                aVar.c(null);
                v.this.f17240d = null;
            }
        }
    }

    @FunctionalInterface
    public interface b {
        @NonNull
        zf.a<Void> a(@NonNull CameraDevice cameraDevice, @NonNull k kVar, @NonNull List<DeferrableSurface> list);
    }

    @FunctionalInterface
    public interface c {
        int a(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    public v(@NonNull r1 r1Var) {
        this.f17237a = r1Var.a(i.class);
        if (i()) {
            this.f17239c = CallbackToFutureAdapter.a(new t(this));
        } else {
            this.f17239c = f.h(null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object d(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f17240d = aVar;
        return "WaitForRepeatingRequestStart[" + this + "]";
    }

    @NonNull
    public zf.a<Void> c() {
        return f.j(this.f17239c);
    }

    public void f() {
        synchronized (this.f17238b) {
            if (i() && !this.f17241e) {
                this.f17239c.cancel(true);
            }
        }
    }

    @NonNull
    public zf.a<Void> g(@NonNull CameraDevice cameraDevice, @NonNull k kVar, @NonNull List<DeferrableSurface> list, @NonNull List<r2> list2, @NonNull b bVar) {
        ArrayList arrayList = new ArrayList();
        for (r2 m10 : list2) {
            arrayList.add(m10.m());
        }
        return d.a(f.n(arrayList)).e(new u(bVar, cameraDevice, kVar, list), androidx.camera.core.impl.utils.executor.a.a());
    }

    public int h(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback, @NonNull c cVar) throws CameraAccessException {
        int a10;
        synchronized (this.f17238b) {
            if (i()) {
                captureCallback = j0.b(this.f17242f, captureCallback);
                this.f17241e = true;
            }
            a10 = cVar.a(captureRequest, captureCallback);
        }
        return a10;
    }

    public boolean i() {
        return this.f17237a;
    }
}
