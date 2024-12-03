package com.withpersona.sdk2.camera.camera2;

import android.graphics.Point;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.os.Handler;
import android.util.Size;
import android.view.Surface;
import gk.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import org.jivesoftware.smack.packet.Session;

public final class CameraCaptureSessionWrapper {

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f14300j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final f f14301a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Surface> f14302b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f14303c;

    /* renamed from: d  reason: collision with root package name */
    private final CameraCharacteristics f14304d;

    /* renamed from: e  reason: collision with root package name */
    private final k0 f14305e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14306f;

    /* renamed from: g  reason: collision with root package name */
    private MeteringRectangle f14307g;

    /* renamed from: h  reason: collision with root package name */
    private s1 f14308h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CameraCaptureSession f14309i;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(com.withpersona.sdk2.camera.camera2.f r13, android.hardware.camera2.CameraCharacteristics r14, java.util.List<? extends android.view.Surface> r15, android.hardware.camera2.CameraDevice r16, android.os.Handler r17, kotlin.coroutines.c<? super com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper> r18) {
            /*
                r12 = this;
                r0 = r18
                boolean r1 = r0 instanceof com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion$create$1
                if (r1 == 0) goto L_0x0016
                r1 = r0
                com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion$create$1 r1 = (com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion$create$1) r1
                int r2 = r1.label
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0016
                int r2 = r2 - r3
                r1.label = r2
                r2 = r12
                goto L_0x001c
            L_0x0016:
                com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion$create$1 r1 = new com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper$Companion$create$1
                r2 = r12
                r1.<init>(r12, r0)
            L_0x001c:
                java.lang.Object r0 = r1.result
                java.lang.Object r3 = kotlin.coroutines.intrinsics.b.d()
                int r4 = r1.label
                r5 = 1
                if (r4 == 0) goto L_0x003d
                if (r4 != r5) goto L_0x0035
                java.lang.Object r3 = r1.L$1
                com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper r3 = (com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper) r3
                java.lang.Object r1 = r1.L$0
                com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper r1 = (com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper) r1
                gk.g.b(r0)
                goto L_0x005e
            L_0x0035:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x003d:
                gk.g.b(r0)
                com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper r0 = new com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper
                r11 = 0
                r6 = r0
                r7 = r13
                r8 = r15
                r9 = r17
                r10 = r14
                r6.<init>(r7, r8, r9, r10, r11)
                r1.L$0 = r0
                r1.L$1 = r0
                r1.label = r5
                r4 = r16
                java.lang.Object r1 = r0.f(r4, r1)
                if (r1 != r3) goto L_0x005b
                return r3
            L_0x005b:
                r3 = r0
                r0 = r1
                r1 = r3
            L_0x005e:
                android.hardware.camera2.CameraCaptureSession r0 = (android.hardware.camera2.CameraCaptureSession) r0
                r3.f14309i = r0
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.CameraCaptureSessionWrapper.Companion.a(com.withpersona.sdk2.camera.camera2.f, android.hardware.camera2.CameraCharacteristics, java.util.List, android.hardware.camera2.CameraDevice, android.os.Handler, kotlin.coroutines.c):java.lang.Object");
        }
    }

    public static final class a extends CameraCaptureSession.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c<CameraCaptureSession> f14310a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CameraDevice f14311b;

        a(c<? super CameraCaptureSession> cVar, CameraDevice cameraDevice) {
            this.f14310a = cVar;
            this.f14311b = cameraDevice;
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            j.g(cameraCaptureSession, Session.ELEMENT);
            RuntimeException runtimeException = new RuntimeException("Camera " + this.f14311b.getId() + " session configuration failed");
            c<CameraCaptureSession> cVar = this.f14310a;
            Result.a aVar = Result.f32010a;
            cVar.resumeWith(Result.b(g.a(runtimeException)));
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            j.g(cameraCaptureSession, Session.ELEMENT);
            this.f14310a.resumeWith(Result.b(cameraCaptureSession));
        }

        public void onReady(CameraCaptureSession cameraCaptureSession) {
            j.g(cameraCaptureSession, Session.ELEMENT);
        }
    }

    private CameraCaptureSessionWrapper(f fVar, List<? extends Surface> list, Handler handler, CameraCharacteristics cameraCharacteristics) {
        this.f14301a = fVar;
        this.f14302b = list;
        this.f14303c = handler;
        this.f14304d = cameraCharacteristics;
        this.f14305e = l0.a(x0.a().e0(o2.b((s1) null, 1, (Object) null)));
    }

    public /* synthetic */ CameraCaptureSessionWrapper(f fVar, List list, Handler handler, CameraCharacteristics cameraCharacteristics, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, list, handler, cameraCharacteristics);
    }

