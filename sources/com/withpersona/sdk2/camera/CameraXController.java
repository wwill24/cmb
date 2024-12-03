package com.withpersona.sdk2.camera;

import android.content.Context;
import androidx.camera.view.PreviewView;
import androidx.lifecycle.u;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.camera.n;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.flow.s;

public final class CameraXController implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14118a;

    /* renamed from: b  reason: collision with root package name */
    private final CameraPreview f14119b;

    /* renamed from: c  reason: collision with root package name */
    private final PreviewView f14120c;

    /* renamed from: d  reason: collision with root package name */
    private final o f14121d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14122e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public i<n> f14123f = s.a(n.c.f14369a);

    public static final class a implements u<PreviewView.StreamState> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CameraXController f14124a;

        a(CameraXController cameraXController) {
            this.f14124a = cameraXController;
        }

        /* renamed from: a */
        public void b(PreviewView.StreamState streamState) {
            j.g(streamState, "value");
            if (streamState == PreviewView.StreamState.STREAMING) {
                this.f14124a.f14123f.setValue(n.e.f14371a);
                this.f14124a.d().getPreviewStreamState().n(this);
            }
        }
    }

    public CameraXController(Context context, CameraPreview cameraPreview, PreviewView previewView, o oVar) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(cameraPreview, "cameraPreview");
        j.g(previewView, "previewView");
        j.g(oVar, "cameraXBinder");
        this.f14118a = context;
        this.f14119b = cameraPreview;
        this.f14120c = previewView;
        this.f14121d = oVar;
    }

    public void a(boolean z10) {
        this.f14119b.c(z10);
    }

    public Object b(c<? super Boolean> cVar) {
        return kotlin.coroutines.jvm.internal.a.a(this.f14119b.i(this.f14118a));
    }

    public r<n> c() {
        return this.f14123f;
    }

    public void e() {
        this.f14119b.d(d());
    }

    public void f(boolean z10) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object g(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.CameraXController$stopVideo$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.CameraXController$stopVideo$1 r0 = (com.withpersona.sdk2.camera.CameraXController$stopVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.CameraXController$stopVideo$1 r0 = new com.withpersona.sdk2.camera.CameraXController$stopVideo$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            gk.g.b(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.j()
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            gk.g.b(r5)
            com.withpersona.sdk2.camera.CameraPreview r5 = r4.f14119b
            r0.label = r3
            java.lang.Object r5 = r5.j(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.CameraXController.g(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.CameraXController$takePicture$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.CameraXController$takePicture$1 r0 = (com.withpersona.sdk2.camera.CameraXController$takePicture$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.CameraXController$takePicture$1 r0 = new com.withpersona.sdk2.camera.CameraXController$takePicture$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            gk.g.b(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.j()
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            gk.g.b(r5)
            com.withpersona.sdk2.camera.CameraPreview r5 = r4.f14119b
            android.content.Context r2 = r4.f14118a
            r0.label = r3
            java.lang.Object r5 = r5.k(r2, r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.CameraXController.h(kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: j */
    public PreviewView d() {
        return this.f14120c;
    }

    public void prepare() {
        if (!this.f14122e) {
            this.f14123f.setValue(n.d.f14370a);
            this.f14122e = true;
            this.f14121d.a();
            d().getPreviewStreamState().j(new a(this));
        }
    }
}
