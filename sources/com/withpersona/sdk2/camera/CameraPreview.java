package com.withpersona.sdk2.camera;

import android.content.Context;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.d0;
import androidx.camera.core.f0;
import androidx.camera.core.f2;
import androidx.camera.core.f3;
import androidx.camera.core.h1;
import androidx.camera.core.l;
import androidx.camera.core.l0;
import androidx.camera.core.r;
import androidx.camera.lifecycle.e;
import androidx.camera.video.Recorder;
import androidx.camera.video.g0;
import androidx.camera.video.q;
import androidx.camera.view.PreviewView;
import com.mparticle.identity.IdentityHttpResponse;
import gk.g;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

public final class CameraPreview {

    /* renamed from: a  reason: collision with root package name */
    private l f14107a;

    /* renamed from: b  reason: collision with root package name */
    private h1 f14108b;

    /* renamed from: c  reason: collision with root package name */
    private Recorder f14109c;

    /* renamed from: d  reason: collision with root package name */
    private RecordingHelper f14110d;

    public enum CameraDirection {
        FRONT,
        BACK
    }

    public static final class a implements h1.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c<Result<? extends File>> f14114a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f14115b;

        a(c<? super Result<? extends File>> cVar, File file) {
            this.f14114a = cVar;
            this.f14115b = file;
        }

        public void a(h1.p pVar) {
            j.g(pVar, "outputFileResults");
            c<Result<? extends File>> cVar = this.f14114a;
            Result.a aVar = Result.f32010a;
            cVar.resumeWith(Result.b(Result.a(Result.b(this.f14115b))));
        }

