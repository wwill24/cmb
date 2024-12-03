package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.v1;
import androidx.camera.view.PreviewView;
import androidx.camera.view.l;
import androidx.core.util.h;
import java.util.concurrent.Executor;
import u.f;

final class r extends l {

    /* renamed from: e  reason: collision with root package name */
    SurfaceView f3506e;

    /* renamed from: f  reason: collision with root package name */
    final b f3507f = new b();

    /* renamed from: g  reason: collision with root package name */
    private l.a f3508g;

    private static class a {
        static void a(@NonNull SurfaceView surfaceView, @NonNull Bitmap bitmap, @NonNull PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, @NonNull Handler handler) {
            PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
        }
    }

    class b implements SurfaceHolder.Callback {

        /* renamed from: a  reason: collision with root package name */
        private Size f3509a;

        /* renamed from: b  reason: collision with root package name */
        private SurfaceRequest f3510b;

        /* renamed from: c  reason: collision with root package name */
        private Size f3511c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3512d = false;

        b() {
        }

        private boolean b() {
            Size size;
            if (this.f3512d || this.f3510b == null || (size = this.f3509a) == null || !size.equals(this.f3511c)) {
                return false;
            }
            return true;
        }

        private void c() {
            if (this.f3510b != null) {
                v1.a("SurfaceViewImpl", "Request canceled: " + this.f3510b);
                this.f3510b.z();
            }
        }

        private void d() {
            if (this.f3510b != null) {
                v1.a("SurfaceViewImpl", "Surface invalidated " + this.f3510b);
                this.f3510b.k().c();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(SurfaceRequest.e eVar) {
            v1.a("SurfaceViewImpl", "Safe to release surface.");
            r.this.p();
        }

        private boolean g() {
            Surface surface = r.this.f3506e.getHolder().getSurface();
            if (!b()) {
                return false;
            }
            v1.a("SurfaceViewImpl", "Surface set on Preview.");
            this.f3510b.w(surface, androidx.core.content.a.getMainExecutor(r.this.f3506e.getContext()), new s(this));
            this.f3512d = true;
            r.this.f();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void f(@NonNull SurfaceRequest surfaceRequest) {
            c();
            this.f3510b = surfaceRequest;
            Size m10 = surfaceRequest.m();
            this.f3509a = m10;
            this.f3512d = false;
            if (!g()) {
                v1.a("SurfaceViewImpl", "Wait for new Surface creation.");
                r.this.f3506e.getHolder().setFixedSize(m10.getWidth(), m10.getHeight());
            }
        }

        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
            v1.a("SurfaceViewImpl", "Surface changed. Size: " + i11 + "x" + i12);
            this.f3511c = new Size(i11, i12);
            g();
        }

        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            v1.a("SurfaceViewImpl", "Surface created.");
        }

        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            v1.a("SurfaceViewImpl", "Surface destroyed.");
            if (this.f3512d) {
                d();
            } else {
                c();
            }
            this.f3512d = false;
            this.f3510b = null;
            this.f3511c = null;
            this.f3509a = null;
        }
    }

    r(@NonNull FrameLayout frameLayout, @NonNull f fVar) {
        super(frameLayout, fVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(int i10) {
        if (i10 == 0) {
            v1.a("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
            return;
        }
        v1.c("SurfaceViewImpl", "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(SurfaceRequest surfaceRequest) {
        this.f3507f.f(surfaceRequest);
    }

    /* access modifiers changed from: package-private */
    public View b() {
        return this.f3506e;
    }

    /* access modifiers changed from: package-private */
    public Bitmap c() {
        SurfaceView surfaceView = this.f3506e;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.f3506e.getHolder().getSurface().isValid()) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.f3506e.getWidth(), this.f3506e.getHeight(), Bitmap.Config.ARGB_8888);
        a.a(this.f3506e, createBitmap, new q(), this.f3506e.getHandler());
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    public void d() {
    }

    /* access modifiers changed from: package-private */
    public void e() {
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull SurfaceRequest surfaceRequest, l.a aVar) {
        this.f3496a = surfaceRequest.m();
        this.f3508g = aVar;
        m();
        surfaceRequest.i(androidx.core.content.a.getMainExecutor(this.f3506e.getContext()), new o(this));
        this.f3506e.post(new p(this, surfaceRequest));
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull Executor executor, @NonNull PreviewView.d dVar) {
        throw new IllegalArgumentException("SurfaceView doesn't support frame update listener");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<Void> j() {
        return f.h(null);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        h.g(this.f3497b);
        h.g(this.f3496a);
        SurfaceView surfaceView = new SurfaceView(this.f3497b.getContext());
        this.f3506e = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.f3496a.getWidth(), this.f3496a.getHeight()));
        this.f3497b.removeAllViews();
        this.f3497b.addView(this.f3506e);
        this.f3506e.getHolder().addCallback(this.f3507f);
    }

    /* access modifiers changed from: package-private */
    public void p() {
        l.a aVar = this.f3508g;
        if (aVar != null) {
            aVar.a();
            this.f3508g = null;
        }
    }
}
