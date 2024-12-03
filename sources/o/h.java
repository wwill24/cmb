package o;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.Executor;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final a f16689a;

    interface a {
        @NonNull
        CameraCaptureSession a();

        int b(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int c(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    static final class b extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        final CameraCaptureSession.CaptureCallback f16690a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f16691b;

        b(@NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) {
            this.f16691b = executor;
            this.f16690a = captureCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j10) {
            c.a(this.f16690a, cameraCaptureSession, captureRequest, surface, j10);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.f16690a.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.f16690a.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.f16690a.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(CameraCaptureSession cameraCaptureSession, int i10) {
            this.f16690a.onCaptureSequenceAborted(cameraCaptureSession, i10);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(CameraCaptureSession cameraCaptureSession, int i10, long j10) {
            this.f16690a.onCaptureSequenceCompleted(cameraCaptureSession, i10, j10);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j10, long j11) {
            this.f16690a.onCaptureStarted(cameraCaptureSession, captureRequest, j10, j11);
        }

        public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j10) {
            this.f16691b.execute(new j(this, cameraCaptureSession, captureRequest, surface, j10));
        }

        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            this.f16691b.execute(new m(this, cameraCaptureSession, captureRequest, totalCaptureResult));
        }

        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            this.f16691b.execute(new o(this, cameraCaptureSession, captureRequest, captureFailure));
        }

        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            this.f16691b.execute(new l(this, cameraCaptureSession, captureRequest, captureResult));
        }

        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i10) {
            this.f16691b.execute(new i(this, cameraCaptureSession, i10));
        }

        public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i10, long j10) {
            this.f16691b.execute(new k(this, cameraCaptureSession, i10, j10));
        }

        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j10, long j11) {
            this.f16691b.execute(new n(this, cameraCaptureSession, captureRequest, j10, j11));
        }
    }

    static final class c extends CameraCaptureSession.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        final CameraCaptureSession.StateCallback f16692a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f16693b;

        c(@NonNull Executor executor, @NonNull CameraCaptureSession.StateCallback stateCallback) {
            this.f16693b = executor;
            this.f16692a = stateCallback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(CameraCaptureSession cameraCaptureSession) {
            this.f16692a.onActive(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(CameraCaptureSession cameraCaptureSession) {
            e.b(this.f16692a, cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(CameraCaptureSession cameraCaptureSession) {
            this.f16692a.onClosed(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(CameraCaptureSession cameraCaptureSession) {
            this.f16692a.onConfigureFailed(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(CameraCaptureSession cameraCaptureSession) {
            this.f16692a.onConfigured(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(CameraCaptureSession cameraCaptureSession) {
            this.f16692a.onReady(cameraCaptureSession);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(CameraCaptureSession cameraCaptureSession, Surface surface) {
            b.a(this.f16692a, cameraCaptureSession, surface);
        }

        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
            this.f16693b.execute(new s(this, cameraCaptureSession));
        }

        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
            this.f16693b.execute(new r(this, cameraCaptureSession));
        }

        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            this.f16693b.execute(new q(this, cameraCaptureSession));
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            this.f16693b.execute(new t(this, cameraCaptureSession));
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            this.f16693b.execute(new p(this, cameraCaptureSession));
        }

        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            this.f16693b.execute(new u(this, cameraCaptureSession));
        }

        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
            this.f16693b.execute(new v(this, cameraCaptureSession, surface));
        }
    }

    private h(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f16689a = new y(cameraCaptureSession);
        } else {
            this.f16689a = z.d(cameraCaptureSession, handler);
        }
    }

    @NonNull
    public static h d(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Handler handler) {
        return new h(cameraCaptureSession, handler);
    }

    public int a(@NonNull List<CaptureRequest> list, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16689a.b(list, executor, captureCallback);
    }

    public int b(@NonNull CaptureRequest captureRequest, @NonNull Executor executor, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.f16689a.c(captureRequest, executor, captureCallback);
    }

    @NonNull
    public CameraCaptureSession c() {
        return this.f16689a.a();
    }
}