        public void b(ImageCaptureException imageCaptureException) {
            j.g(imageCaptureException, "exception");
            c<Result<? extends File>> cVar = this.f14114a;
            Result.a aVar = Result.f32010a;
            cVar.resumeWith(Result.b(Result.a(Result.b(g.a(imageCaptureException)))));
        }
    }

    public static /* synthetic */ void f(CameraPreview cameraPreview, PreviewView previewView, CameraDirection cameraDirection, l0.a aVar, boolean z10, boolean z11, Function1 function1, int i10, Object obj) {
        cameraPreview.e(previewView, cameraDirection, aVar, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11, function1);
    }

    /* access modifiers changed from: private */
    public static final void g(PreviewView previewView, boolean z10, l0.a aVar, boolean z11, CameraPreview cameraPreview, r rVar, Function1 function1) {
        PreviewView previewView2 = previewView;
        j.g(previewView, "$previewView");
        j.g(cameraPreview, "this$0");
        j.g(rVar, "$cameraSelector");
        j.g(function1, "$onCameraError");
        if (previewView.isAttachedToWindow()) {
            Context context = previewView.getContext();
            j.f(context, "previewView.context");
            androidx.appcompat.app.a p02 = p.b(context).p0();
            if (p02 != null) {
                p02.l();
            }
            int rotation = previewView.getDisplay().getRotation();
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            zf.a<e> f10 = e.f(previewView.getContext());
            j.f(f10, "getInstance(previewView.context)");
            f10.addListener(new l(f10, rotation, z10, aVar, newSingleThreadExecutor, z11, cameraPreview, previewView, rVar, function1), androidx.core.content.a.getMainExecutor(previewView.getContext()));
        }
    }

    /* access modifiers changed from: private */
    public static final void h(zf.a aVar, int i10, boolean z10, l0.a aVar2, ExecutorService executorService, boolean z11, CameraPreview cameraPreview, PreviewView previewView, r rVar, Function1 function1) {
        j.g(aVar, "$cameraProviderFuture");
        j.g(cameraPreview, "this$0");
        j.g(previewView, "$previewView");
        j.g(rVar, "$cameraSelector");
        j.g(function1, "$onCameraError");
        e eVar = (e) aVar.get();
        f2 c10 = new f2.b().j(i10).c();
        j.f(c10, "Builder()\n            .s…ion)\n            .build()");
        f3.a aVar3 = new f3.a();
        aVar3.a(c10);
        if (z10) {
            h1 c11 = new h1.h().f(1).k(i10).c();
            cameraPreview.f14108b = c11;
            j.f(c11, "Builder()\n              …ture = it\n              }");
            aVar3.a(c11);
        }
        if (aVar2 != null) {
            l0 c12 = new l0.c().g(0).l(new Size(2000, 2000)).m(i10).c();
            j.f(c12, "Builder()\n              …n)\n              .build()");
            c12.Z(executorService, aVar2);
            aVar3.a(c12);
        }
        if (z11) {
            Recorder b10 = new Recorder.g().d(executorService).e(androidx.camera.video.r.d(q.f3408f)).b();
            cameraPreview.f14109c = b10;
            j.f(b10, "Builder()\n              …rder = it\n              }");
            g0 z02 = g0.z0(b10);
            j.f(z02, "withOutput(recorder)");
            aVar3.a(z02);
        }
        eVar.m();
        try {
            Context context = previewView.getContext();
            j.f(context, "previewView.context");
            cameraPreview.f14107a = eVar.d(p.b(context), rVar, aVar3.b());
            Context context2 = previewView.getContext();
            j.e(context2, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            ((androidx.lifecycle.l) context2).getLifecycle().a(new CameraPreview$rebind$1$1$1(executorService));
            c10.X(previewView.getSurfaceProvider());
        } catch (IllegalArgumentException unused) {
            function1.invoke(new NoSuitableCameraError());
        }
    }

    public final void c(boolean z10) {
        l lVar = this.f14107a;
        if (lVar != null) {
            lVar.a().a(z10);
        }
    }

    public final void d(PreviewView previewView) {
        j.g(previewView, "previewView");
        l lVar = this.f14107a;
        if (lVar != null) {
            lVar.a().g(new f0.a(new d0(previewView.getDisplay(), lVar.b(), (float) previewView.getWidth(), (float) previewView.getHeight()).b(((float) previewView.getWidth()) / 2.0f, ((float) previewView.getHeight()) / 2.0f), 1).b());
        }
    }

    public final void e(PreviewView previewView, CameraDirection cameraDirection, l0.a aVar, boolean z10, boolean z11, Function1<? super CameraError, Unit> function1) {
        int i10;
        j.g(previewView, "previewView");
        j.g(cameraDirection, "cameraDirection");
        j.g(function1, "onCameraError");
        r.a aVar2 = new r.a();
        if (cameraDirection == CameraDirection.FRONT) {
            i10 = 0;
        } else {
            i10 = 1;
        }
        r b10 = aVar2.d(i10).b();
        j.f(b10, "Builder()\n      .require…        }\n      ).build()");
        previewView.post(new k(previewView, z10, aVar, z11, this, b10, function1));
    }

    public final boolean i(Context context) {
        RecordingHelper recordingHelper;
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (this.f14110d != null) {
            return false;
        }
        Recorder recorder = this.f14109c;
        if (recorder != null) {
            recordingHelper = RecordingHelper.f14179f.a(recorder, context);
        } else {
            recordingHelper = null;
        }
        this.f14110d = recordingHelper;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.CameraPreview$stopVideo$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.CameraPreview$stopVideo$1 r0 = (com.withpersona.sdk2.camera.CameraPreview$stopVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.CameraPreview$stopVideo$1 r0 = new com.withpersona.sdk2.camera.CameraPreview$stopVideo$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r0 = r0.L$0
            com.withpersona.sdk2.camera.CameraPreview r0 = (com.withpersona.sdk2.camera.CameraPreview) r0
            gk.g.b(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.j()
            goto L_0x005d
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x003b:
            gk.g.b(r5)
            com.withpersona.sdk2.camera.RecordingHelper r5 = r4.f14110d
            if (r5 == 0) goto L_0x004d
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.e(r0)
            if (r5 != r1) goto L_0x005c
            return r1
        L_0x004d:
            kotlin.Result$a r5 = kotlin.Result.f32010a
            com.withpersona.sdk2.camera.NoActiveRecordingError r5 = new com.withpersona.sdk2.camera.NoActiveRecordingError
            r5.<init>()
            java.lang.Object r5 = gk.g.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L_0x005c:
            r0 = r4
        L_0x005d:
            r1 = 0
            r0.f14110d = r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.CameraPreview.j(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(android.content.Context r7, kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.withpersona.sdk2.camera.CameraPreview$takePicture$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.withpersona.sdk2.camera.CameraPreview$takePicture$1 r0 = (com.withpersona.sdk2.camera.CameraPreview$takePicture$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.CameraPreview$takePicture$1 r0 = new com.withpersona.sdk2.camera.CameraPreview$takePicture$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r7 = r0.L$1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r7 = r0.L$0
            com.withpersona.sdk2.camera.CameraPreview r7 = (com.withpersona.sdk2.camera.CameraPreview) r7
            gk.g.b(r8)
            goto L_0x00a4
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            gk.g.b(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            kotlin.coroutines.f r8 = new kotlin.coroutines.f
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)
            r8.<init>(r2)
            java.io.File r2 = new java.io.File
            java.io.File r7 = r7.getCacheDir()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "persona_camera_"
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            r3.append(r4)
            java.lang.String r4 = ".jpg"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r7, r3)
            androidx.camera.core.h1$o$a r7 = new androidx.camera.core.h1$o$a
            r7.<init>(r2)
            androidx.camera.core.h1$o r7 = r7.a()
            java.lang.String r3 = "Builder(file).build()"
            kotlin.jvm.internal.j.f(r7, r3)
            androidx.camera.core.h1 r3 = r6.f14108b
            if (r3 == 0) goto L_0x0094
            kotlinx.coroutines.c2 r4 = kotlinx.coroutines.x0.c()
            kotlinx.coroutines.c2 r4 = r4.Y()
            java.util.concurrent.Executor r4 = kotlinx.coroutines.k1.a(r4)
            com.withpersona.sdk2.camera.CameraPreview$a r5 = new com.withpersona.sdk2.camera.CameraPreview$a
            r5.<init>(r8, r2)
            r3.z0(r7, r4, r5)
        L_0x0094:
            java.lang.Object r8 = r8.b()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.b.d()
            if (r8 != r7) goto L_0x00a1
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x00a1:
            if (r8 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r7 = r8.j()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.CameraPreview.k(android.content.Context, kotlin.coroutines.c):java.lang.Object");
    }
}