    /* access modifiers changed from: private */
    public final void d() {
        this.f14307g = null;
    }

    /* access modifiers changed from: private */
    public final Object f(CameraDevice cameraDevice, c<? super CameraCaptureSession> cVar) {
        f fVar = new f(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        k(cameraDevice, this.f14302b, this.f14303c, new a(fVar, cameraDevice));
        Object b10 = fVar.b();
        if (b10 == b.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return b10;
    }

    private final CaptureRequest g(CameraCaptureSession cameraCaptureSession, boolean z10, List<? extends Surface> list) {
        CaptureRequest.Builder createCaptureRequest = cameraCaptureSession.getDevice().createCaptureRequest(1);
        for (Surface addTarget : list) {
            createCaptureRequest.addTarget(addTarget);
        }
        createCaptureRequest.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.f14301a.d());
        if (z10 && Build.VERSION.SDK_INT >= 33) {
            createCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        }
        if (this.f14306f) {
            createCaptureRequest.set(CaptureRequest.FLASH_MODE, 2);
        }
        MeteringRectangle meteringRectangle = this.f14307g;
        if (meteringRectangle != null && h()) {
            createCaptureRequest.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        CaptureRequest build = createCaptureRequest.build();
        j.f(build, "session.device.createCap…t))\n      }\n    }.build()");
        return build;
    }

    private final boolean h() {
        Integer num = (Integer) this.f14304d.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num == null) {
            num = 0;
        }
        return num.intValue() >= 1;
    }

    private final boolean k(CameraDevice cameraDevice, List<? extends Surface> list, Handler handler, CameraCaptureSession.StateCallback stateCallback) {
        if (Build.VERSION.SDK_INT >= 33) {
            ArrayList arrayList = new ArrayList();
            for (Surface outputConfiguration : list) {
                OutputConfiguration outputConfiguration2 = new OutputConfiguration(outputConfiguration);
                outputConfiguration2.setDynamicRangeProfile(this.f14301a.a().a());
                arrayList.add(outputConfiguration2);
            }
            cameraDevice.createCaptureSessionByOutputConfigurations(arrayList, stateCallback, handler);
            return true;
        }
        cameraDevice.createCaptureSession(list, stateCallback, handler);
        return false;
    }

    public final void e() {
        l0.f(this.f14305e, (CancellationException) null, 1, (Object) null);
    }

    public final void i(boolean z10) {
        this.f14306f = z10;
    }

    public final void j(int i10, int i11, Size size, long j10) {
        j.g(size, "size");
        this.f14307g = new MeteringRectangle(new Point(i10, i11), size, 1000);
        s1 s1Var = this.f14308h;
        if (s1Var != null) {
            s1.a.a(s1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f14308h = j.d(this.f14305e, (CoroutineContext) null, (CoroutineStart) null, new CameraCaptureSessionWrapper$setFocus$1(j10, this, (c<? super CameraCaptureSessionWrapper$setFocus$1>) null), 3, (Object) null);
    }

    public final void l() {
        CameraCaptureSession cameraCaptureSession = this.f14309i;
        if (cameraCaptureSession == null) {
            j.y(Session.ELEMENT);
            cameraCaptureSession = null;
        }
        CaptureRequest g10 = g(cameraCaptureSession, this.f14301a.a().b(), this.f14302b);
        CameraCaptureSession cameraCaptureSession2 = this.f14309i;
        if (cameraCaptureSession2 == null) {
            j.y(Session.ELEMENT);
            cameraCaptureSession2 = null;
        }
        cameraCaptureSession2.setRepeatingRequest(g10, (CameraCaptureSession.CaptureCallback) null, this.f14303c);
    }
}
