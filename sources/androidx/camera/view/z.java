package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.v1;
import androidx.camera.view.PreviewView;
import androidx.camera.view.l;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import u.c;
import u.f;

final class z extends l {

    /* renamed from: e  reason: collision with root package name */
    TextureView f3527e;

    /* renamed from: f  reason: collision with root package name */
    SurfaceTexture f3528f;

    /* renamed from: g  reason: collision with root package name */
    zf.a<SurfaceRequest.e> f3529g;

    /* renamed from: h  reason: collision with root package name */
    SurfaceRequest f3530h;

    /* renamed from: i  reason: collision with root package name */
    boolean f3531i = false;

    /* renamed from: j  reason: collision with root package name */
    SurfaceTexture f3532j;

    /* renamed from: k  reason: collision with root package name */
    AtomicReference<CallbackToFutureAdapter.a<Void>> f3533k = new AtomicReference<>();

    /* renamed from: l  reason: collision with root package name */
    l.a f3534l;

    /* renamed from: m  reason: collision with root package name */
    PreviewView.d f3535m;

    /* renamed from: n  reason: collision with root package name */
    Executor f3536n;

    class a implements TextureView.SurfaceTextureListener {

        /* renamed from: androidx.camera.view.z$a$a  reason: collision with other inner class name */
        class C0025a implements c<SurfaceRequest.e> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SurfaceTexture f3538a;

            C0025a(SurfaceTexture surfaceTexture) {
                this.f3538a = surfaceTexture;
            }

            /* renamed from: a */
            public void onSuccess(SurfaceRequest.e eVar) {
                boolean z10;
                if (eVar.a() != 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                h.j(z10, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                v1.a("TextureViewImpl", "SurfaceTexture about to manually be destroyed");
                this.f3538a.release();
                z zVar = z.this;
                if (zVar.f3532j != null) {
                    zVar.f3532j = null;
                }
            }

            public void onFailure(@NonNull Throwable th2) {
                throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th2);
            }
        }

        a() {
        }

        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i10, int i11) {
            v1.a("TextureViewImpl", "SurfaceTexture available. Size: " + i10 + "x" + i11);
            z zVar = z.this;
            zVar.f3528f = surfaceTexture;
            if (zVar.f3529g != null) {
                h.g(zVar.f3530h);
                v1.a("TextureViewImpl", "Surface invalidated " + z.this.f3530h);
                z.this.f3530h.k().c();
                return;
            }
            zVar.v();
        }

        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
            z zVar = z.this;
            zVar.f3528f = null;
            zf.a<SurfaceRequest.e> aVar = zVar.f3529g;
            if (aVar != null) {
                f.b(aVar, new C0025a(surfaceTexture), androidx.core.content.a.getMainExecutor(z.this.f3527e.getContext()));
                z.this.f3532j = surfaceTexture;
                return false;
            }
            v1.a("TextureViewImpl", "SurfaceTexture about to be destroyed");
            return true;
        }

        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i10, int i11) {
            v1.a("TextureViewImpl", "SurfaceTexture size changed: " + i10 + "x" + i11);
        }

        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
            CallbackToFutureAdapter.a andSet = z.this.f3533k.getAndSet((Object) null);
            if (andSet != null) {
                andSet.c(null);
            }
            z zVar = z.this;
            PreviewView.d dVar = zVar.f3535m;
            Executor executor = zVar.f3536n;
            if (dVar != null && executor != null) {
                executor.execute(new y(dVar, surfaceTexture));
            }
        }
    }

    z(@NonNull FrameLayout frameLayout, @NonNull f fVar) {
        super(frameLayout, fVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.f3530h;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.f3530h = null;
            this.f3529g = null;
        }
        t();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object q(Surface surface, CallbackToFutureAdapter.a aVar) throws Exception {
        v1.a("TextureViewImpl", "Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.f3530h;
        Executor a10 = androidx.camera.core.impl.utils.executor.a.a();
        Objects.requireNonNull(aVar);
        surfaceRequest.w(surface, a10, new t(aVar));
        return "provideSurface[request=" + this.f3530h + " surface=" + surface + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(Surface surface, zf.a aVar, SurfaceRequest surfaceRequest) {
        v1.a("TextureViewImpl", "Safe to release surface.");
        t();
        surface.release();
        if (this.f3529g == aVar) {
            this.f3529g = null;
        }
        if (this.f3530h == surfaceRequest) {
            this.f3530h = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f3533k.set(aVar);
        return "textureViewImpl_waitForNextFrame";
    }

    private void t() {
        l.a aVar = this.f3534l;
        if (aVar != null) {
            aVar.a();
            this.f3534l = null;
        }
    }

    private void u() {
        SurfaceTexture surfaceTexture;
        if (this.f3531i && this.f3532j != null && this.f3527e.getSurfaceTexture() != (surfaceTexture = this.f3532j)) {
            this.f3527e.setSurfaceTexture(surfaceTexture);
            this.f3532j = null;
            this.f3531i = false;
        }
    }

    /* access modifiers changed from: package-private */
    public View b() {
        return this.f3527e;
    }

    /* access modifiers changed from: package-private */
    public Bitmap c() {
        TextureView textureView = this.f3527e;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.f3527e.getBitmap();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        u();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f3531i = true;
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull SurfaceRequest surfaceRequest, l.a aVar) {
        this.f3496a = surfaceRequest.m();
        this.f3534l = aVar;
        o();
        SurfaceRequest surfaceRequest2 = this.f3530h;
        if (surfaceRequest2 != null) {
            surfaceRequest2.z();
        }
        this.f3530h = surfaceRequest;
        surfaceRequest.i(androidx.core.content.a.getMainExecutor(this.f3527e.getContext()), new u(this, surfaceRequest));
        v();
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull Executor executor, @NonNull PreviewView.d dVar) {
        this.f3535m = dVar;
        this.f3536n = executor;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<Void> j() {
        return CallbackToFutureAdapter.a(new x(this));
    }

    public void o() {
        h.g(this.f3497b);
        h.g(this.f3496a);
        TextureView textureView = new TextureView(this.f3497b.getContext());
        this.f3527e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.f3496a.getWidth(), this.f3496a.getHeight()));
        this.f3527e.setSurfaceTextureListener(new a());
        this.f3497b.removeAllViews();
        this.f3497b.addView(this.f3527e);
    }

    /* access modifiers changed from: package-private */
    public void v() {
        SurfaceTexture surfaceTexture;
        Size size = this.f3496a;
        if (size != null && (surfaceTexture = this.f3528f) != null && this.f3530h != null) {
            surfaceTexture.setDefaultBufferSize(size.getWidth(), this.f3496a.getHeight());
            Surface surface = new Surface(this.f3528f);
            SurfaceRequest surfaceRequest = this.f3530h;
            zf.a<SurfaceRequest.e> a10 = CallbackToFutureAdapter.a(new v(this, surface));
            this.f3529g = a10;
            a10.addListener(new w(this, surface, a10, surfaceRequest), androidx.core.content.a.getMainExecutor(this.f3527e.getContext()));
            f();
        }
    }
}
